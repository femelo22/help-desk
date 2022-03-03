package com.lfmelo.exceptions;

public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NotFoundException(String msg) {
		super(msg);
	}

	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
