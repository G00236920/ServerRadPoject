package com.ships.controller;

import java.math.BigDecimal;
import java.util.ArrayList;

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
import com.ships.services.ShipService;


@Controller
public class ShipController {
	
//SHIPS	
	
	@Autowired
	private ShipService shipService;
	
	
	//Get Method for Showing Ships
	//If user clicks a link to enter the ShowShip JSP
	@RequestMapping(value = "/showShips", method = RequestMethod.GET)
	public String listShips(Model model, HttpServletRequest h) {
		
		//Create a list of ships from the Sql data
		ArrayList<Ship> s = (ArrayList<Ship>) shipService.FindAll();

		//Add ships so it can be viewed
		model.addAttribute("ships", s);

		//Show the ships page
		return "showShips";
	}
	
	//Get Method for Adding ship
	//If user clicks a link to enter the AddShip JSP
	@RequestMapping(value = "/addShip", method = RequestMethod.GET)
	public String addShip(@ModelAttribute("ship") Ship ship, HttpServletRequest h) {
		
		//Go to the AddShip Page
		return "addShip";
	}

	
	//Post method for adding ship
	//If user Adds an Entry on the AddShip JSP
	@RequestMapping(value = "/addShip", method = RequestMethod.POST)
	public String addShipdb(@Valid @ModelAttribute("ship") Ship ship, BindingResult result) {
		
		
		//If the Post doesn't work, return to the Add Page
		if(result.hasErrors()) {
			
			return "addShip";
			
		}
		
		//Create new Ship
		Ship s = new Ship();
		
		//Give the ship a Name
		String name = ship.getName();
		s.setName(name);
		
		//How many Passengers on the ship
		int passengers = ship.getPassengers();
		s.setPassengers(passengers);
		
		//Cost for the ship
		BigDecimal cost = ship.getCost();
		s.setCost(cost);
		
		//Length of the ship
		double metres = ship.getMetres();
		s.setMetres(metres);
		
		//Add the ship to the ship service
		shipService.saveShip(s);
		
		//Redirect to the Show Ships page once Complete
		return "redirect:showShips";
	}

}
