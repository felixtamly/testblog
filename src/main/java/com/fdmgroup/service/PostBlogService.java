package com.fdmgroup.service;

import java.util.Date;

import javax.persistence.EntityManager;

import com.fdmgroup.dbconnection.DatabaseConnection;
import com.fdmgroup.model.dao.BlogDAO;
import com.fdmgroup.model.dao.BlogDAOImpl;
import com.fdmgroup.model.entity.Blog;
import com.fdmgroup.model.entity.Member;

public class PostBlogService {
	
	DatabaseConnection connection = new DatabaseConnection();

	public boolean checkByteCountExceeds(String content) {
		if (content.getBytes().length > 4000)
			return true;
		else
			return false;
	}

	public Blog createBlog(Member member, Date dateOfPublication, String title, String content) {
		EntityManager em = connection.connect();
		BlogDAO blogDAO = new BlogDAOImpl(em);
		Blog blog = blogDAO.createBlog(member, dateOfPublication, title, content);
		return blog;
	}
}
