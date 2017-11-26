package com.vanhack.rp.foodzilla.security;


public class AuthenticationResponse {

	public static enum Status {
		SUCCESS, FAILURE
	}

	private Status status;
	private String message;
	private String authenticationToken;

	public AuthenticationResponse() {
	}
	
	public AuthenticationResponse(Status status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public AuthenticationResponse(Status status, String message, String authenticationToken) {
		super();
		this.status = status;
		this.message = message;
		this.authenticationToken = authenticationToken;
	}

	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getAuthenticationToken() {
		return authenticationToken;
	}

	public void setAuthenticationToken(String authenticationToken) {
		this.authenticationToken = authenticationToken;
	}

}
