package com.tgdd.controller;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tgdd.dto.ProductDto;
import com.tgdd.exceptions.handlers.ResourceNotFoundException;
import com.tgdd.service.ProductService;
@RestController
@RequestMapping("products")
public class ProductController {
	@Autowired
	private ProductService productServices;

	@PostMapping

	public ResponseEntity<?> addProduct(@Valid @RequestBody ProductDto productDTO) {
		return productServices.addProduct(productDTO);
	}

	@PutMapping("/{id}")

	public ResponseEntity<?> updateProduct(@PathVariable("id") long id, @Valid @RequestBody ProductDto productDTO) throws ResourceNotFoundException {

		return productServices.updateProduct(id, productDTO);

	}

	@DeleteMapping("/{id}")

	public ResponseEntity<?> deleteProduct(@PathVariable("id") long id) throws ResourceNotFoundException {
		return productServices.deleteProduct(id);
	}

	@GetMapping

	public ResponseEntity<?> getAllProducts() {
		return productServices.getAllProduct();
	}
	
	@GetMapping("/{id}")

	public ProductDto getProductbyID(@PathVariable("id") long id) {
		return productServices.findByIdProduct(id);
	}


	@GetMapping("/product_search/{name}")

	public ResponseEntity<?> getProductbyName(@PathVariable("name") String name) {

		return productServices.getProductbyProductName(name);
	}
	
	@GetMapping("/product_category/{id}")

	public ResponseEntity<?> getAllProductsByCategory(@PathVariable("id") long id) {

		return productServices.getAllProductbyCategory(id);
	}
}
