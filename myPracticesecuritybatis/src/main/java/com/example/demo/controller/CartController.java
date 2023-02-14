package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.global.GlobalData;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@Controller
public class CartController {

	@Autowired
	ProductService productService;

	@GetMapping("/addToCart/{id}")
	public String addCart(@PathVariable("id") Long id) {

		GlobalData.cart.add(productService.findOneProduct(id));

		return "redirect:/shop";
	}

	@GetMapping("/cart")
	public String CartPage(Model model) {

		model.addAttribute("cartCount", GlobalData.cart.size());

		model.addAttribute("carts", GlobalData.cart);

		model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());

		return "addCart";

	}
	

	@GetMapping("/cart/removeItem/{index}")
	public String deleteCart(@PathVariable("index") int index) {

		System.out.println(GlobalData.cart.get(index).getId());
		GlobalData.cart.remove(index);

		return "redirect:/cart";
	}

	@GetMapping("/checkout")
	public String checkout(Model model) {

		double total = 0;

		for (Product product : GlobalData.cart) {

			total += product.getPrice();
		}
		
		model.addAttribute("cartCount", GlobalData.cart.size());

		model.addAttribute("total", total);

		return "checkout";
	}

}
