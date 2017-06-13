package com.fdmgroup.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name="BLOG_COMMENTS")
public class Comment {

	@Id
	@Column(name="COMMENT_ID")
	@SequenceGenerator(name="commentIdSeq", sequenceName="BLOG_COMMENT_ID_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="commentIdSeq")
	private int commentId;
	
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name="BLOG_ID")
	private Blog blog;
	
	@Column(name="DATE_OF_PUBLICATION")
	private Date dateOfPublication;
	
	private String content;
	
	public Comment(){
		
	}

	public Comment(Member member, Blog blog, Date dateOfPublication, String content) {
		this.member = member;
		this.blog = blog;
		this.dateOfPublication = dateOfPublication;
		this.content = content;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public Date getDateOfPublication() {
		return dateOfPublication;
	}

	public void setDateOfPublication(Date dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
