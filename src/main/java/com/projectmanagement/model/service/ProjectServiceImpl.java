package com.projectmanagement.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectmanagement.model.dao.ProjectDao;
import com.projectmanagement.model.dto.ProjectDto;
import com.projectmanagement.model.entities.Project;
import com.projectmanagement.model.exception.ProjectNotFoundException;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

	private ProjectDao projectDao;

	@Autowired
	public ProjectServiceImpl(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	// To get List of all projects

	@Override
	public List<Project> getAllProject() {
		return projectDao.findAll();
	}

	// To get a particular project by Id
	
	@Override
	public Project getProjectById(Integer projectId) {

		return projectDao.findById(projectId)
				.orElseThrow(() -> new ProjectNotFoundException("No Project with this ID"));
	}

	// Add Project

	@Override
	public Project addProject(Project project) {
		projectDao.save(project);
		return project;
	}

	// Delete Project

	@Override
	public Project deleteProject(Integer projectId) {
		Project projectToDelete = getProjectById(projectId);
		projectDao.delete(projectToDelete);
		return projectToDelete;
	}

	// Update Project
	
	@Override
	public Project updateProjectDetails(Integer projectId, ProjectDto projectDto) {
		Project project = getProjectById(projectId);
		project.setProjectName(projectDto.getProjectName());
		project.setClientName(projectDto.getClientName());
		project.setStartDate(projectDto.getStartDate());
		project.setEndDate(projectDto.getEndDate());
		project.setProjectStatus(projectDto.getProjectStatus());
		project.setCreatedBy(projectDto.getCreatedBy());
		project.setResourcesAllocated(projectDto.getResourcesAllocated());
		projectDao.save(project);
		return project;

	}

	// Search Project

	public List<Project> findAll(String keyword) {
		if (keyword != null) {
			return projectDao.findAll(keyword);
		}
		return projectDao.findAll();
	}

}
