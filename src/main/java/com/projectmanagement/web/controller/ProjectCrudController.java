package com.projectmanagement.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projectmanagement.model.dao.Project;
import com.projectmanagement.model.dto.ProjectDto;
import com.projectmanagement.model.service.ProjectService;

@Controller
public class ProjectCrudController {
	
	private ProjectService projectService;
	
	@Autowired
	public ProjectCrudController(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@GetMapping(path="addproject")
	public ModelAndView projectGet(ModelAndView mv) {
		mv.setViewName("project");
		mv.addObject("project", new Project());
		return mv;
	}
	
	@PostMapping(path="addproject")
	public String transferPost(@ModelAttribute Project project) {
	projectService.addProject(project);
	return "redirect:success";
}
	
	@GetMapping(path="updateProject/{id}")
	public ModelAndView updateProjectGet(ModelAndView mv,
	// @RequestParam(name = "id") int id
	@PathVariable int id
	) {
	mv.setViewName("updateProject");
	Project project=projectService.getProjectById(id);
	ProjectDto projectDto=new ProjectDto();
	projectDto.setId(id);
	projectDto.setProjectName(project.getProjectName());
	projectDto.setClientName(project.getClientName());
	projectDto.setStartDate(project.getStartDate());
	projectDto.setEndDate(project.getEndDate());
	projectDto.setStatus(project.getStatus());
	mv.addObject("projectDto", projectDto);

	// mv.addAttribute("updateaccountDto",accountService.getAccountById(id));
	return mv;
	}

	@PostMapping(path="updateProject")
	public String updateProjectPost(@ModelAttribute ProjectDto projectDto){
		System.out.println("MEI IDHER TO AA HII GYA HU  ****************************************");
	projectService.updateProjectDetails(projectDto.getId(),projectDto);
	return "redirect:success";
	}
		
	
	
	@GetMapping(path="success")
	public String transferGet() {
		return "success";
	}
	
	
	
}
