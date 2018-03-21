package com.ships.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;

@Controller
public class MainController {
	
	@RequestMapping(value = "/showShips")
	public String showShips() {
		
		return "showShips";
		
	}
	
	@RequestMapping(value = "/showShippingCompanies")
	public String showShippingCompanies() {
		
		return "showShippingCompanies";
	}
	
	@RequestMapping(value = "/showOrders")
	public String showOrders() {
		
		return "showOrders";
	}
	
	@RequestMapping(value = "/addShip")
	public String addNewShip( 
		@ModelAttribute("ship") Ship s) {
		
		return "addShip";
	}
	
	@RequestMapping(value = "/addShippingCompany")
	public String addNewShippingCompany( 
		@ModelAttribute("company") ShippingCompany c) {
		
		return "addShippingCompany";
	}
	
	@RequestMapping(value = "/createOrder")
	public String createNewOrder( 
		@ModelAttribute("order") OrderInfo o) {
		
		return "createOrder";
	}

}

