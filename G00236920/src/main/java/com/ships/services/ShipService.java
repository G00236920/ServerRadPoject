package com.ships.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ships.model.Ship;
import com.ships.repositories.ShipRepository;

@Service
public class ShipService {
	@Autowired
	ShipRepository shipRepository;
	
	//Get an Iterable list from the SQL Database
	public Iterable<Ship> FindAll() {

		return shipRepository.findAll();
	}
	
	//Add a new Ship to SQL
	public Ship saveShip(Ship s) {
		
		return shipRepository.save(s);
	}


}
