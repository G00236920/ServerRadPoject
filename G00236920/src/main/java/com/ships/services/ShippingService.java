package com.ships.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.ShippingCompany;
import com.ships.repositories.CompanyRepository;

@Service
public class ShippingService {
	@Autowired
	CompanyRepository shippingRepository;
	
	//Get an Iterable list from the SQL Database
	public Iterable<ShippingCompany> FindAll() {

		return shippingRepository.findAll();
	}
	
	//Add a new Ship to SQL
	public ShippingCompany saveCompany(ShippingCompany c) {
		
		return shippingRepository.save(c);
	}


}
