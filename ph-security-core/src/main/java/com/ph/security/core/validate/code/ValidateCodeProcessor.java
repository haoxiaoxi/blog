package com.ph.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 校验码处理器，封装不同校验码的处理逻辑
 * @author panha
 *
 */
/**
 * @author panha
 *
 */
public interface ValidateCodeProcessor {

	/**
	 * 生成验证码以及对验证码的操作
	 * @param servletWebRequest
	 */
	void create(ServletWebRequest servletWebRequest) throws Exception;
	
	
	/**
	 * 对验证码的校验
	 * @param servletWebRequest
	 */
	void validate(ServletWebRequest servletWebRequest);
}
