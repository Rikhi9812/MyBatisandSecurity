package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Product;

@Mapper
public interface ProductMapper {
	
	public List<Product> findAllproduct();
	
	public void addProduct(ProductDTO productDTO);
	
	public void deleteProductById(Long id);
	
	public Product findOneProduct(Long id);
	
	public void updateProduct(ProductDTO productDTO);
	
	public List<Product> findbycategory(int id);

}
