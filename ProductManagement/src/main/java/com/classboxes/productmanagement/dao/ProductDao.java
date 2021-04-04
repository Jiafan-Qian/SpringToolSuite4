package com.classboxes.productmanagement.dao;

import java.util.List;

import com.classboxes.productmanagement.model.Product;

public interface ProductDao {
	
	public List<Product> getProducts();
	public Product saveProduct(Product product);
	public Product updateProduct(Product product);
	public Product deleteProduct(int pid);

}
