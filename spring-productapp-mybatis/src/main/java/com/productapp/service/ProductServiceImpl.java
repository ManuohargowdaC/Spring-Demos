package com.productapp.service;

import java.util.List;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.productapp.exception.IdNotFoundException;
import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;
import com.productapp.util.Queries;
@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	IProductRepository iProductRepository;
	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		iProductRepository.addProduct(product);
		
	}

	@Override
	public void updateProduct(double price, int productId) {
		// TODO Auto-generated method stub
		iProductRepository.updateProduct(price, productId);
		
		
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		iProductRepository.deleteProduct(productId);
		
	}

	@Override
	public Product getById(int productId) {
		// TODO Auto-generated method stub
		Product product = iProductRepository.findById(productId);
		if(product==null)
			throw new IdNotFoundException();
		return product;
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		
		List<Product> product = iProductRepository.findAll();
		if(product.isEmpty())
			throw new ProductNotFoundException("product not found");
		return product;
	}

	@Override
	public List<Product> getByBrand(String brand) {
		// TODO Auto-generated method stub
		List<Product> product = iProductRepository.findByBrand(brand);
		if(product.isEmpty())
			throw new ProductNotFoundException();
		return product;
	}

	@Override
	public List<Product> getByLessPrice(double price) {
		// TODO Auto-generated method stub
		List<Product> product = iProductRepository.findByLessPrice(price);
		if(product.isEmpty())
			throw new ProductNotFoundException();
		return product;
	}

	@Override
	public List<Product> getByCategoryandPrice(String category, double price) {
		// TODO Auto-generated method stub
		List<Product> product = iProductRepository.findByCategoryAndPrice(category,price);
		if(product.isEmpty())
			throw new ProductNotFoundException();
		return product;
	}

	
}
