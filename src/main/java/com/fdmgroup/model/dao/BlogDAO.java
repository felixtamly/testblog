package com.fdmgroup.model.dao;

import java.util.Date;
import java.util.List;

import com.fdmgroup.model.entity.Blog;
import com.fdmgroup.model.entity.Member;

public interface BlogDAO {

	Blog createBlog(Member member, Date dateOfPublication, String title, String content);

	Blog findBlog(int blogId);

	List<Blog> listBlogs();

	List<Blog> listBlogsByMember(Member member);
	
	List<Blog> listBlogsByMemberByTitleDesc(Member member);
	
	List<Blog> listBlogsByMemberByTitleAsc(Member member);
	
	List<Blog> listBlogsByMemberByDateAsc(Member member);
	
	boolean removeBlog(int blogId);

	Blog updateBlog(int blogId, String title, String content);

	List<Blog> getBlogsByPage(int pageId);



}