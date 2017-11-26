package com.vanhack.rp.foodzilla.exception;


@SuppressWarnings("serial")
public class UnmetRequirementException extends RuntimeException {

	public UnmetRequirementException() {
		super();
	}

	public UnmetRequirementException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UnmetRequirementException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnmetRequirementException(String message) {
		super(message);
	}

	public UnmetRequirementException(Throwable cause) {
		super(cause);
	}

}
