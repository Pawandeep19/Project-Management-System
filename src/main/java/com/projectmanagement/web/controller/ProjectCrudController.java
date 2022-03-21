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
import org.springframework.web.servlet.ModelAndView;

import com.projectmanagement.model.dao.Project;
import com.projectmanagement.model.dao.User;
import com.projectmanagement.model.dto.DtoUtil;
import com.projectmanagement.model.dto.ProjectDto;
import com.projectmanagement.model.service.ProjectService;

@Controller
public class ProjectCrudController {

	private ProjectService projectService;

	@Autowired
	public ProjectCrudController(ProjectService projectService) {
		this.projectService = projectService;
	}

	// ****** Create Project ********

	// Add Project form page
	@GetMapping(path = "addproject")
	public ModelAndView projectGet(ModelAndView mv) {
		mv.setViewName("createProject");
		mv.addObject("project", new Project());
		return mv;
	}

	// Add Project post mapping
	@PostMapping(path = "addproject")
	public String projectPost(@ModelAttribute ProjectDto projectdto) {
		projectService.addProject(DtoUtil.convertToProject(projectdto));
		return "redirect:home?success=Project Created Succesfully";
	}

	// ****** Update Project ********

	// update project form page
	@GetMapping(path = "updateProject/{id}")
	public ModelAndView updateProjectGet(ModelAndView mv, @PathVariable int id) {
		mv.setViewName("updateProject");
		Project project = projectService.getProjectById(id);
		ProjectDto projectDto = new ProjectDto();
		projectDto.setId(id);
		projectDto.setProjectName(project.getProjectName());
		projectDto.setClientName(project.getClientName());
		projectDto.setStartDate(project.getStartDate());
		projectDto.setEndDate(project.getEndDate());
		projectDto.setProjectStatus(project.getProjectStatus());
		projectDto.setCreatedBy(project.getCreatedBy());
		projectDto.setResourcesAllocated(project.getResourcesAllocated());
		mv.addObject("projectDto", projectDto);
		return mv;
	}

	// update project post mapping

	@PostMapping(path = "updateProject")
	public String updateProjectPost(@ModelAttribute ProjectDto projectDto) {
		projectService.updateProjectDetails(projectDto.getId(), projectDto);
		return "redirect:home?success=Project Updated Successfully";
	}

	// ****** Delete Project ********

	@GetMapping(path = "deleteProject/{id}")
	public String deleteProjectGet(@PathVariable int id) {

		Project project = projectService.getProjectById(id);
		System.out.println(project.getProjectStatus());
		projectService.deleteProject(id);
		return "redirect:../home";

	}

	// To send logged in user from controller to view

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
