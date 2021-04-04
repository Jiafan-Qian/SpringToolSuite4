package com.classboxes.productmanagement.service;

import java.util.List;

import com.classboxes.productmanagement.model.Product;

public interface ProductService {
	
	public List<Product> getProducts();
	public Product saveProduct(Product product);
	public Product updateProduct(Product product);
	public Product deleteProduct(int pid);

}
