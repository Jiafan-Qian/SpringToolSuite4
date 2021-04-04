package com.classboxes.productmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.classboxes.productmanagement.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao{

	List<Product> listofProducts = new ArrayList<Product>();
	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		listofProducts.add(new Product(1,"pen",1.2f));
		listofProducts.add(new Product(2,"pencil",1.0f));
		listofProducts.add(new Product(3,"eraser",0.5f));
		return listofProducts;
	}

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		//Product newProduct = new Product(4,"Sharpner",5f);
		listofProducts.add(product);
		return product;
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		listofProducts.add(product);
		return product;
	}

	@Override
	public Product deleteProduct(int pid) {
		// TODO Auto-generated method stub
		Product dProduct = listofProducts.get(pid);
		listofProducts.remove(dProduct.getProductId());
		return dProduct;
	}

}
