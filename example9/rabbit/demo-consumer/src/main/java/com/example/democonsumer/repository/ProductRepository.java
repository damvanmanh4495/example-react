package com.example.democonsumer.repository;

import com.example.democonsumer.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
