package com.jsp.springboot.product.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsp.springboot.product.entity.Product;
import com.jsp.springboot.product.service.ProductService;
import com.jsp.springboot.product.utility.ResponseStructure;

@Controller
@ResponseBody
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/add-product")
	public ResponseEntity<ResponseStructure<Product>> addProduct(@RequestBody Product product) {
		product = productService.addProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.create(HttpStatus.CREATED.value(), "Product created!", product));
	}

	@GetMapping("/find-all-products")
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProducts() {
		List<Product> products = productService.findAllProducts();
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.create(HttpStatus.FOUND.value(), "Products found !", products));
	}

	@GetMapping("/find-product")
	public ResponseEntity<ResponseStructure<Product>>  findProductById(@RequestParam int  productId) {
		Product product = productService.findProductById(productId);
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.create(HttpStatus.FOUND.value(), "Product found!", product));
	}

	@PutMapping("/update-product")
	public ResponseEntity<ResponseStructure<Product>> updateProductById(@RequestBody Product product) {
		Product product1 = productService.updateProductById(product);
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.create(HttpStatus.OK.value(), "Product updated!", product1));
	}

	@DeleteMapping("/delete-product")
	public ResponseEntity<ResponseStructure<Product>> deleteProductById(@RequestParam int  productId) {
		Product product2 = productService.deleteProductById(productId);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.create(HttpStatus.OK.value(), "Product deleted!", product2));
	}
}
