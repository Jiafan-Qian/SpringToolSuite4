package com.classboxes.productmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.classboxes.productmanagement.model.Product;
import com.classboxes.productmanagement.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController 
{
	@Autowired
	ProductService productService;
	
	@GetMapping("/getProducts")
	public List<Product> getProducts()
	{	
		return productService.getProducts();
	}

	@PostMapping("/saveProduct")
	public Product saveProduct(@RequestBody Product product)
	{
		return productService.saveProduct(product);
	}
	
	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product product)
	{
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public Product deleteProduct(@PathVariable("id") int pid)
	{
		return productService.deleteProduct(pid);
	}
}
