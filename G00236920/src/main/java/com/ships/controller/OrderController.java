package com.ships.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.services.OrderService;
import com.ships.services.ShipService;
import com.ships.services.ShippingService;


@Controller
public class OrderController {
	
//SHIPS	
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private ShipService shipService;
	@Autowired 
	private ShippingService shippingService;
	
	//Get Method for Showing Orders
	//If user clicks a link to enter the ShowOrder JSP
	@RequestMapping(value = "/showOrders", method = RequestMethod.GET)
	public String listOrders(Model model, HttpServletRequest h) {
		
		//Create a list of ships from the Sql data
		ArrayList<OrderInfo> s = (ArrayList<OrderInfo>) orderService.FindAll();

		//Add ships so it can be viewed
		model.addAttribute("orders", s);

		//Show the ships page
		return "showOrders";
	}
	
	//Get Method for Adding ship
	//If user clicks a link to enter the AddShip JSP
	@RequestMapping(value = "/createOrder", method = RequestMethod.GET)
	public String addOrder(@ModelAttribute("order") OrderInfo order, HttpServletRequest h, Model model) {
		
	
		List<Ship> s =  (List<Ship>) shipService.nullShips();
		List<ShippingCompany> sc = (List<ShippingCompany>) shippingService.FindAll();
		
		// Create countryList Map
		Map<String,String> shipsList = new HashMap<String,String>();
		Map<String,String> companiesList = new HashMap<String,String>();
		
		for (Ship ship : s) {
			
			shipsList.put( ship.getName(), "Cost= "+ship.getCost());
			
		}
		
		for (ShippingCompany company : sc) {
			
			companiesList.put(company.getName(), "Balance= "+company.getBalance());
			
		}

		model.addAttribute("ships", shipsList);
		model.addAttribute("companies", companiesList);

		
		//Go to the AddShip Page
		return "createOrder";
	}

	
	//Post method for adding ship
	//If user Adds an Entry on the AddShip JSP
	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public String addOrderdb(@Valid @ModelAttribute("order") OrderInfo order, BindingResult result) {
		
		
		//If the Post doesn't work, return to the Add Page
		if(result.hasErrors()) {
			
			return "createOrder";	
			
		}
		
		//Create new Company
		OrderInfo o = new OrderInfo();
		
		ShippingCompany company = order.getShippingCompany();
		o.setShippingCompany(company);
		
		Ship ship = order.getShip();
		o.setShip(ship);
		
		//Add the new Company
		orderService.saveOrder(o);

		return "redirect:showOrders";
	}

}
