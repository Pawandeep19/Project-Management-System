package com.projectmanagement.model.dto;

import com.projectmanagement.model.entities.Project;
import com.projectmanagement.model.entities.User;

public class DtoUtil {
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

	public static User convertToUser(UserDto userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		return user;
	}
}
