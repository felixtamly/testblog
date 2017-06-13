package com.fdmgroup.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.model.entity.Member;
import com.fdmgroup.service.LogInService;

@Controller
public class LogInController {

	LogInService logInService = new LogInService();

	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public String logIn(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
		if (logInService.checkAccount(username, password)) {
			// find member
			Member member = logInService.logInMember(username);
			// set session
			session.setAttribute("sessionUser", member);
			return "redirect:/homepage";
		} else {
			model.addAttribute("loginErrorMessage", "The username and/or password do(es) not match our record. Please try again.");
			return "login";
		}
	}
}
