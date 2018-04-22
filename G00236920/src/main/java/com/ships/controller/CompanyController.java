package com.ships.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.services.ShippingService;


@Controller
public class CompanyController {
	

//SHIPPING COMPANY	
	
	@Autowired
	private ShippingService shippingService;
	
	
	//Get Method for Showing companies
	//If user clicks a link to enter the ShowShip JSP
	@RequestMapping(value = "/showShippingCompanies", method = RequestMethod.GET)
	public String listShipping(Model model, HttpServletRequest h) {
		
		//Create a list of ships from the Sql data
		ArrayList<ShippingCompany> c = (ArrayList<ShippingCompany>) shippingService.FindAll();

		//Add Companies so it can be viewed
		model.addAttribute("companies", c);

		//Show the companies page
		return "showShippingCompanies";
	}
	
	//Get Method for Adding ship
	//If user clicks a link to enter the AddShip JSP
	@RequestMapping(value = "/addShippingCompany", method = RequestMethod.GET)
	public String addCompany(@ModelAttribute("companies") ShippingCompany company, HttpServletRequest h) {
		
		//Go to the AddShip Page
		return "addShippingCompany";
	}

	
	
	//Post method for adding ship
	//If user Adds an Entry on the AddShippingCompany JSP
	@RequestMapping(value = "/addShippingCompany", method = RequestMethod.POST)
	public String addCompanydb(@Valid @ModelAttribute("company") ShippingCompany company, BindingResult result) {
		
		
		//If the Post doesn't work, return to the Add Page
		if(result.hasErrors()) {
			
			return "addShippingCompany";
			
		}

		//Create new Company
		ShippingCompany c = new ShippingCompany();
		
		//Add variables to SQL
		int scid = company.getScid();
		c.setScid(scid);
		
		String name = company.getName();
		c.setName(name);
		
		String homePort = company.getHomePort();
		c.setHomePort(homePort);
		
		BigDecimal balance = company.getBalance();
		c.setBalance(balance);
		
		List<Ship> ships = company.getShips();
		c.setShips(ships);
		
		//Add the new Company
		shippingService.saveCompany(c);
		 
		
		//Redirect to the Show Ships page once Complete
		return "redirect:showShippingCompanies";
	}
	
}
