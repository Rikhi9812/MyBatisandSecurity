package com.example.demo.controller;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;

@Controller
public class AdminController {

	public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductService productService;

	@GetMapping("/admin")
	public String admin() {
		return "adminhome";
	}	
	
	
	
	// category
	@GetMapping("/admin/categories")
	public String getAllCategories(Model model) {

		model.addAttribute("categories", categoryService.getAllCategory());

		return "categories";
	}

	@GetMapping("/admin/categories/add")
	public String addCategoriesPage(Model model) {

		model.addAttribute("category", new Category());

		return "addCategory";
	}

	@PostMapping("/admin/categories/add")
	public String addCategory(@ModelAttribute("category") Category category) {

		categoryService.save(category);

		return "redirect:/admin/categories/";
	}
	

	@GetMapping("/admin/catefories/delete/{id1}")
	public String deleteCategory(@PathVariable("id1") int id) {

		categoryService.deleteCategoryById(id);

		return "redirect:/admin/categories/";
	}

	@GetMapping("/admin/catefories/update/{id}")
	public String findOneCategory(@PathVariable("id") int id, Model model) {

		model.addAttribute("category", categoryService.findOneCategory(id));

		return "updateCategory";
	}
	

	@PostMapping("/admin/categories/update")
	public String updateCategory(@ModelAttribute("category") Category category, Model model) {

		categoryService.updateCategory(category);

		return "redirect:/admin/categories/";
	}

	// products
	@GetMapping("/admin/products")
	public String products(Model model) {

		model.addAttribute("products", productService.findAllproduct());

		return "products";
	}

	@GetMapping("admin/products/add")
	public String addProductPage(Model model) {

		model.addAttribute("productDTO", new ProductDTO());
		model.addAttribute("categories", categoryService.getAllCategory());

		return "addProduct";
	}

	@PostMapping("admin/products/add")
	public String addProduct(@ModelAttribute("productDTO") ProductDTO productDTO,
			@RequestParam("productImage") MultipartFile file, @RequestParam("imgName") String imgName)
			throws IOException {

		//String imgUUID = null;
		String imgData = null;

		if (!file.isEmpty()) {
//			imgUUID = file.getOriginalFilename();
			imgData = Base64.getEncoder().encodeToString(file.getBytes());
		} 
		
		productDTO.setImgName(imgData);

		productService.addProduct(productDTO);

		return "redirect:/admin/products";
	}

	@GetMapping("/admin/product/delete/{id}")
	public String deleteProduct(@PathVariable("id") Long id) {

		productService.deleteProductById(id);

		return "redirect:/admin/products";
	}

	@GetMapping("/admin/product/update/{id}")
	public String updateProductPage(@PathVariable("id") Long id, Model model) {

		ProductDTO productDTO = new ProductDTO();
		Product product = productService.findOneProduct(id);

		productDTO.setId(product.getId());
		productDTO.setDescription(product.getDescription());
		productDTO.setCategoryId(product.getCategory().getId());
		productDTO.setName(product.getName());
		productDTO.setPrice(product.getPrice());
		productDTO.setWeight(product.getWeight());

		productDTO.setImgName(product.getImgName());
		model.addAttribute("productDTO", productDTO);
		model.addAttribute("categories", categoryService.getAllCategory());

		return "updateProduct";
	}

	@PostMapping("/admin/products/update")
	public String updateProduct(@ModelAttribute("productDTO") ProductDTO productDTO,
			@RequestParam("productImage") MultipartFile file) throws IOException {
		
		Product product = productService.findOneProduct(productDTO.getId());

		//String imgUUID;
		String imgData = null;

		if (!file.isEmpty()) {
			//imgUUID = file.getOriginalFilename();
			//Path filePathName = Paths.get(uploadDir, imgUUID);
			//Files.write(filePathName, file.getBytes());
			imgData = Base64.getEncoder().encodeToString(file.getBytes());
		} else {
			imgData = product.getImgName();
		}
				
		
		productDTO.setImgName(imgData);

		productService.updateProduct(productDTO);

		return "redirect:/admin/products";
	}

}
