package com.ships.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.model.OrderInfo;

@Service
public class Connection {
	
	 
    static Connection conn = null;
    static String username = "root";
    static String password = "";

    public static List<Ship> allShips() {
    	  	
        String sql = "select * from ship;";
        
		return null;

    }
    
    public List<ShippingCompany> allCompanies() {
    	
        String sql = "select * from shipping_company";
        
		return null;

    }
    
    public List<OrderInfo> allOrders() {
    	
        String sql = "select * from order_info";
        
		return null;

    }

}
