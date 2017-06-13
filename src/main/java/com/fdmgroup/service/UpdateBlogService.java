package com.fdmgroup.service;

import javax.persistence.EntityManager;

import com.fdmgroup.dbconnection.DatabaseConnection;
import com.fdmgroup.model.dao.BlogDAO;
import com.fdmgroup.model.dao.BlogDAOImpl;
import com.fdmgroup.model.entity.Blog;

public class UpdateBlogService {
	
	DatabaseConnection connection = new DatabaseConnection();

	public Blog updateBlog(int blogId, String title, String content) {
		EntityManager em = connection.connect();
		BlogDAO blogDAO = new BlogDAOImpl(em);
		return blogDAO.updateBlog(blogId, title, content);
	}

}
