package com.ph.security.core.validate.code;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ValidateCode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8508346884251179757L;
	//验证码的值
	private String code;
	//超时时间
	private LocalDateTime expireTime;
	
	public ValidateCode(String code,int expireIn) {
		this.code = code;
		//将超时时间（eg:60s）转换为到期的时间
		this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
	}
	public ValidateCode(String code,LocalDateTime expireTime) {
		this.code = code;
		this.expireTime = expireTime;
	}
	
	//判断是否超时
	public boolean isExpried() {
		return LocalDateTime.now().isAfter(expireTime);
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public LocalDateTime getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(LocalDateTime expireTime) {
		this.expireTime = expireTime;
	}
	
	

}
