package com.ships.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.services.ShipService;

@Controller
public class MainController {
	
	@RequestMapping(value = "/showShips", method=RequestMethod.GET)
	public String showShips(HttpServletRequest request, Model m) {
		
		m.addAttribute("/showShips", request.getRequestURI());
		m.addAttribute("ships",  ShipService.getAllShips());
		
		return "forward:showShips.jsp";
	}
	
	@RequestMapping(value = "/showShippingCompanies", method=RequestMethod.GET)
	public String showShippingCompanies(HttpServletRequest request, Model m) {
		m.addAttribute("/showShippingCompanies", request.getRequestURI());
		return "forward:showShippingCompanies.jsp";
	}
	
	@RequestMapping(value = "/showOrders", method=RequestMethod.GET)
	public String showOrders(HttpServletRequest request, Model m) {
		m.addAttribute("/showOrders", request.getRequestURI());
		return "forward:showOrders.jsp";
	}
	
	@RequestMapping(value = "/addShip", method=RequestMethod.GET)
	public String addNewShip( 
		@ModelAttribute("ship") Ship s) {
		
		return "forward:addShip.jsp";
	}
	
	@RequestMapping(value = "/addShippingCompany", method=RequestMethod.GET)
	public String addNewShippingCompany( 
		@ModelAttribute("company") ShippingCompany c) {
		
		return "forward:addShippingCompany.jsp";
	}
	
	@RequestMapping(value = "/createOrder", method=RequestMethod.GET)
	public String createNewOrder( 
		@ModelAttribute("order") OrderInfo o) {
		
		return "forward:createOrder.jsp";
	}

}

