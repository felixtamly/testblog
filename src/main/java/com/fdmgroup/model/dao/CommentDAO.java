package com.fdmgroup.model.dao;

import java.util.Date;
import java.util.List;

import com.fdmgroup.model.entity.Blog;
import com.fdmgroup.model.entity.Comment;
import com.fdmgroup.model.entity.Member;

public interface CommentDAO {

	Comment createComment(Member member, Blog blog, Date dateOfPublication, String content);

	Comment findComment(int commentId);

	List<Comment> listComments();

	boolean removeComment(int commentId);

}