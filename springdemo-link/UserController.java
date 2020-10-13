package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	
	@RequestMapping(value="/login")
	public String loginFunction(@RequestParam("userName") String userName,@RequestParam("password") String password,Model m)
	{
		String msg="Hello "+ userName;  
        m.addAttribute("message", msg);  
		return "viewpage";
	}

}
