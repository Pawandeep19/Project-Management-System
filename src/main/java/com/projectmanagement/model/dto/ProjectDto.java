package com.projectmanagement.model.dto;

import java.util.Date;

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
	private Date startDate=null;
	private Date endDate=null;
	private String status;
	
	
}
