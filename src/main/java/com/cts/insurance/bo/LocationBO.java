package com.cts.insurance.bo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cts.insurance.dao.LocationDAO;
import com.cts.insurance.model.Location;

public class LocationBO {
	LocationDAO ld;

	public LocationBO() {
		ld = new LocationDAO();
		
	}

	public Integer createLocation(Location location) throws SQLException, ClassNotFoundException, IOException {

		Integer Id = ld.createLocation(location);

		return Id;

	}

	public List<Location> getAllLocationByUserId(int userId) throws ClassNotFoundException, IOException, SQLException {

		LocationDAO ld = new LocationDAO();
		List<Location> locationList;
		locationList = ld.getAllLocationByUserId(userId);

		return locationList;

	}

}
