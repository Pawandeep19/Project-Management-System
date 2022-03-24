/**
* Project Name : Project Management System
* @company YMSLI
* @author Pawandeep Singh
* @date 17 March 2022
* Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.
*
* Description
* -------------------------------------------------------------------------------------------------
* LoginController class : for mapping request for login and logout functionality

* --------------------------------------------------------------------------------------------------
*/
package com.projectmanagement.web.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	/**
	* Get mapping of Login page that returns login page of the web application
	* @return String
	*/

	@GetMapping(path = "login")
	public String appLogin() {
		return "login";
	}
	
	/**
	* @param ModelAndView
	* @param principal
	* get mapping for forbidden user 
	* @return String
	*/
	@GetMapping(path = "accessdenied")
	public ModelAndView accessdenied(Principal principal, ModelAndView mv) {
		mv.addObject("username", principal.getName());
		mv.setViewName("403");
		return mv;
	}
	
	/**
	* Get mapping for logout 
	* @return String
	*/


	@GetMapping("/logout")
	public String logout() {
		return "login";
	}

}
