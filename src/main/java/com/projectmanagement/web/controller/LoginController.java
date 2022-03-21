package com.projectmanagement.web.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	// Login

	@GetMapping(path = "login")
	public String appLogin() {
		return "login";
	}

	@GetMapping(path = "accessdenied")
	public ModelAndView accessdenied(Principal principal, ModelAndView mv) {
		mv.addObject("username", principal.getName());
		mv.setViewName("403");
		return mv;
	}

	// Logout

	@GetMapping("/logout")
	public String logout() {
		return "login";
	}

}
