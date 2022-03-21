package com.projectmanagement.model.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.projectmanagement.model.dao.Project;
import com.projectmanagement.model.dto.ProjectDto;

public interface ProjectService {
	public List<Project> getAllProject();

	public Project getProjectById(Integer projectId);

	public Project addProject(Project project);

	public Project updateProjectDetails(Integer projectId, ProjectDto projectDto);

	public Project deleteProject(Integer projectId);
	
	//used for search functionality
	@Query("SELECT p from Project p WHERE p.name LIKE %?1%")
	public List<Project> findAll(String keyword);

}
