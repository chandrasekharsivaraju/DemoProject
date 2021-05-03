package com.scs.ecommerce.exception;

public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 13467893L;

	public DataNotFoundException() {
		super();
	}

	public DataNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataNotFoundException(String message) {
		super(message);
	}

}
