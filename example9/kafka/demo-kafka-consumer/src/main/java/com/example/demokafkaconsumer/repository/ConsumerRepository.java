package com.example.demokafkaconsumer.repository;

import com.example.demokafkaconsumer.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumerRepository extends JpaRepository<Product, Integer> {
}
