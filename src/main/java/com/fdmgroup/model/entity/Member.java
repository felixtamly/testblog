package com.fdmgroup.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "BLOG_MEMBERS")
public class Member {

	@Id
	@Column
	private String username;

	@Column
	private String email;

	@Column
	private String password;

	@Column(name = "DATE_OF_BIRTH")
	private Date dateOfBirth;

	public Member() {
	}

	public Member(String username, String email, String password, Date dateOfBirth) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
