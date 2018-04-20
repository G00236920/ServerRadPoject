package com.ships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ships.model.ShippingCompany;


@Repository
public interface ShippingRepository extends CrudRepository<ShippingCompany,Integer>{
	//Allows the Ship Repo to extend the CRUD repo, Allowing for its methods to become available

}
