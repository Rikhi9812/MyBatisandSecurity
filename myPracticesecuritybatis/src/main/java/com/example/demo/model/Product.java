package com.example.demo.model;

public class Product {

	private Long id;
	private String name;

	private String imgName;
	private String description;

	private double price;
	private double weight;
	private Category category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Product() {

	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product(Long id, String name, String imgName, String description, double price, double weight,
			Category category) {
		super();
		this.id = id;
		this.name = name;
		this.imgName = imgName;
		this.description = description;
		this.price = price;
		this.weight = weight;
		this.category = category;
	}
}
