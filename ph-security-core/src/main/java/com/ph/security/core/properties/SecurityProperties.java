package com.ph.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置文件设置类
 * @author panha
 *
 */
@Component
@ConfigurationProperties(prefix = "ph.security")
public class SecurityProperties {

	//浏览器环境配置
	private SecurityBrowserProperties browser = new SecurityBrowserProperties();
	
	//验证码配置
	private SecurityValidateCodeProperties code = new SecurityValidateCodeProperties();

	public SecurityBrowserProperties getBrowser() {
		return browser;
	}

	public void setBrowser(SecurityBrowserProperties browser) {
		this.browser = browser;
	}

	public SecurityValidateCodeProperties getCode() {
		return code;
	}

	public void setCode(SecurityValidateCodeProperties code) {
		this.code = code;
	}
	
	
}
