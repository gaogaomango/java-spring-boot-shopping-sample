package com.example.shoppingcart.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.shoppingcart.dao.ProductDAO;
import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.entity.ProductInfo;
import com.example.shoppingcart.pagination.PaginationResult;

@Controller
@Transactional
public class MainController {

	@Autowired
	private ProductDAO productDAO;
	
	@InitBinder
	public void myInitBinder(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if(target == null) {
			return;
		}
		System.out.println("Target = " + target);
		
		// Case update quantity in cart
		// (@ModelAttribute("cartForm") @Validated CartInfo cartForm)
		if(target.getClass() == CartInfo.class) {
			
		} else if (target.getClass() == CustomerForm.class) {
			dataBinder.setValidator();
		}
	}
	
	@RequestMapping("/403")
	public String accessDenied() {
		return "/403";
	}

	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	// Product List
	@RequestMapping({"/productList"})
	public String listProductHandler(Model model,
			@RequestParam(value ="name", defaultValue = "") String likeName,
			@RequestParam(value = "page", defaultValue = "1") int page) {
		
		final int maxResult = 5;
		final int maxNavigationPage = 10;
		
		PaginationResult<ProductInfo> result = productDAO.queryProducts(page,
				maxResult,
				maxNavigationPage,
				likeName);
		
		model.addAttribute("paginationProducts", result);

		return "productList";
	}
	
	@RequestMapping({"/buyProduct"})
	public String listProductHandler(HttpServletRequest request, 
			Model model, 
			@RequestParam(value = "code", defaultValue = "") String code) {
		
		Product product = null;
		if(code != null && code.length() > 0) {
			product = productDAO.findProduct(code);
		}
		if(product != null) {
			// TODO cart info
		}

		return "redirect:/shoppingCart";
	}
	

   
}
