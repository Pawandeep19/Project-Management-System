/**
* Project Name : Project Management System
* @company YMSLI
* @author Pawandeep Singh
* @date 16 March, 2022
* Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.
*
* Description
* ---------------------------------------------------------------------------------------------------------
* DtoUtil class : for conversion of DTO class objects to DAO class objects
* ---------------------------------------------------------------------------------------------------------
*
 */
package com.projectmanagement.model.dto;

import com.projectmanagement.model.entities.Project;

public class DtoUtil {
	
	/**
	* @param ProjectDto
	* method to convert ProjectDto Class Object into Project Class Object
	* @return Project
	*/
	
	public static Project convertToProject(ProjectDto projectDto) {
		Project project = new Project();
		project.setProjectName(projectDto.getProjectName());
		project.setClientName(projectDto.getClientName());
		project.setStartDate(projectDto.getStartDate());
		project.setEndDate(projectDto.getEndDate());
		project.setProjectStatus(projectDto.getProjectStatus());
		project.setCreatedBy(projectDto.getCreatedBy());
		project.setResourcesAllocated(projectDto.getResourcesAllocated());
		return project;
	}

	
}
