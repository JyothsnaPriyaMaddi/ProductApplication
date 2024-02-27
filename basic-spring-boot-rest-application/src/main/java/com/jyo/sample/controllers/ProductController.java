package com.jyo.sample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jyo.sample.entities.Product;
import com.jyo.sample.repository.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	ProductRepository productRepo;
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		return productRepo.findById(id).get();
	}
	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product) {
		return productRepo.save(product);
	}
	@PutMapping("/products/{id}")
	public Product updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
		product.setId(id);
		return productRepo.save(product);
	}
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable("id") int id) {
		productRepo.deleteById(id);
	}

}
