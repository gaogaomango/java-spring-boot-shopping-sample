package com.example.shoppingcart.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailInfo {

    private String id;
    
    private String productCode;
    private String productName;
 
    private int quanity;
    private double price;
    private double amount;
 
	
}
