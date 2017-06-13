package com.fdmgroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.service.DeleteBlogService;

@Controller
public class DeleteBlogController {
	
	DeleteBlogService deleteBlogService = new DeleteBlogService();

	@RequestMapping(value = "/DeletePost", method = RequestMethod.POST)
	public String deleteBlog(@RequestParam int blogId){
		deleteBlogService.deleteBlog(blogId);
		return "redirect:/listYourPosts";
	}
	
}
