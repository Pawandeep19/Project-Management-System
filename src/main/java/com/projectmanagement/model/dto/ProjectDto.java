package com.projectmanagement.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
	private Integer id;
	private String projectName;
	private String clientName;
	private Date startDate;
	private Date endDate;
	private String projectStatus;
	private String createdBy;
	private String resourcesAllocated;
}
