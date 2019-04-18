package com.cts.insurance.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cts.insurance.bo.PolicyBO;
import com.cts.insurance.bo.UserBO;
import com.cts.insurance.model.Policy;
import com.cts.insurance.model.User;

@Controller
@SessionAttributes("currentUser")

public class HomeController {
	List<String> errorList;

	@RequestMapping("/AdminPage")
	public String adminLoginPage() {

		System.out.println("Hi! admin");

		return "/AdminPage";
	}

	@RequestMapping("/AdminLogin")

	public String AdminLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Search page");

		HttpSession session = request.getSession();

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		UserBO ub = new UserBO();
		User user = ub.getUserByName(userName);

		if (user == null) {
			errorList = new ArrayList<>();
			errorList.add("Invalid Login");
			request.setAttribute("errorList", errorList);
			return "/AdminPage";
		} else {
			System.out.println(user.getAdminRole());
			if (password.equals(user.getPassword()) && user.getAdminRole().equals("admin")) {
				session.setAttribute("currentUser", user);
				return "/SearchPage";
			} else {
				errorList = new ArrayList<>();
				errorList.add("Invalid Login");
				request.setAttribute("errorList", errorList);
				return "/AdminPage";
			}
		}
	}

	@RequestMapping(value = "/SearchPage", method = RequestMethod.POST)
	public String searchPage() {
		System.out.println("Search page");
		return "/SearchPage";
	}

	@RequestMapping(value = "/SearchUser", method = RequestMethod.POST)
	public String SearchUser(HttpSession session, @ModelAttribute("SBA_Spring") User user, ModelMap model)
			throws ClassNotFoundException, IOException, SQLException {
		model.addAttribute("userName", user.getUserName());
		System.out.println(user.getUserName());

		UserBO u_bo = new UserBO();
		User u = u_bo.getUserByName(user.getUserName());
		int userId = u.getUserId();
		session.setAttribute("user", user);

		List<Policy> policies = new ArrayList<>();
		Policy policy = new Policy();
		System.out.println(u.getUserId());
		System.out.println(u.getUserName());
		PolicyBO policyBO = new PolicyBO();
		policies = (List<Policy>) policyBO.getAllPolicyByUserId(userId);
		session.setAttribute("policies", policies);
		policies = (List<Policy>) session.getAttribute("policies");

		return "/SearchResult";
	}

	@RequestMapping(value = "/updatePolicy", method = RequestMethod.POST)
	public String updatePolicy(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException, ParseException {
		System.out.println("updatePolicy");
		int pid = Integer.parseInt(request.getParameter("pid"));
		String element = request.getParameter("ele");
		System.out.println(element);
		System.out.println(pid);

		Policy p = new Policy();
		PolicyBO polb = new PolicyBO();
		
		// Setup Dates
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		java.util.Date effectiveDate = Calendar.getInstance().getTime();
//		java.util.Date fd = formatter.parse(effectiveDate);
//		java.sql.Date sqlDate = new java.sql.Date(fd.getTime());

		Calendar c = Calendar.getInstance();

		c.setTime(Calendar.getInstance().getTime());
		

		// Renew policy
		if (element.equals("update")) {
			c.add(Calendar.DAY_OF_MONTH, 365);

			java.util.Date endDate = c.getTime();
			java.sql.Date sqlDate1 = new java.sql.Date(endDate.getTime());
			System.out.println(sqlDate1);

			p.setPolicyStatus("active");
			p.setEndDate(sqlDate1);
			p.setPolicyId(pid);
		}

		// Cancel policy
		else if (element.equals("delete")) {
			java.util.Date endDate = c.getTime();
			java.sql.Date sqlDate1 = new java.sql.Date(endDate.getTime());
			System.out.println(sqlDate1);
			
			p.setPolicyStatus("cancel");
			p.setEndDate(sqlDate1);
			p.setPolicyId(pid);
		}

		Boolean confirmUpdate = polb.updatePolicy(p);
		System.out.println(confirmUpdate);

		return "/SearchPage";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "AdminPage";
	}

}
