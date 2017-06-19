package com.fdmgroup.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.model.entity.Blog;
import com.fdmgroup.service.SearchByTitleService;

@Controller
public class SearchByTitleController {

	SearchByTitleService searchByTitleService = new SearchByTitleService();
	
	@RequestMapping(value = "/searchByTitle", method=RequestMethod.POST)
	public String searchByTitle(@RequestParam String title, Model model) {
		List<Blog> resultList = searchByTitleService.searchByTitle(title);
		model.addAttribute("resultList", resultList);
		return "searchpage";
	}
	
}
