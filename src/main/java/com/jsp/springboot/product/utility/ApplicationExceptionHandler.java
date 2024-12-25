package com.jsp.springboot.product.utility;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.springboot.product.exception.ProductNotFoundByIdException;
import com.jsp.springboot.product.exception.ProductNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler
	public ErrorStructure handleProductNotFoundById(ProductNotFoundByIdException ex){
		return ErrorStructure.create(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "Product not found with the given id");
	}

	@ExceptionHandler
	public ErrorStructure handleProductNotFound(ProductNotFoundException ex){
		return ErrorStructure.create(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "Product not found");
	}

}
