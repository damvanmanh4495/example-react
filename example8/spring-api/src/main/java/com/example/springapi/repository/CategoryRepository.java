package com.example.springapi.repository;

import com.example.springapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "select count(c) from categories c")
    long count();
}
