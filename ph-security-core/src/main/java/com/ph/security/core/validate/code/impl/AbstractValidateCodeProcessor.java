package com.ph.security.core.validate.code.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import com.ph.security.core.validate.code.ValidateCode;
import com.ph.security.core.validate.code.ValidateCodeException;
import com.ph.security.core.validate.code.ValidateCodeGenerator;
import com.ph.security.core.validate.code.ValidateCodeProcessor;
import com.ph.security.core.validate.code.ValidateCodeType;

public abstract class AbstractValidateCodeProcessor<C extends ValidateCode> implements ValidateCodeProcessor {

	/**
	 * 验证码放入session时的前缀
	 */
	String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";
	
	/**
	 * 操作session的工具类
	 */
	private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
	
	/**
	 * 收集系统中所有的 {@link ValidateCodeGenerator} 接口的实现。
	 * 可以将所有实现ValidateCodeGenerator的类放在这个集合中
	 */
	@Autowired
	private Map<String, ValidateCodeGenerator> validateCodeGenerators;
	
	/* 一般一个验证码的操作需要进行三步步骤：
	 *	1.生成验证码
	 *	2.保存验证码
	 *	3.发送验证码（图片验证码需要将图片显示在界面上或者其他）
	 * 
	 * (non-Javadoc)
	 * @see com.ph.security.core.validate.code.ValidateCodeProcessor#create(org.springframework.web.context.request.ServletWebRequest)
	 */
	@Override
	public void create(ServletWebRequest servletWebRequest)throws Exception {
		//生成验证码
		C validateCode = generate(servletWebRequest);
		//保存验证码
		save(servletWebRequest,validateCode,getValidateCodeType());
		//发送验证码
		send(servletWebRequest,validateCode);
	}
	
	@SuppressWarnings("unchecked")
	public C generate(ServletWebRequest servletWebRequest) {
		//应该选择我们定义的那个验证码呢，
		//1.获取到是使用哪一个验证码的key
		String type = getValidateCodeType().toString().toLowerCase();
		String generatorName = type + ValidateCodeGenerator.class.getSimpleName();
		//2.从map中通过key将验证码获取
		ValidateCodeGenerator validateCodeGenerator =  validateCodeGenerators.get(generatorName);
		if(validateCodeGenerator == null) {
			throw new ValidateCodeException("验证码生成器" + generatorName + "不存在");
		}
		//3.执行验证码生成验证码的方法获取到验证码的对象
		return (C) validateCodeGenerator.generate(servletWebRequest);
		
	}
	
	/**
	 * 将验证码放到session中
	 * @param request
	 * @param code
	 * @param validateCodeType
	 */
	public void save(ServletWebRequest request, ValidateCode code, ValidateCodeType validateCodeType) {
		sessionStrategy.setAttribute(request, getSessionKey(request, validateCodeType), code);
	}
	
	/**
	 * 发送验证码，这个由具体的子类去实现
	 * @param request
	 * @param validateCode
	 * @throws Exception
	 */
	protected abstract void send(ServletWebRequest request, C validateCode) throws Exception;

	
	
	
	/**
	 * 通过使用该方法的类名获取到枚举
	 * @return
	 */
	private ValidateCodeType getValidateCodeType() {
		//通过继承该类的类的名称截取到CodeProcessor前面的值
		String type = StringUtils.substringBefore(getClass().getSimpleName(), "ValidateCodeProcessor");
		//先将截取转换为大写,在去匹配枚举的值，有就返回该枚举
		return ValidateCodeType.valueOf(type.toUpperCase());
	}
	
	/**
	 * 构建验证码放入session时的key
	 * 
	 * @param request
	 * @return
	 */
	private String getSessionKey(ServletWebRequest request, ValidateCodeType validateCodeType) {
		return SESSION_KEY_PREFIX + validateCodeType.toString().toUpperCase();
	}

	/**
	 * 获取session里面验证码的值
	 * @param request
	 * @param validateCodeType
	 * @return
	 */
	public ValidateCode get(ServletWebRequest request, ValidateCodeType validateCodeType) {
		return (ValidateCode) sessionStrategy.getAttribute(request, getSessionKey(request, validateCodeType));
	}
	
	/**
	 * 删除session中的值
	 * @param request
	 * @param codeType
	 */
	public void remove(ServletWebRequest request, ValidateCodeType codeType) {
		sessionStrategy.removeAttribute(request, getSessionKey(request, codeType));
	}

	
	/* (non-Javadoc)
	 * @see com.ph.security.core.validate.code.ValidateCodeProcessor#validate(org.springframework.web.context.request.ServletWebRequest)
	 * 对验证码的校验
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void validate(ServletWebRequest servletWebRequest) {
		ValidateCodeType codeType = getValidateCodeType();

		C codeInSession = (C) get(servletWebRequest, codeType);

		String codeInRequest;
		try {
			codeInRequest = ServletRequestUtils.getStringParameter(servletWebRequest.getRequest(),
					codeType.getParamNameOnValidate());
		} catch (ServletRequestBindingException e) {
			throw new ValidateCodeException("获取验证码的值失败");
		}

		if (StringUtils.isBlank(codeInRequest)) {
			throw new ValidateCodeException(codeType + "验证码的值不能为空");
		}

		if (codeInSession == null) {
			throw new ValidateCodeException(codeType + "验证码不存在");
		}

		if (codeInSession.isExpried()) {
			remove(servletWebRequest, codeType);
			throw new ValidateCodeException(codeType + "验证码已过期");
		}

		if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
			throw new ValidateCodeException(codeType + "验证码不匹配");
		}
		
		remove(servletWebRequest, codeType);
		
	}

	
}