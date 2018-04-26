package com.ships.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	
	@SuppressWarnings("unused")
	private String errorMessage;
	
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
		Map<Integer,String> shipsList = new HashMap<Integer,String>();
		Map<Integer,String> companiesList = new HashMap<Integer,String>();
		
		for (Ship ship : s) {
			
			shipsList.put(ship.getSid(), ship.getName()+";"+" Cost="+ship.getCost());
			
		}
		
		for (ShippingCompany company : sc) {
			
			companiesList.put(company.getScid(), company.getName()+";"+" Balance= " +company.getBalance());
			
		}

		model.addAttribute("ships", shipsList);
		model.addAttribute("companies", companiesList);

		
		//Go to the AddShip Page
		return "createOrder";
	}

	
	//Post method for adding ship
	//If user Adds an Entry on the AddShip JSP
	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public String addOrderdb(@ModelAttribute("order") OrderInfo order, BindingResult result) {
		
		
		//If the Post doesn't work, return to the Add Page
		if(result.hasErrors()) {
			
			return "redirect:errorPage";
			
		}
		
		//Create new Company
		OrderInfo o = new OrderInfo();
		
		ShippingCompany company = order.getShippingCompany();
		o.setShippingCompany(company);
		
		Ship ship = order.getShip();
		o.setShip(ship);

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(new java.util.Date());
		
		//if the company balance is greater than the ship cost
		if(company.getBalance().compareTo(ship.getCost()) <= 0){
			
			this.errorMessage = "Shipping Company Balance is less than the cost of the ship - Cannot place order";
			return "redirect:errorPage";
			
		}
		//if there is no ship or company
		else if(ship == null || company == null) {
			
			this.errorMessage = "No ship or company selected";
			return "redirect:errorPage";
			
		}
		else {
			
			//set date
			o.setDate(date);
			
			//Add the new order
			orderService.saveOrder(o);
			
			//subtract the cost of the ship
			BigDecimal balance = company.getBalance().subtract(ship.getCost());
			
			//set new balance
			company.setBalance(balance);
			
			shippingService.saveCompany(company);

			return "redirect:showOrders";
			
		}


	}
	
	//error page
	@RequestMapping(value = "/errorPage", method = RequestMethod.GET)
	public String addOrder() {
		
		
		//Go to the AddShip Page
		return "errorPage";
	}

}
