/**
* Project Name : Project Management System
* @company YMSLI
* @author Pawandeep Singh
* @date 17 March 2022
* Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.
*
* Description
* -------------------------------------------------------------------------------------------------
* HomeController class : for mapping request for home page and change password page

* --------------------------------------------------------------------------------------------------
*/
package com.projectmanagement.web.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import com.projectmanagement.model.dto.ChangePasswordDto;
import com.projectmanagement.model.entities.Project;
import com.projectmanagement.model.entities.User;
import com.projectmanagement.model.service.ProjectService;
import com.projectmanagement.model.service.UserService;


//functionalities


@Controller
public class HomeController {

	private ProjectService projectService;
	
	/**Autowiring Reference of UserService to perform operations for various mappings */
	@Autowired
	private UserService userService;
    
	/**Autowiring Reference of projectService to perform various project related operations for various mappings */
	@Autowired
	public HomeController(ProjectService projectService) {
		this.projectService = projectService;
	}

	// Get Mapping of home that returns the list of all projects to home page of the web application

	@GetMapping("/home")
	public String home(ModelMap map ,Principal principal) {
		map.addAttribute("project", projectService.getAllProject());
		map.addAttribute("inp", projectService.countByProjectStatusAndCreatedBy("In Progress",principal.getName()));
		map.addAttribute("comp", projectService.countByProjectStatusAndCreatedBy("Completed",principal.getName()));
		map.addAttribute("ns", projectService.countByProjectStatusAndCreatedBy("Not Started",principal.getName()));

		return "home";
	}

	// Post mapping of home to return the list of projects matching the keyword entered by user in search bar

	@PostMapping("/home")
	public String serach(ModelMap map, @Param("keyword") String keyword, Principal principal) {
		List<Project> listProjects = projectService.findAll(keyword);
		map.addAttribute("project", listProjects);
		map.addAttribute("inp", projectService.countByProjectStatusAndCreatedBy("In Progress",principal.getName()));
		map.addAttribute("comp", projectService.countByProjectStatusAndCreatedBy("Completed",principal.getName()));
		map.addAttribute("ns", projectService.countByProjectStatusAndCreatedBy("Not Started",principal.getName()));
		return "home";
	}

	// Get Mapping of change password page that returns a form to change password 

	@GetMapping(path = "changepwd")
	public ModelAndView changePwdGet(ModelAndView mv, Principal principal) {
		mv.setViewName("changePassword");
		mv.addObject("changePassword", new ChangePasswordDto());
		return mv;
	}

	// Post Mapping of change password page that validates the current password and changes the password on successful validation

	@PostMapping(path = "changepwd")
	public String changePwdPost(@ModelAttribute ChangePasswordDto changePasswordDto, Principal principal) {
		User user = userService.getUserByUsername(principal.getName());
		if (!changePasswordDto.getConfirmPassword().matches(changePasswordDto.getNewPassword())) {
			return "redirect:changepwd?error=Password Don't Match";
		} else if (!userService.validatePassword(changePasswordDto.getCurrPassword(), user)) {
			return "redirect:changepwd?error=Incorrect Current Password";
		} else {
			userService.changePassword(user, changePasswordDto.getNewPassword());
			return "redirect:logout?success=Password Changed Successfully!";
		}
	}

	// To send logged in user from controller to view

	@ModelAttribute("loggedinuser")
	public User globalUserObject(Model model) {
		// Add all null check and authentication check before using. Because this is
		// global
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("loggedinuser", authentication.getName());
		model.addAttribute("roles", authentication.getAuthorities());
		// used to create new user object
		User user = new User(authentication.getName(), Arrays.asList(authentication.getAuthorities()));
		return user;
	}

}
