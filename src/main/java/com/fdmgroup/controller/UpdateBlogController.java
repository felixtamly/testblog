package com.fdmgroup.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.model.entity.Blog;
import com.fdmgroup.service.UpdateBlogService;

@Controller
public class UpdateBlogController {
	
	UpdateBlogService updateBlogService = new UpdateBlogService();
	
	@RequestMapping(value = "/UpdatePost", method = RequestMethod.POST)
	public String updateBlog(@RequestParam int blogId, String title, String content, HttpSession session){
		Blog blog = updateBlogService.updateBlog(blogId, title, content);
		session.setAttribute("sessionBlog", blog);
		return "redirect:/ShowDetails";
	}
}
