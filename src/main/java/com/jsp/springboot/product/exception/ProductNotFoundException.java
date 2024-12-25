package com.jsp.springboot.product.exception;

public class ProductNotFoundException extends RuntimeException{
	private final String message;

	public String getMessage() {
		return message;
	}

	public ProductNotFoundException(String message) {
		this.message = message;
	}
}
