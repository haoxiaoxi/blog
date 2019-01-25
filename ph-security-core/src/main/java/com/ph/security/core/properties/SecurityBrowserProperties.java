package com.ph.security.core.properties;

import com.ph.security.core.properties.defaults.LoginResponseType;
import com.ph.security.core.properties.defaults.SecurityConstants;

/**
 * 浏览器环境配置项,可以在application.properties中进行配置
 * @author panha
 *
 */
public class SecurityBrowserProperties {

	//登录页面，当引发登录行为的url以html结尾时，会跳到这里配置的url上,默认是phLogin.html界面
	private String loginPage = SecurityConstants.DEFAULT_SIGN_IN_PAGE_URL;
	//认证成功后的响应方式,默认是json格式
	private LoginResponseType loginResponseType   = LoginResponseType.JSON;
	//登录成功后跳转到该地址，如果设置了该项，那么在登录成功后，不管之前请求的路径是什么，总是跳转到该路径
	private String loginSuccessUrl;
	
	public String getLoginPage() {
		return loginPage;
	}
	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}
	public LoginResponseType getLoginResponseType() {
		return loginResponseType;
	}
	public void setLoginResponseType(LoginResponseType loginResponseType) {
		this.loginResponseType = loginResponseType;
	}
	public String getLoginSuccessUrl() {
		return loginSuccessUrl;
	}
	public void setLoginSuccessUrl(String loginSuccessUrl) {
		this.loginSuccessUrl = loginSuccessUrl;
	}
}
