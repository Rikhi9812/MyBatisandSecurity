package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductMapper;

@Service
public class ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	
	
	public List<Product> findAllproduct(){
		System.out.println(productMapper.findAllproduct());
		return productMapper.findAllproduct();
	}
	
	public void addProduct(ProductDTO productDTO) {
		productMapper.addProduct(productDTO);
	}
	
	public void deleteProductById(Long id) {
		productMapper.deleteProductById(id);
	}
	
	public Product findOneProduct(Long id) {
		return productMapper.findOneProduct(id);
	}
	
	public void updateProduct(ProductDTO productDTO) {
		productMapper.updateProduct(productDTO);
	}
	
	public List<Product> findbycategory(int id) {
		return productMapper.findbycategory(id);
	}

}
