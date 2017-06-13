package com.fdmgroup.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fdmgroup.model.entity.Blog;
import com.fdmgroup.model.entity.Member;

public class Main {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testblog");
		EntityManager em = emf.createEntityManager();
		MemberDAO memberDAO = new MemberDAOImpl(em);
		BlogDAO blogDAO = new BlogDAOImpl(em);
		
		Member member = memberDAO.findMember("username2");
//		blogDAO.createBlog(member, new Date(), "title1", "content1");
		
		System.out.println(memberDAO.findMemberByEmail("email4"));
		
		Blog blog = blogDAO.findBlog(2);
		System.out.println(blog.getTitle());
		
//		blogDAO.removeBlog(1);
		
		List<Blog> blogList = blogDAO.listBlogs();
		for(Blog b : blogList) System.out.println(b.getTitle());
		
//		memberDAO.removeMember("username2");
//		memberDAO.createMember("username2", "email2", "password1", new Date());
//		Member memberFound = memberDAO.findMember("username1");
		List<Member> memberList = memberDAO.listMembers();
		for(Member m : memberList) System.out.println(m.getUsername());
		em.close();
		emf.close();
	}

}
