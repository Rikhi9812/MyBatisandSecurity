package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.UserRoleDTO;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class AdminRoleController {
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	
	@GetMapping("/admin/role")
	public String role(Model model) {
		
		List<User> users = userRepository.findAllUser();
		List<Role> roles = roleRepository.findAllRole();
		
		
		model.addAttribute("users",users);
		model.addAttribute("roles", roles);
		model.addAttribute("userRole", new UserRoleDTO());
		
		return "role";
		
		
	}
	
	
	@PostMapping("/addrole")
	public String addRole(@ModelAttribute("userRole") UserRoleDTO userRole) {
		
		userRepository.insertUserRoles(userRole);
		
		return "redirect:/admin/role";
	}
	
	
	@GetMapping("/deleterole")
	public String deleteRole(@ModelAttribute("userRole") UserRoleDTO userRole) {
		
		userRepository.deleteRole(userRole);
		
		return "redirect:/admin/role";
	}
	
	

}
