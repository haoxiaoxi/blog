package com.ph.security.core.properties;

public class SecurityBaseValidateCodeProperties {

	/**
	 * 验证码长度
	 */
	private int length;
	/**
	 * 过期时间
	 */
	private int expireIn;
	
	/**
	 * 配置验证码检验拦截器，需要拦截的url
	 */
	private String url;
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getExpireIn() {
		return expireIn;
	}
	public void setExpireIn(int expireIn) {
		this.expireIn = expireIn;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
