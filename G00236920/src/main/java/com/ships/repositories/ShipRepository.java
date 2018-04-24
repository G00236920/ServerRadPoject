package com.ships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ships.model.Ship;


@Repository
public interface ShipRepository extends CrudRepository<Ship,Integer>{
	//Allows the Ship Repo to extend the CRUD repo, Allowing for its methods to become available

	public List<Ship> findByShippingCompanyIsNull();
	
}
