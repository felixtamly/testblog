package com.fdmgroup.service;

import javax.persistence.EntityManager;

import com.fdmgroup.dbconnection.DatabaseConnection;
import com.fdmgroup.model.dao.MemberDAO;
import com.fdmgroup.model.dao.MemberDAOImpl;
import com.fdmgroup.model.entity.Member;

public class ChangePasswordService {

	DatabaseConnection connection = new DatabaseConnection();

	public boolean checkOriginalPassword(Member member, String enteredPassword) {

		String passwordInSystem = member.getPassword();

		if (enteredPassword.equals(passwordInSystem))
			return true;
		else
			return false;
	}
	
	public boolean changePassword(Member member, String enteredPassword) {
		if (member != null) {			
			EntityManager em = connection.connect();
			MemberDAO memberDAO = new MemberDAOImpl(em);
			
			memberDAO.updatePassword(member, enteredPassword);
			return true;
		} else {
			return false;
		}
	}

}
