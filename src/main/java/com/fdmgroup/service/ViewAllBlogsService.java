package com.fdmgroup.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.dbconnection.DatabaseConnection;
import com.fdmgroup.model.dao.BlogDAO;
import com.fdmgroup.model.dao.BlogDAOImpl;
import com.fdmgroup.model.entity.Blog;

public class ViewAllBlogsService {
	DatabaseConnection connection = new DatabaseConnection();
	
	public List<Blog> listAllBlogs(){
		EntityManager em = connection.connect();
		BlogDAO blogDAO = new BlogDAOImpl(em);
		return blogDAO.listBlogs();
	}
	
}
