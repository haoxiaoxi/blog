package com.ph.security.core.properties;

public class SecurityImageValidateCodeProperties extends SecurityBaseValidateCodeProperties {

	public SecurityImageValidateCodeProperties() {
		//设置图片的验证码长度为4,过期时间为60s
		this.setLength(4);
		this.setExpireIn(60);
	}
	/**
	 * 图片宽
	 */
	private int width = 67;
	/**
	 * 图片高
	 */
	private int height = 23;
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
