package com.fdmgroup.service;

import javax.persistence.EntityManager;

import com.fdmgroup.dbconnection.DatabaseConnection;
import com.fdmgroup.model.dao.CommentDAO;
import com.fdmgroup.model.dao.CommentDAOImpl;

public class DeleteCommentService {

	DatabaseConnection connection = new DatabaseConnection();

	public boolean deleteComment(int commentId) {
		EntityManager em = connection.connect();
		CommentDAO commentDAO = new CommentDAOImpl(em);

		boolean commentRemoved = commentDAO.removeComment(commentId);
		if (commentRemoved)
			return true;
		else
			return false;
	}

}
