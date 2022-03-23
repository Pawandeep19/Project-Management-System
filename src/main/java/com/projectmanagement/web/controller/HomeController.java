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
	@Autowired
	private UserService userService;

	@Autowired
	public HomeController(ProjectService projectService) {
		this.projectService = projectService;
	}

	// Display all Projects

	@GetMapping("/home")
	public String home(ModelMap map) {
		map.addAttribute("project", projectService.getAllProject());
		return "home";
	}

	// Search a project

	@PostMapping("/home")
	public String serach(Model model, @Param("keyword") String keyword) {
		List<Project> listProjects = projectService.findAll(keyword);
		model.addAttribute("project", listProjects);
		return "home";
	}

	// change password form

	@GetMapping(path = "changepwd")
	public ModelAndView changePwdGet(ModelAndView mv, Principal principal) {
		mv.setViewName("changePassword");
		mv.addObject("changePassword", new ChangePasswordDto());
		System.out.println(principal.getName());
		User user = userService.getUserByUsername(principal.getName());
		mv.addObject("user", user);
		return mv;
	}

	// change password post mapping and validation

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
