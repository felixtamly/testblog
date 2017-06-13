package com.fdmgroup.service;

import javax.persistence.EntityManager;

import com.fdmgroup.dbconnection.DatabaseConnection;
import com.fdmgroup.model.dao.MemberDAO;
import com.fdmgroup.model.dao.MemberDAOImpl;
import com.fdmgroup.model.entity.Member;

public class ViewMemberDetailsService {

	DatabaseConnection connection = new DatabaseConnection();
	
	public Member findMemberByUsername(String username) {
		EntityManager em = connection.connect();
		MemberDAO memberDAO = new MemberDAOImpl(em);
		
		return memberDAO.findMember(username);
	}
	
	public long findNumberOfPostsByMember(Member member) {
		EntityManager em = connection.connect();
		MemberDAO memberDAO = new MemberDAOImpl(em);
		
		return memberDAO.findNumberOfPostsByMember(member);
	}
}
