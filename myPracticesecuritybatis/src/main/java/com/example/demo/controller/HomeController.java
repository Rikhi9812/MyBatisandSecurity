package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.global.GlobalData;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;

@Controller
public class HomeController {
	
	
	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductService productService;
	
	@GetMapping({"/", "/home"})
	public String home() {
		return "index";
	}
	
	
	@GetMapping("/shop")
	public String shop(Model model) {
		
		
		model.addAttribute("categories", categoryService.getAllCategory());
		model.addAttribute("products", productService.findAllproduct());
		model.addAttribute("cartCount", GlobalData.cart.size());
		
		return "shop";
	}
	
	
	@GetMapping("/shop/category/{id}")
	public String showByCategory(@PathVariable("id") int id, Model model) {
		
		model.addAttribute("categories", categoryService.getAllCategory());
		model.addAttribute("products", productService.findbycategory(id));
		model.addAttribute("cartCount", GlobalData.cart.size());
		
		return "shop";
	}
	
	
	
	
	@GetMapping("/shop/viewproduct/{id}")
	public String viewProduct(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("product", productService.findOneProduct(id));
		model.addAttribute("cartCount", GlobalData.cart.size());
		
		return "viewProduct";
		
	}
	

}
