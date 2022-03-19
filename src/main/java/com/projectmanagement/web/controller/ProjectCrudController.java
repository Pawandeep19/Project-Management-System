package com.projectmanagement.web.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projectmanagement.model.dao.Project;
import com.projectmanagement.model.dao.User;
import com.projectmanagement.model.dto.ProjectDetailDto;
import com.projectmanagement.model.dto.ProjectDto;
import com.projectmanagement.model.service.ProjectService;

@Controller
public class ProjectCrudController {

	private ProjectService projectService;

	@Autowired
	public ProjectCrudController(ProjectService projectService) {
		this.projectService = projectService;
	}

	@GetMapping(path = "addproject")
	public ModelAndView projectGet(ModelAndView mv) {
		mv.setViewName("project");
		mv.addObject("project", new Project());
		return mv;
	}

	@PostMapping(path = "addproject")
	public String projectPost(@ModelAttribute Project project) {
		projectService.addProject(project);
		return "redirect:home";
	}

	@GetMapping(path = "updateProject/{id}")
	public ModelAndView updateProjectGet(ModelAndView mv, @PathVariable int id) {
		mv.setViewName("updateProject");
		Project project = projectService.getProjectById(id);
		ProjectDto projectDto = new ProjectDto();
		projectDto.setId(id);
		System.out.println(project.getProjectStatus());
		if (project.getProjectStatus().contains("Completed")) {
			mv.setViewName("notAuthorized");
			return mv;
		}
		projectDto.setProjectName(project.getProjectName());
		projectDto.setClientName(project.getClientName());
		projectDto.setStartDate(project.getStartDate());
		projectDto.setEndDate(project.getEndDate());
		projectDto.setProjectStatus(project.getProjectStatus());
		projectDto.setCreatedBy(project.getCreatedBy());
		mv.addObject("projectDto", projectDto);

		// mv.addAttribute("updateaccountDto",accountService.getAccountById(id));
		return mv;
	}

	@PostMapping(path = "updateProject")
	public String updateProjectPost(@ModelAttribute ProjectDto projectDto) {
		projectService.updateProjectDetails(projectDto.getId(), projectDto);
		return "redirect:home";
	}

	@GetMapping(path = "deleteProject/{id}")
	public String deleteProjectGet(@PathVariable int id) {
		projectService.deleteProject(id);
		return "redirect:../home";
	}

	@GetMapping(path = "success")
	public String transferGet() {
		return "success";
	}

	@ModelAttribute("loggedinuser")
	public User globalUserObject(Model model) {
		// Add all null check and authentication check before using. Because this is
		// global
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("loggedinuser", authentication.getName());
		model.addAttribute("roles", authentication.getAuthorities());
		// Create User pojo class
		User user = new User(authentication.getName(), Arrays.asList(authentication.getAuthorities()));
		return user;
	}

}
