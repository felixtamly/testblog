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

@Entity(name = "BLOG_BLOGS")
public class Blog {

	@Id
	@Column(name="BLOG_ID")
	@SequenceGenerator(name="blogIdSeq", sequenceName="BLOG_BLOG_ID_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="blogIdSeq")
	private int blogId;
	
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private Member member;
	
	@Column(name="DATE_OF_PUBLICATION")
	private Date dateOfPublication;
	
	private String title;
	
	private String content;
	
	public Blog(){
		
	}

	public Blog(Member member, Date dateOfPublication, String title, String content) {
		this.member = member;
		this.dateOfPublication = dateOfPublication;
		this.title = title;
		this.content = content;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Date getDateOfPublication() {
		return dateOfPublication;
	}

	public void setDateOfPublication(Date dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
