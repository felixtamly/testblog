package com.fdmgroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.service.DeleteCommentService;

@Controller
public class DeleteCommentController {

	DeleteCommentService deleteCommentService = new DeleteCommentService();
	
	@RequestMapping(value = "/DeleteComment", method = RequestMethod.POST)
	public String deleteComment(@RequestParam int commentId) {
		deleteCommentService.deleteComment(commentId);
		return "redirect:/ShowDetails";
	}
}
