package com.example.demoproducer.repository;

import com.example.demoproducer.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
