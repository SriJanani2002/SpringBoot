package com.jsp.springboot.product.exception;

public class ProductNotFoundByIdException extends RuntimeException{
	private final String message;

	public String getMessage() {
		return message;
	}

	public ProductNotFoundByIdException(String message) {
		this.message = message;
	}
}
