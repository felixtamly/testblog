package com.fdmgroup.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.model.entity.Member;
import com.fdmgroup.service.ViewMemberDetailsService;

@Controller
public class ViewMemberDetailsController {

	ViewMemberDetailsService viewMemberDetailsService = new ViewMemberDetailsService();

	@RequestMapping(value = "/listYourDetails", method = RequestMethod.GET)
	public String viewMemberDetails(@RequestParam(required = false) String username, HttpSession session, Model model) {
		Member member = null;
		if (username == null)
			member = (Member) session.getAttribute("sessionUser");
		else 
			member = viewMemberDetailsService.findMemberByUsername(username);
		Long numberOfPosts = viewMemberDetailsService.findNumberOfPostsByMember(member);
		
		model.addAttribute("viewingMember", member);
		model.addAttribute("numberOfPosts", numberOfPosts);

		return "memberdetails";
	}
}
