package com.example.shoppingcart.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartLineInfo {
	
	private ProductInfo productInfo;
	private int quantity;
	
	public CartLineInfo() {
		this.quantity = 0;
	}
	
	public double getAmount() {
		return this.productInfo.getPrice() * this.quantity;
	}

}
