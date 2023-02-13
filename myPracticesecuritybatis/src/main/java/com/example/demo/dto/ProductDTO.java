package com.example.demo.dto;

public class ProductDTO {

	private Long id;
	private String name;

	private String imgName;
	private String description;

	private double price;
	private double weight;
	private int categoryId;

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

	public ProductDTO() {

	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public ProductDTO(Long id, String name, String imgName, String description, double price, double weight,
			int categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.imgName = imgName;
		this.description = description;
		this.price = price;
		this.weight = weight;
		this.categoryId = categoryId;
	}
}
