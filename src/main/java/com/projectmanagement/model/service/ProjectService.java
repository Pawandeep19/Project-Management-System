/**
* Project Name : Project Management System
* @company YMSLI
* @author Pawandeep Singh
* @date 17 March 2022
* Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.
*
* Description
* -------------------------------------------------------------------------------------------------
* ProjectService Interface : Defines methods for performing Project related operations for
* implementation of Business Logic.
* --------------------------------------------------------------------------------------------------
*/

package com.projectmanagement.model.service;

import java.util.List;


import com.projectmanagement.model.dto.ProjectDto;
import com.projectmanagement.model.entities.Project;

public interface ProjectService {
	public List<Project> getAllProject();

	public Project getProjectById(Integer projectId);

	public Project addProject(Project project);

	public Project updateProjectDetails(Integer projectId, ProjectDto projectDto);

	public Project deleteProject(Integer projectId);	
	
	public List<Project> findAll(String keyword);

}
