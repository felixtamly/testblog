package com.fdmgroup.service;

import javax.persistence.EntityManager;

import com.fdmgroup.dbconnection.DatabaseConnection;
import com.fdmgroup.model.dao.MemberDAO;
import com.fdmgroup.model.dao.MemberDAOImpl;
import com.fdmgroup.model.entity.Member;

public class LogInService {

	DatabaseConnection connection = new DatabaseConnection();

	public boolean checkAccount(String username, String password) {
		EntityManager em = connection.connect();
		MemberDAO memberDAO = new MemberDAOImpl(em);
		Boolean usernameExists = memberDAO.findMemberByUsername(username);
		if (usernameExists) {
			String correctPassword = memberDAO.findMember(username).getPassword();
			if (password.equals(correctPassword))
				return true;
			else
				return false;
		} else
			return false;
	}

	public Member logInMember(String username) {
		EntityManager em = connection.connect();
		MemberDAO memberDAO = new MemberDAOImpl(em);
		return memberDAO.findMember(username);
	}
}
