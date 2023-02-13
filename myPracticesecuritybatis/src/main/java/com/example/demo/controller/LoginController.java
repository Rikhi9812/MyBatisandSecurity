package com.example.demo.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.UserDTO;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class LoginController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@PostMapping("/login")
	public String login() {
		return "redirect:/";
	}

	@GetMapping("/register")
	public String register(Model model) {

		model.addAttribute("user", new UserDTO());

		return "register";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute("user") UserDTO user, HttpServletRequest request) throws ServletException {

		String password = user.getPassword();

		String pass = bCryptPasswordEncoder.encode(password);

		user.setPassword(pass);

		//Set<Role> role = new HashSet<>();

		//role.add(roleRepository.findByOneRole(1));

		//userRepository.insertUser(user.getId(), user.getUsername(), user.getPassword(), user.isEnabled());
		
		
		
		
		userRepository.insertUser(user);
		
//		  userRepository.insertUserRoles(user.getId(), 1);
		 
		request.login(user.getUsername(), password);

		return "register";
	}

}
