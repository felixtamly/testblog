package com.fdmgroup.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.model.entity.Blog;
import com.fdmgroup.model.entity.Member;
import com.fdmgroup.service.PostCommentService;

@Controller
public class PostCommentController {

	PostCommentService postCommentService = new PostCommentService();
	
	@RequestMapping(value = "/SubmitComment", method = RequestMethod.POST)
	public String submitComment(@RequestParam String content, HttpSession session) {
		
		Member member = (Member) session.getAttribute("sessionUser");
		Blog blog = (Blog) session.getAttribute("sessionBlog");
		
		postCommentService.createComment(member, blog, new Date(), content);
		
		return "redirect:/ShowDetails";
	}
	
}
