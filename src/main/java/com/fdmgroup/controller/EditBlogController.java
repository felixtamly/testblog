package com.fdmgroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.model.entity.Blog;
import com.fdmgroup.service.EditBlogService;

@Controller
public class EditBlogController {

	EditBlogService editBlogService = new EditBlogService();
	
	@RequestMapping(value = "/EditPost", method = RequestMethod.POST)
	public String editPost(@RequestParam int blogId, Model model){
		Blog blog = editBlogService.findBlogById(blogId);
		model.addAttribute("blog", blog);
		return "editblog";
	}
	
}
