package com.vanhack.rp.foodzilla.exception;

@SuppressWarnings("serial")
public class AuthenticationException extends RuntimeException {

	public AuthenticationException() {
	}
	public AuthenticationException(String msg) {
		super(msg);
	}
	public AuthenticationException(Throwable t) {
		super(t);
	}
	public AuthenticationException(String msg, Throwable t) {
		super(msg, t);
	}

}
