package com.classboxes.productmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classboxes.productmanagement.dao.ProductDao;
import com.classboxes.productmanagement.model.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao pdao;
	
	
	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return pdao.getProducts();
	}


	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return pdao.saveProduct(product);
	}


	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return pdao.updateProduct(product);
	}


	@Override
	public Product deleteProduct(int pid) {
		// TODO Auto-generated method stub
		return pdao.deleteProduct(pid);
	}

}
