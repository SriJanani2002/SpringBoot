package com.jsp.springboot.product.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.springboot.product.entity.Product;
import com.jsp.springboot.product.exception.ProductNotFoundByIdException;
import com.jsp.springboot.product.exception.ProductNotFoundException;
import com.jsp.springboot.product.repository.ProductRepository;
import com.jsp.springboot.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> findAllProducts() {

		List<Product> products = productRepository.findAll();
		if(products.isEmpty()) {
			throw new ProductNotFoundException("Product not found!");
		}
		else {
			return products;
		}
	}



	@Override
	public Product findProductById(int productId) {
		Optional<Product> optional = productRepository.findById(productId);
		if(optional.isPresent()) {
			Product product = optional.get();
			return product;
		}
		else {
			throw new ProductNotFoundByIdException("Failed to find the product");
		}

	}	

	@Override
	public Product updateProductById(Product product) {
		Optional<Product> optional = productRepository.findById(product.getProductId());
		if(optional.isPresent()) {
			Product existingProduct = optional.get();
			existingProduct.setProductBrand(product.getProductBrand());
			existingProduct.setProductName(product.getProductName());
			existingProduct.setProductPrice(product.getProductPrice());

			return productRepository.save(product);
		}
		else {
			throw new RuntimeException("Failed to update product details");
		}
	}

	@Override
	public Product deleteProductById(int productId) {
		Optional<Product> optional = productRepository.findById(productId);
		if(optional.isPresent()) {
			Product product = optional.get();
			productRepository.delete(product);
			return product;	
		}
		else {
			throw new RuntimeException("Failed to delete the product");
		}
	}
}







