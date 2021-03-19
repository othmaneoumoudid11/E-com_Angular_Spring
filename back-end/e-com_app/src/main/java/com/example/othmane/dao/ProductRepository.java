package com.example.othmane.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.othmane.entities.Product;
import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.Param;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {

	@RestResource(path = "/selectedProducts")
	public List<Product> findBySelectedIsTrue();
	@RestResource(path = "/productsByKeyword")
	public List<Product> findByNameContains(@org.springframework.data.repository.query.Param("mc") String mc);
}
