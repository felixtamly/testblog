package com.fdmgroup.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.model.entity.Blog;
import com.fdmgroup.service.ViewBlogDetailsService;

@Controller
public class ViewBlogDetailsController {

	ViewBlogDetailsService viewBlogDetailsService = new ViewBlogDetailsService();

	@RequestMapping(value = "/ShowDetails", method = { RequestMethod.GET, RequestMethod.POST })
	public String viewBlogDetails(@RequestParam(required = false) Integer blogId, HttpSession session, Model model) {
		Blog blog = null;
		if (blogId == null)
			blog = (Blog) session.getAttribute("sessionBlog");
		else
			blog = viewBlogDetailsService.getBlogById(blogId);
		session.setAttribute("sessionBlog", blog);
		model.addAttribute("blog", blog);
		return "blogdetails";
	}

}
