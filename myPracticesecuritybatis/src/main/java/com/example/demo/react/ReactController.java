package com.example.demo.react;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/product/")
public class ReactController {
	
	@Autowired
	ProductService productService;
	
	
	@CrossOrigin(origins = {"http://localhost:3000/", "http://localhost:5173/"})
	@GetMapping("/product")
	public List<Product> product(){
		return productService.findAllproduct();
	}
	
	@CrossOrigin(origins = "http://localhost:3000/**")
	@PostMapping("/addProduct")
	public String AddProduct(@RequestBody() ProductDTO productDTO) {
		
		try {
			productService.addProduct(productDTO);
		
		} catch(Exception e) {
			e.printStackTrace();
			return "400";
		}
		
		
		return "added";

	}

}
