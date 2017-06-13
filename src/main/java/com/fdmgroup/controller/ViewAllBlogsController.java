package com.fdmgroup.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fdmgroup.model.entity.Blog;
import com.fdmgroup.service.ViewAllBlogsService;

@Controller
public class ViewAllBlogsController {

	ViewAllBlogsService viewAllBlogsService = new ViewAllBlogsService();
	
	@RequestMapping(value = {"/", "/homepage"}, method = RequestMethod.GET)
	public String returnToHomepage(Model model){
		List<Blog> blogList = viewAllBlogsService.listAllBlogs();
		model.addAttribute("blogList", blogList);
		return "homepage";
	}
	
}
