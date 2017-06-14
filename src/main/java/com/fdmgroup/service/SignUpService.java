package com.fdmgroup.service;

import java.util.Date;

import javax.persistence.EntityManager;

import com.fdmgroup.dbconnection.DatabaseConnection;
import com.fdmgroup.model.dao.MemberDAO;
import com.fdmgroup.model.dao.MemberDAOImpl;
import com.fdmgroup.model.entity.Member;

public class SignUpService {

	DatabaseConnection connection = new DatabaseConnection();

	public boolean checkAccount(String username, String email) {
		EntityManager em = connection.connect();
		MemberDAO memberDAO = new MemberDAOImpl(em);
		Boolean usernameExists = memberDAO.findMemberByUsername(username);
		Boolean emailExists = memberDAO.findMemberByEmail(email);
		if (!usernameExists && !emailExists)
			return true;
		else
			return false;
	}

	public boolean checkReenteredPassword(String password, String reenteredPassword) {
		if (password.equals(reenteredPassword))
			return true;
		else
			return false;
	}

	public Member createAccount(String username, String email, String password, Date dateOfBirth) {
		EntityManager em = connection.connect();
		MemberDAO memberDAO = new MemberDAOImpl(em);
		Member member = memberDAO.createMember(username, email, password, dateOfBirth);
		return member;
	}

}
