package com.fdmgroup.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.model.entity.Member;
import com.fdmgroup.service.PostBlogService;

@Controller
public class PostBlogController {

	PostBlogService postBlogService = new PostBlogService();

	@RequestMapping(value = "/SubmitPost", method = RequestMethod.POST)
	public String submitPost(@RequestParam String title, @RequestParam String content, HttpSession session) {

		Member member = (Member) session.getAttribute("sessionUser");

		if (!postBlogService.checkByteCountExceeds(content)) {
			postBlogService.createBlog(member, new Date(), title, content);
			return "redirect:/homepage";
		} else
			return "writeblog";

	}
}
