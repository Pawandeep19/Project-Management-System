package com.projectmanagement.model.service;

import java.util.List;


import com.projectmanagement.model.dao.Project;
import com.projectmanagement.model.dto.ProjectDto;

public interface ProjectService {
	public List<Project> getAllProject();
	public Project getProjectById(Integer projectId);
	public Project addProject(Project project);
	public Project updateProjectDetails(Integer projectId, ProjectDto projectDto);
	public Project deleteProject(Integer projectId);
	
	
}
