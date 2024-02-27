package com.jyo.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jyo.sample.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
