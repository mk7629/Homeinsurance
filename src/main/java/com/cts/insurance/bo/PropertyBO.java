package com.cts.insurance.bo;

import java.io.IOException;
import java.sql.SQLException;

import com.cts.insurance.dao.LocationDAO;
import com.cts.insurance.dao.PropertyDAO;
import com.cts.insurance.model.Property;

public class PropertyBO {
	public Property createProperty(Property property) throws SQLException, ClassNotFoundException, IOException {

		PropertyDAO pd = new PropertyDAO();
		return pd.createProperty(property);

		
	}
	
	public Property getAllPropertyByLocationId(int locationId) throws ClassNotFoundException, IOException, SQLException {
		Property p = new Property();
		PropertyDAO pd = new PropertyDAO();
		p = pd.getAllPropertyByLocationId(locationId);
		
		return p;
		
	}

}
