package com.projectmanagement.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDetailDto {
	private Integer projectId;
	private String projectName;
	private String clientName;
	private Date startDate;
	private Date endDate;
	private String projectStatus;
}
