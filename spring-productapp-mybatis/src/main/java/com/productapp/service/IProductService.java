package com.productapp.service;

import java.util.List;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;

public interface IProductService {
	void addProduct(Product product);
	void updateProduct(double price, int productId);
	void deleteProduct(int productId);
	
	
	Product getById(int productId);
	List<Product> getAll();
	List<Product>getByBrand(String brand);
	List<Product>getByLessPrice(double price);
	List<Product>getByCategoryandPrice(String category, double price);
	
	
		
	
	

}
