package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Role;

@Mapper
public interface RoleRepository {
	
	public List<Role> findAllRole();
	
	public void addRole();
	
	public Role findByOneRole(int id);

}
