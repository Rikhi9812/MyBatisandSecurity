package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserRoleDTO;
import com.example.demo.model.User;

@Mapper
public interface UserRepository {
	
	public List<UserDTO> findAllUserDTO();
	
	public List<User> findAllUser();
	
	public User findOnePDetails(String username);
	
	public void insertUser(UserDTO userDTO);
	
	public void insertUserRoles(UserRoleDTO userRoleDto);
	
	public void deleteRole(UserRoleDTO userRoleDto);

}
