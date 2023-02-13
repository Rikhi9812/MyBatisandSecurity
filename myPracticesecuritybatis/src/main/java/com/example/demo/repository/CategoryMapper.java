package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Category;

@Mapper
public interface CategoryMapper {
	
	
	public List<Category> findAllCategory();
	
	public void categoryInsert(Category category);
	
	public void deleteCategoryById(int id);
	
	public void updateCategory(Category category);
		
	public Category findOneCategory(int id);

}
