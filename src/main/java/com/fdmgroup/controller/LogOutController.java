package com.fdmgroup.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogOutController {

	@RequestMapping("/Logout")
	public String logOut(HttpSession session){
		session.invalidate();
		return "redirect:/homepage";
	}
}
