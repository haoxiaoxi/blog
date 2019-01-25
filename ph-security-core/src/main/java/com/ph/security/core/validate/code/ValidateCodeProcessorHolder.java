package com.ph.security.core.validate.code;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 校验码处理器管理器
 * @author panha
 *
 */
@Component
public class ValidateCodeProcessorHolder {

	//将所有实现ValidateCodeProcessor该接口的类放在map中key的类名头小写的值
	@Autowired
	private Map<String, ValidateCodeProcessor> validateCodeProcessors;
	
	/**
	 * 参数类型为ValidateCodeType枚举
	 * @param type
	 * @return
	 */
	public ValidateCodeProcessor findValidateCodeProcessor(ValidateCodeType type) {
		return findValidateCodeProcessor(type.toString().toLowerCase());
	}
	
	/**
	 * 参数为字符串
	 * @param type
	 * @return
	 */
	public ValidateCodeProcessor findValidateCodeProcessor(String type) {
		//拼接出map中key的值，通过将传递的值转换为小写，在加上ValidateCodeProcessor的类名
		String name = type.toLowerCase() + ValidateCodeProcessor.class.getSimpleName();
		ValidateCodeProcessor validateCodeProcessor = validateCodeProcessors.get(name);
		if(validateCodeProcessor == null) {
			throw new ValidateCodeException("验证码处理器" + name + "不存在");
		}
		return validateCodeProcessor;
	}
}