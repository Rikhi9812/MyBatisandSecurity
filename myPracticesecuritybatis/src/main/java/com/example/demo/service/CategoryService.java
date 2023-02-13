package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryMapper;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	public List<Category> getAllCategory(){
		return categoryMapper.findAllCategory();
	}
	
	public void save(Category category) {
	categoryMapper.categoryInsert(category);
	}
	
	public void deleteCategoryById(int id) {
		categoryMapper.deleteCategoryById(id);
	}
	
	public Category findOneCategory(int id) {
		return categoryMapper.findOneCategory(id);
	}
	
	public void updateCategory(Category category) {
		categoryMapper.updateCategory(category);
	}

}
