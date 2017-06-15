package com.fdmgroup.model.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.jdbc.core.JdbcTemplate;

import com.fdmgroup.model.entity.Blog;
import com.fdmgroup.model.entity.Member;

public class BlogDAOImpl implements BlogDAO {

	private EntityManager em;
	JdbcTemplate template;

	public BlogDAOImpl(EntityManager em) {
		this.em = em;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public Blog createBlog(Member member, Date dateOfPublication, String title, String content) {
		Blog blog = new Blog(member, dateOfPublication, title, content);

		em.getTransaction().begin();
		em.merge(blog);
		em.getTransaction().commit();

		return blog;
	}

	@Override
	public Blog findBlog(int blogId) {

		Blog blog = em.find(Blog.class, blogId);
		if (blog != null)
			return blog;
		else
			return null;

	}

	@Override
	public List<Blog> listBlogs() {
		List<Blog> blogList = null;

		TypedQuery<Blog> query = em.createQuery("Select b from BLOG_BLOGS b order by b.dateOfPublication desc",
				Blog.class);
		blogList = query.getResultList();

		return blogList;
	}

	@Override
	public List<Blog> listBlogsByMember(Member member) {
		List<Blog> blogList = null;

		TypedQuery<Blog> query = em
				.createQuery("Select b from BLOG_BLOGS b where b.member = :member order by b.dateOfPublication desc",
						Blog.class)
				.setParameter("member", member);
		blogList = query.getResultList();

		return blogList;
	}

	@Override
	public List<Blog> listBlogsByMemberByDateAsc(Member member) {
		List<Blog> blogList = null;

		TypedQuery<Blog> query = em
				.createQuery("Select b from BLOG_BLOGS b where b.member = :member order by b.dateOfPublication",
						Blog.class)
				.setParameter("member", member);
		blogList = query.getResultList();

		return blogList;
	}

	@Override
	public List<Blog> listBlogsByMemberByTitleAsc(Member member) {
		List<Blog> blogList = null;

		TypedQuery<Blog> query = em
				.createQuery("Select b from BLOG_BLOGS b where b.member = :member order by lower(b.title)", Blog.class)
				.setParameter("member", member);
		blogList = query.getResultList();

		return blogList;
	}

	@Override
	public List<Blog> listBlogsByMemberByTitleDesc(Member member) {
		List<Blog> blogList = null;

		TypedQuery<Blog> query = em
				.createQuery("Select b from BLOG_BLOGS b where b.member = :member order by lower(b.title) desc",
						Blog.class)
				.setParameter("member", member);
		blogList = query.getResultList();

		return blogList;
	}

	@Override
	public Blog updateBlog(int blogId, String title, String content) {

		Blog blog = em.find(Blog.class, blogId);
		if (blog != null) {
			em.getTransaction().begin();
			blog.setTitle(title);
			blog.setContent(content);
			em.merge(blog);
			em.getTransaction().commit();
			return blog;
		} else
			return null;

	}

	@Override
	public boolean removeBlog(int blogId) {
		Blog blog = findBlog(blogId);

		if (blog != null) {
			em.getTransaction().begin();
			em.remove(blog);
			em.getTransaction().commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Blog> getBlogsByPage(int pageId) {
		List<Blog> trimmedResultList = null;
		int begin = pageId * 5 - 5;
		int end = pageId * 5;

		String jpql = "Select b from BLOG_BLOGS b order by b.dateOfPublication desc";
		TypedQuery<Blog> queryResult = em.createQuery(jpql, Blog.class);
		List<Blog> resultList = queryResult.getResultList();
		for (Blog blog : resultList)
			System.out.println(blog.getBlogId());

		if (resultList.size() < end)
			trimmedResultList = resultList.subList(begin, resultList.size());
		else
			trimmedResultList = resultList.subList(begin, end);

		for (Blog blog : trimmedResultList)
			System.out.println("trimmed: " + blog.getBlogId());

		return trimmedResultList;
	}

}
