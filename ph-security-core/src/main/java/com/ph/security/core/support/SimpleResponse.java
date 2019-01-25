package com.ph.security.core.support;

/**
 * 返回类型的简单封装
 * @author panha
 *
 */
public class SimpleResponse {

	public SimpleResponse(Object content){
		this.content = content;
	}
	
	private Object content;

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
}
