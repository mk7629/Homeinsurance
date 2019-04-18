package com.cts.insurance.bo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cts.insurance.dao.PolicyDAO;
import com.cts.insurance.dao.UserDAO;
import com.cts.insurance.model.Policy;

public class PolicyBO {
	PolicyDAO pold;

	public PolicyBO() {
		pold = new PolicyDAO();

	}

	public Integer createPolicy(Policy policy) throws SQLException, ClassNotFoundException, IOException {

		Integer Id = pold.createPolicy(policy);

		return Id;

	}

	public List<Policy> getAllPolicyByUserId(int userId) throws ClassNotFoundException, IOException, SQLException {

		PolicyDAO pold = new PolicyDAO();
		List<Policy> policyList;
		policyList = pold.getAllPolicyByUserId(userId);

		return policyList;

	}

	public Boolean updatePolicy(Policy policy) throws SQLException, ClassNotFoundException, IOException {

		PolicyDAO pold = new PolicyDAO();
		pold.updatePolicy(policy);

		return false;

	}
}
