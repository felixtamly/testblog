package com.fdmgroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {
	
	@RequestMapping("/signup")
	public String goToSignUpPage(){
		return "signup";
	}
	
	@RequestMapping("/login")
	public String goToLogInPage(){
		return "login";
	}
	
	@RequestMapping("/writeblog")
	public String goToWriteBlogPage(){
		return "writeblog";
	}
	
	@RequestMapping("/viewblog")
	public String goToViewBlogPage(){
		return "viewblog";
	}
	
	@RequestMapping("/blogdetails")
	public String goToViewBlogDetailsPage(){
		return "blogdetails";
	}
	
	@RequestMapping("/editblog")
	public String goToEditBlogPage(){
		return "editblog";
	}
	
	@RequestMapping("/memberdetails")
	public String goToMemberDetailsPage() {
		return "memberdetails";
	}
	
	@RequestMapping("/searchPage")
	public String goToSearchPage() {
		return "searchpage";
	}
	
}
