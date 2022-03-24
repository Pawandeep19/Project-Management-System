/**
* Project Name : Project Management System
* @company YMSLI
* @author Pawandeep Singh
* @date March 17, 2022
* Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.
*
* Description
* -----------------------------------------------------------------------------------
* Services for Project Operations
*
* This module has the following functions:-
* 1. getAllProject - to get all projects
* 2. getProjectById - to get a particular project by Id (using projectId)
* 3. addProject- to create a new project
* 4. deleteProject- to delete a particular project using project_Id
* 5. updateProjectDetails - to update a particular project using project_id
* 6. findAll-to get a list of projects matching with the keyword entered by the user
*/

package com.projectmanagement.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectmanagement.model.dao.ProjectDao;
import com.projectmanagement.model.dto.ProjectDto;
import com.projectmanagement.model.entities.Project;
import com.projectmanagement.model.entities.User;
import com.projectmanagement.model.exception.ProjectNotFoundException;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

	private ProjectDao projectDao;

	/**Constructor Autowiring Reference of ProjectDao interface to interact with database table*/
	@Autowired
	public ProjectServiceImpl(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	/**
	* method to get list of all projects
	* @return List<Project>
	*/

	@Override
	public List<Project> getAllProject() {
		return projectDao.findAll();
	}

	
	/**
	* @param Integer(projectId)
	* method to get a particular project by Id
	* @return Project
	*/
	
	@Override
	public Project getProjectById(Integer projectId) {

		return projectDao.findById(projectId)
				.orElseThrow(() -> new ProjectNotFoundException("No Project with this ID"));
	}

	/**
	* @param Project
	* method to save a new project into the database
	* @return Project
	*/

	@Override
	public Project addProject(Project project) {
		projectDao.save(project);
		return project;
	}

	// Delete Project
	/**
	* @param projectId
	* method to delete a project from database
	* @return Project
	*/

	@Override
	public Project deleteProject(Integer projectId) {
		Project projectToDelete = getProjectById(projectId);
		projectDao.delete(projectToDelete);
		return projectToDelete;
	}

	// Update Project
	/**
	* @param projectId
	* @param ProjectDto
	* method to update a new project into the database
	* @return Project
	*/

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
	/**
	* @param String keyword
	* method to search projects in the database.
	* @return List<Project>
	*/


	public List<Project> findAll(String keyword) {
		if (keyword != null) {
			return projectDao.findAll(keyword);
		}
		return projectDao.findAll();
	}

	/**
	* @param status
	* @param currentUser
	* method to get count of project of a particular status of a particular user
	* @return count(Long)
	*/
	@Override
	public Long countByProjectStatusAndCreatedBy(String status, String currentUser) {
		return projectDao.countByProjectStatusAndCreatedBy(status, currentUser);
	}
	
	

}
