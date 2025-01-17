package com.productapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.Product;
import com.productapp.service.IProductService;

@RestController
@RequestMapping("/product-api/v1")
public class ProductController {
	
	@Autowired
	IProductService iProductService;
	
	@PostMapping("/products")
	void addProduct(Product product) {
		iProductService.addProduct(product);
	}
	
	@PutMapping("/products/price/{price}/productId/{productId}")
	void updateProduct(double price, int productId) {
		iProductService.updateProduct(price, productId);
	}
	@DeleteMapping("/products/productId")
	void deleteProduct(int productId) {
		iProductService.deleteProduct(productId);
	}
	
	@GetMapping("/products/productId")
	Product getById(int productId) {
		return iProductService.getById(productId);
	}
	@GetMapping("/products")
	List<Product> getAll(){
		return iProductService.getAll();
	}
//	List<Product>getByBrand(String brand){
//		return iProductService.getByBrand(brand);
//		
//	}
//	List<Product>getByLessPrice(double price){
//		return iProductService.getByLessPrice(price);
//	}
//	List<Product>getByCategoryandPrice(String category, double price){
//		return iProductService.getByCategoryandPrice(category, price);
//	}
//	
	
	
}
