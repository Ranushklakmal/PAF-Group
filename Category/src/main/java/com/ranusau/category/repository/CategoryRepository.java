package com.ranusau.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ranusau.category.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
