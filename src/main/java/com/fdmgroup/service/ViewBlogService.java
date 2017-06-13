package com.fdmgroup.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.dbconnection.DatabaseConnection;
import com.fdmgroup.model.dao.BlogDAO;
import com.fdmgroup.model.dao.BlogDAOImpl;
import com.fdmgroup.model.entity.Blog;
import com.fdmgroup.model.entity.Member;

public class ViewBlogService {
	
	DatabaseConnection connection = new DatabaseConnection();

	public List<Blog> listBlogsByMember(Member member) {
		EntityManager em = connection.connect();
		BlogDAO blogDAO = new BlogDAOImpl(em);
		List<Blog> blogList = blogDAO.listBlogsByMember(member);
		return blogList;
	}

}
