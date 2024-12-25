package com.jsp.springboot.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springboot.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	//save()
	//delete()
	//findById()
	//findAll()
}
