package com.ships.services;

import org.springframework.stereotype.Service;

import com.ships.model.Ship;
import com.ships.repositories.ShipRepo;

@Service
public class ShipService {
	
	static ShipRepo sr;
	
	public static Iterable<Ship> getAllShips(){
		
		return sr.findAll();
	}

}
