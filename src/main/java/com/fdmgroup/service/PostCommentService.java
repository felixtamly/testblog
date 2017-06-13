package com.fdmgroup.service;

import java.util.Date;

import javax.persistence.EntityManager;

import com.fdmgroup.dbconnection.DatabaseConnection;
import com.fdmgroup.model.dao.BlogDAO;
import com.fdmgroup.model.dao.BlogDAOImpl;
import com.fdmgroup.model.dao.CommentDAO;
import com.fdmgroup.model.dao.CommentDAOImpl;
import com.fdmgroup.model.entity.Blog;
import com.fdmgroup.model.entity.Comment;
import com.fdmgroup.model.entity.Member;

public class PostCommentService {

	DatabaseConnection connection = new DatabaseConnection();
	
	public Blog getBlogById(int blogId) {
		EntityManager em = connection.connect();
		BlogDAO blogDAO = new BlogDAOImpl(em);
		
		return blogDAO.findBlog(blogId);
	}
	
	public Comment createComment(Member member, Blog blog, Date dateOfPublication, String content) {
		EntityManager em = connection.connect();
		CommentDAO commentDAO = new CommentDAOImpl(em);
		
		Comment comment = commentDAO.createComment(member, blog, dateOfPublication, content);
		return comment;
	}
}
