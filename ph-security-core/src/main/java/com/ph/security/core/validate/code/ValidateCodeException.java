package com.ph.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

public class ValidateCodeException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9000229824711211717L;

	public ValidateCodeException(String msg) {
		super(msg);
	}
}
