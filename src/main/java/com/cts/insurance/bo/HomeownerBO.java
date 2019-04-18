package com.cts.insurance.bo;

import java.io.IOException;
import java.sql.SQLException;

import com.cts.insurance.dao.HomeownerDAO;
import com.cts.insurance.model.Homeowner;

public class HomeownerBO {

	public Homeowner createHomeowner(Homeowner homeowner) throws SQLException, ClassNotFoundException, IOException {

		HomeownerDAO hd = new HomeownerDAO();		
		return hd.createHomeowner(homeowner);
		
	}
	
	public Homeowner getAllHomeownerByUserId(int userId) throws ClassNotFoundException, IOException, SQLException {

		Homeowner h = new Homeowner();
		HomeownerDAO hd = new HomeownerDAO();		
		h = hd.getAllHomeownerByUserId(userId);
		
		return h;
	}
}
