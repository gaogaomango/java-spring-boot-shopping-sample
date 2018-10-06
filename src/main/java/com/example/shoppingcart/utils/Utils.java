package com.example.shoppingcart.utils;

import javax.servlet.http.HttpServletRequest;

import com.example.shoppingcart.entity.CartInfo;

public class Utils {
	
	private static final String MY_CAAART = "myCart";
	private static final String LAST_ORDERED_CART = "lastOrderedCart";
	
	private Utils() {}
	
	
	public static CartInfo getCartInSession(HttpServletRequest request ) {
		
		CartInfo cartInfo = (CartInfo) request.getSession().getAttribute(MY_CAAART);
		
		if(cartInfo == null) {
			cartInfo = new CartInfo();
			
			request.getSession().setAttribute(MY_CAAART, cartInfo);
		}
		
		return cartInfo;
	}
	
	public static void removeCartinSession(HttpServletRequest request) {
		request.getSession().removeAttribute(MY_CAAART);
	}
	
	public static void storeLastOrderedCartInSession(HttpServletRequest request, CartInfo cartInfo) {
		request.getSession().setAttribute(LAST_ORDERED_CART,  cartInfo);
	}
	
	public static CartInfo getLastOrderedCartInSession(HttpServletRequest request) {
		return (CartInfo) request.getSession().getAttribute(LAST_ORDERED_CART);
	}

}
