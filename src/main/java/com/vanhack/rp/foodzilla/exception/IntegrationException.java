package com.vanhack.rp.foodzilla.exception;

@SuppressWarnings("serial")
public class IntegrationException extends RuntimeException {

	public IntegrationException() {
		super();
	}

	public IntegrationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IntegrationException(String message, Throwable cause) {
		super(message, cause);
	}

	public IntegrationException(String message) {
		super(message);
	}

	public IntegrationException(Throwable cause) {
		super(cause);
	}

}
