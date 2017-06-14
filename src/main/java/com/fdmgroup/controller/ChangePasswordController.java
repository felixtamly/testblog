package com.fdmgroup.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fdmgroup.model.entity.Member;
import com.fdmgroup.service.ChangePasswordService;

@Controller
public class ChangePasswordController {

	ChangePasswordService changePasswordService = new ChangePasswordService();

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public String changePassword(@RequestParam String originalPassword, @RequestParam String newPassword,
			@RequestParam String reenteredPassword, HttpSession session, RedirectAttributes redirectAttrs) {
		Member member = (Member) session.getAttribute("sessionUser");

		if (changePasswordService.checkOriginalPassword(member, originalPassword)) {
			if (newPassword.equals(reenteredPassword)) {
				if (newPassword.equals(originalPassword)) {
					redirectAttrs.addFlashAttribute("changePasswordError",
							"Your new password is the same as your original password.");
				} else {
					changePasswordService.changePassword(member, newPassword);
					redirectAttrs.addFlashAttribute("changePasswordSuccess",
							"Your password has been successfully updated.");
				}
			} else {
				redirectAttrs.addFlashAttribute("changePasswordError",
						"Your re-entered password does not match your new password.");
			}
		} else {
			redirectAttrs.addFlashAttribute("changePasswordError", "Your original password does not match our record.");
		}

		return "redirect:/listYourDetails"; 
	}
}
