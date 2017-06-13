package com.fdmgroup.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.model.entity.Member;
import com.fdmgroup.service.SignUpService;

@Controller
public class SignUpController {

	SignUpService signUpService = new SignUpService();

	@RequestMapping(value = "/Signup", method = RequestMethod.POST)
	public String signUp(@RequestParam String username, @RequestParam String email, @RequestParam String password,
			@RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date dateOfBirth, HttpSession session) {

		if (signUpService.checkAccount(username, email)) {
			Member member = signUpService.createAccount(username, email, password, dateOfBirth);
			session.setAttribute("sessionUser", member);
			return "redirect:/homepage";
		} else
			return "signup";

	}
}
