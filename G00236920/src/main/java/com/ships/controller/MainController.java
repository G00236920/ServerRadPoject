package com.ships.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

import com.ships.services.ShipService;


@Controller
public class MainController {
	@Autowired
	private ShipService shipService;
	
	
	@RequestMapping(value = "/showShips", method = RequestMethod.GET)
	public String listPeople(Model model, HttpServletRequest h) {
		ArrayList<Ship> s = (ArrayList<Ship>) shipService.FindAll();

		model.addAttribute("ships", s);

		return "showShips";
	}
	
	@RequestMapping(value = "/addShip", method = RequestMethod.GET)
	public String addShip(@ModelAttribute("ship") Ship ship, HttpServletRequest h) {
		System.out.println("HTTP Request = " + h.getMethod());
		return "addShip";
	}

	
	@RequestMapping(value = "/addShip", method = RequestMethod.POST)
	public String addShipdb(@Valid @ModelAttribute("ship") Ship ship, BindingResult result) {
		if(result.hasErrors()) {
			return "addShip";
		}
		Ship s = new Ship();
		String name = ship.getName();
		int passengers = ship.getPassengers();
		BigDecimal cost = ship.getCost();
		double metres = ship.getMetres();
		s.setName(name);
		s.setPassengers(passengers);
		s.setCost(cost);
		s.setMetres(metres);
		shipService.saveShip(s);
		
		
		
		return "redirect:showShips";
	}
	
	
	
}
