package com.nationalsupermarket.exception;

public class ItemDoesNotExistException extends Exception {


	private static final long serialVersionUID = 708676496243855457L;

	public ItemDoesNotExistException() {
		super();
	}

	public ItemDoesNotExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public ItemDoesNotExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public ItemDoesNotExistException(String message) {
		super(message);
	}

	public ItemDoesNotExistException(Throwable cause) {
		super(cause);
	}

}
