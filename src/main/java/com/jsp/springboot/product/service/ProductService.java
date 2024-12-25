package com.jsp.springboot.product.service;

import java.util.List;
import java.util.Optional;

import com.jsp.springboot.product.entity.Product;

public interface ProductService {

	public Product addProduct(Product product);

	public List<Product> findAllProducts();

	public Product findProductById(int productId);

	public Product updateProductById(Product product);

	public Product deleteProductById(int productId);


}
