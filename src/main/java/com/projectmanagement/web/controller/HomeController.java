package com.projectmanagement.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.projectmanagement.model.service.ProjectService;
@Controller
public class HomeController {
	private ProjectService projectService;
	@Autowired
	public HomeController(ProjectService projectService) {
	    this.projectService = projectService;
	}
	@GetMapping("home")
	public String home(ModelMap map) {
	map.addAttribute("project", projectService.getAllProject());
	return "home";
	}

}
