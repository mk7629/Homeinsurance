package com.cts.insurance.bo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cts.insurance.dao.UserDAO;
import com.cts.insurance.model.User;

public class UserBO {
	UserDAO ud;
	
	public UserBO() {
		ud = new UserDAO();
		
	}
	
	public Integer registerUser(User user) throws SQLException, ClassNotFoundException, IOException {

		Integer Id = ud.registerUser(user);
		
		return Id;

	}

	public User getUserByName(String name) throws ClassNotFoundException, IOException, SQLException {

		User u = new User();
		u = ud.getUserByName(name);
		return u;

	}
	
	public List<User> getAllUsers() throws SQLException {

		List<User> userList = ud.getAllUsers();
		
		return userList;
	}
}
