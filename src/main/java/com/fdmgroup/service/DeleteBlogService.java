package com.fdmgroup.service;

import javax.persistence.EntityManager;

import com.fdmgroup.dbconnection.DatabaseConnection;
import com.fdmgroup.model.dao.BlogDAO;
import com.fdmgroup.model.dao.BlogDAOImpl;

public class DeleteBlogService {

	DatabaseConnection connection = new DatabaseConnection();

	public boolean deleteBlog(int blogId) {
		EntityManager em = connection.connect();
		BlogDAO blogDAO = new BlogDAOImpl(em);
		boolean blogRemoved = blogDAO.removeBlog(blogId);
		if (blogRemoved)
			return true;
		else
			return false;
	}

}
