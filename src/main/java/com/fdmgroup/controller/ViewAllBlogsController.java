package com.fdmgroup.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.model.entity.Blog;
import com.fdmgroup.service.ViewAllBlogsService;

@Controller
public class ViewAllBlogsController {
	
	ViewAllBlogsService viewAllBlogsService = new ViewAllBlogsService();
	
	@RequestMapping(value = {"/", "/homepage"}, method = RequestMethod.GET)
	public String returnToHomepage(Model model, HttpSession session){
		PagedListHolder<Blog> pagedBlogList = new PagedListHolder<Blog>(viewAllBlogsService.listAllBlogs());
		pagedBlogList.setPageSize(5);
	
		pagedBlogList.setPage(0);
		
		session.setAttribute("pagedBlogList", pagedBlogList);
		session.setAttribute("isFirstPage", pagedBlogList.isFirstPage());
		session.setAttribute("isLastPage", pagedBlogList.isLastPage());
		session.setAttribute("pageNumber", pagedBlogList.getPage()+1);
		model.addAttribute("blogList", pagedBlogList.getPageList());
		return "homepage";
	}
	
	@RequestMapping(value="/homepage/{pageId}")
	public ModelAndView edit(@PathVariable int pageId) {
		List<Blog> blogList = viewAllBlogsService.listAllBlogsByPage(pageId);
		ModelAndView model = new ModelAndView("homepage", "blogList", blogList);
		
		return model;
	}
	
	@RequestMapping(value="/nextpage")
	public String showNextPage(Model model, HttpSession session) {
		@SuppressWarnings("unchecked")
		PagedListHolder<Blog> pagedBlogList = (PagedListHolder<Blog>) session.getAttribute("pagedBlogList");
		pagedBlogList.nextPage();
		session.setAttribute("isFirstPage", pagedBlogList.isFirstPage());
		session.setAttribute("isLastPage", pagedBlogList.isLastPage());
		session.setAttribute("pageNumber", pagedBlogList.getPage()+1);
		session.setAttribute("pagedBlogList", pagedBlogList);
		model.addAttribute("blogList", pagedBlogList.getPageList());
		return "homepage";
	}
	
	@RequestMapping(value="/previouspage")
	public String showPreviousPage(Model model, HttpSession session) {
		@SuppressWarnings("unchecked")
		PagedListHolder<Blog> pagedBlogList = (PagedListHolder<Blog>) session.getAttribute("pagedBlogList");
		pagedBlogList.previousPage();
		session.setAttribute("isFirstPage", pagedBlogList.isFirstPage());
		session.setAttribute("isLastPage", pagedBlogList.isLastPage());
		session.setAttribute("pageNumber", pagedBlogList.getPage()+1);
		session.setAttribute("pagedBlogList", pagedBlogList);
		model.addAttribute("blogList", pagedBlogList.getPageList());
		return "homepage";
	}
	
}
