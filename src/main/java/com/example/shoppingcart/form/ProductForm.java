package com.example.shoppingcart.form;

import org.springframework.web.multipart.MultipartFile;

import com.example.shoppingcart.entity.Product;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductForm {

	private String code;
	private String name;
	private double price;
	
	private boolean newProduct = false;
	
	private MultipartFile fileData;
	
	public ProductForm() {
		this.newProduct = true;
	}
	
	public ProductForm(Product product) {
		this.code = product.getCode();
		this.name = product.getName();
		this.price = product.getPrice();
		
	}
	
}
