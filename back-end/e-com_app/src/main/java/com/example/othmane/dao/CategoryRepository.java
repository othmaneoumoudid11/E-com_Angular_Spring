package com.example.othmane.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.othmane.entities.Category;
import com.example.othmane.entities.Product;

@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
