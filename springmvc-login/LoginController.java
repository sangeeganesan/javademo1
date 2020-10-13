package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.User;

@Controller
public class LoginController {
	@PostMapping(value="/log")
	public String loginFunction(@ModelAttribute User user,Model model) {
		System.out.println(user.getUserName());
		model.addAttribute("key2", user);
		return "usersuccess";
	}

}
