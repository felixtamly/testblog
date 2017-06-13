package com.fdmgroup.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fdmgroup.model.entity.Blog;
import com.fdmgroup.model.entity.Member;
import com.fdmgroup.service.ViewBlogService;

@Controller
public class ViewBlogController {
	
	ViewBlogService viewBlogService = new ViewBlogService();
	
	@RequestMapping(value = "/listYourPosts", method = RequestMethod.GET)
	public String listYourPosts(HttpSession session, Model model) {
		Member member = (Member) session.getAttribute("sessionUser");
		List<Blog> blogList = viewBlogService.listBlogsByMember(member);
		model.addAttribute("blogList", blogList);
		return "viewblog";
	}

}
