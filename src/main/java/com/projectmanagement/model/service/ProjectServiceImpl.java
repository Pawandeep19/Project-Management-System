package com.projectmanagement.model.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectmanagement.model.dao.Project;
import com.projectmanagement.model.dao.ProjectDao;
import com.projectmanagement.model.dto.ProjectDetailDto;
import com.projectmanagement.model.dto.ProjectDto;
import com.projectmanagement.model.exception.ProjectNotFoundException;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

	private ProjectDao projectDao;

	@Autowired
	public ProjectServiceImpl(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	@Override
	public List<Project> getAllProject() {
		return projectDao.findAll();
	}

	@Override
	public Project getProjectById(Integer projectId) {

		return projectDao.findById(projectId)
				.orElseThrow(() -> new ProjectNotFoundException("No Project with this ID"));
	}

	@Override
	public Project addProject(Project project) {
		projectDao.save(project);
		return project;
	}

	@Override
	public Project deleteProject(Integer projectId) {
		Project projectToDelete = getProjectById(projectId);
		projectDao.delete(projectToDelete);
		return projectToDelete;
	}

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

	
	public List<Project> findAll(String keyword) {
		if(keyword!=null) {
			return projectDao.findAll(keyword);
		}
		return projectDao.findAll();
	}

}
