package com.niit.RovingFits.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int product_Id;
	@Column(nullable = false, unique = true)
	String product_Name;
	@Column(nullable = false, columnDefinition = "text")
	String product_description;
	@Column(nullable = false)
	int product_stock;
	@Column(nullable = false)
	float product_price;
	@ManyToOne
	Category product_Category;

	public int getPro_Id() {
		return product_Id;
	}

	public void setPro_Id(int pro_Id) {
		this.product_Id = pro_Id;
	}

	public String getPro_Name() {
		return product_Name;
	}

	public void setPro_Name(String pro_Name) {
		this.product_Name = pro_Name;
	}

	public String getPro_description() {
		return product_description;
	}

	public void setPro_description(String pro_description) {
		this.product_description = pro_description;
	}

	public int getPro_stock() {
		return product_stock;
	}

	public void setPro_stock(int pro_stock) {
		this.product_stock = pro_stock;
	}

	public float getPro_price() {
		return product_price;
	}

	public void setPro_price(float pro_price) {
		this.product_price = pro_price;
	}

	public Category getPro_Category() {
		return product_Category;
	}

	public void setPro_Category(Category pro_Category) {
		this.product_Category = pro_Category;
	}

}
