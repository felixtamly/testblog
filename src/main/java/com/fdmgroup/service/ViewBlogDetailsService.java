package com.fdmgroup.service;

import javax.persistence.EntityManager;

import com.fdmgroup.dbconnection.DatabaseConnection;
import com.fdmgroup.model.dao.BlogDAO;
import com.fdmgroup.model.dao.BlogDAOImpl;
import com.fdmgroup.model.entity.Blog;

public class ViewBlogDetailsService {
	
	DatabaseConnection connection = new DatabaseConnection();
	
	public Blog getBlogById(int blogId) {
		EntityManager em = connection.connect();
		BlogDAO blogDAO = new BlogDAOImpl(em);
		return blogDAO.findBlog(blogId);
	}
}
