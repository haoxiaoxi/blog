package com.ph.security.core.properties.defaults;

/**
 * 配置项的默认值
 * @author panha
 *
 */
public interface SecurityConstants {

	/**
	 * 当请求需要身份认证时，默认跳转的url
	 * 
	 * @see SecurityController
	 */
	String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";
	/**
	 * 默认的用户名密码登录请求处理url
	 * 
	 * @see BrowerSecurityConfig
	 */
	String DEFAULT_SIGN_IN_PROCESSING_URL_FORM = "/authentication/form";
	/**
	 * 默认登录页面
	 * 
	 * @see SecurityController
	 */
	String DEFAULT_SIGN_IN_PAGE_URL = "/phLogin.html";
	
	
	
	
	
	//验证码信息
	/**
	 * 验证图片验证码时，http请求中默认的携带图片验证码信息的参数的名称
	 */
	String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";
	/**
	 * 验证短信验证码时，http请求中默认的携带短信验证码信息的参数的名称
	 */
	String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";
}
