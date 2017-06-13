package com.fdmgroup.model.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.entity.Blog;
import com.fdmgroup.model.entity.Comment;
import com.fdmgroup.model.entity.Member;

public class CommentDAOImpl implements CommentDAO {
	
	private EntityManager em;
	
	public CommentDAOImpl(EntityManager em){
		this.em = em;
	}
	
	@Override
	public Comment createComment(Member member, Blog blog, Date dateOfPublication, String content){
		em.getTransaction().begin();
		Comment comment = new Comment(member, blog, dateOfPublication, content);
		em.persist(comment);
		em.getTransaction().commit();
		return comment;
	}
	
	@Override
	public Comment findComment(int commentId){
		Comment comment = em.find(Comment.class, commentId);
		if(comment != null) return comment;
		else return null;
	}
	
	@Override
	public List<Comment> listComments(){
		TypedQuery<Comment> query = em.createQuery("Select c from BLOG_COMMENTS c", Comment.class);
		List<Comment> commentList = query.getResultList();
		return commentList;
	}
	
	@Override
	public boolean removeComment(int commentId){
		Comment comment = findComment(commentId);
		if(comment != null){
			em.getTransaction().begin();
			em.remove(comment);
			em.getTransaction().commit();
			return true;
		} else {
			return false;
		}
	}
}
