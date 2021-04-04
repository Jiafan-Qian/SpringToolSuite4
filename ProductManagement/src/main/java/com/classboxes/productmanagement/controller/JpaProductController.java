package com.classboxes.productmanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.classboxes.productmanagement.dao.ProductRepository;
import com.classboxes.productmanagement.model.Product;

@RestController
@RequestMapping("/jpaproduct")
public class JpaProductController {
	@Autowired
	ProductRepository prodRepo;
	
	@GetMapping("/getProducts")
	public List<Product> getProducts()
	{
		return prodRepo.findAll();
		
	}

	@PostMapping("/saveProduct")
	public Product saveProduct(@RequestBody Product product)
	{
		return prodRepo.save(product);
	}
	
	@PutMapping("/updateProduct/{id}")
	public Product updateProduct(@PathVariable(value="id") Long productId, @RequestBody Product product) throws Exception
	{
		Product existingproduct = prodRepo.findById(productId)
				.orElseThrow(() -> new Exception("no product found"));
		existingproduct.setProductName(product.getProductName());
		existingproduct.setProductPrice(product.getProductPrice());
		final Product updatedProduct = prodRepo.save(existingproduct);
		return updatedProduct;
	}
	
	
	@DeleteMapping("/deleteProduct/{id}")
	public Map<String, Boolean> deleteProduct(@PathVariable(value="id") Long productId) throws Exception
	{
		Product existingproduct = prodRepo.findById(productId)
				.orElseThrow(() -> new Exception("no product found"));
		prodRepo.delete(existingproduct);
		Map<String, Boolean> response= new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
		
	}
	
}
