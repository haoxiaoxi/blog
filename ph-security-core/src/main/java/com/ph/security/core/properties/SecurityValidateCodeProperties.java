package com.ph.security.core.properties;

/**
 * 验证码的配置文件
 * @author panha
 *
 */
public class SecurityValidateCodeProperties {

	//图片验证码的配置文件
	private SecurityImageValidateCodeProperties image = new SecurityImageValidateCodeProperties();

	public SecurityImageValidateCodeProperties getImage() {
		return image;
	}

	public void setImage(SecurityImageValidateCodeProperties image) {
		this.image = image;
	}
	
}
