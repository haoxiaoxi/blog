package com.ph.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 生成验证码接口
 * @author panha
 *
 */
public interface ValidateCodeGenerator {

	/**
	 * 生成验证码的方法
	 * @param request
	 * @return
	 */
	public ValidateCode generate(ServletWebRequest request);
}
