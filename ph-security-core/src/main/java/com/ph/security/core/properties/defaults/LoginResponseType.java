package com.ph.security.core.properties.defaults;

/**
 * spring Security 认证成功后的响应方式
 * @author panha
 *
 */
public enum LoginResponseType {

	/**
	 * 跳转
	 */
	REDIRECT,
	/**
	 * 返回json
	 */
	JSON
}
