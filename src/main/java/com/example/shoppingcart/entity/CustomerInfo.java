package com.example.shoppingcart.entity;

import com.example.shoppingcart.form.CustomerForm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInfo {
	
	private String name;
	private String address;
	private String email;
	private String phone;
	
	private boolean valid;
	
	public CustomerInfo(CustomerForm form) {
		this.name = form.getName();
		this.address = form.getAddress();
		this.email = form.getEmail();
		this.phone = form.getPhone();
		this.valid = form.isValid();
	}

}
