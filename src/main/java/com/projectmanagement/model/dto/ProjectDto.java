/**
* Project Name : Project Management System
* @company YMSLI
* @author Pawandeep Singh
* @date 16 March, 2022
* Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.
*
* Description
* ---------------------------------------------------------------------------------------------------------
*ProjectDto class : Used for transfer of parameters required for update project functionality
* ---------------------------------------------------------------------------------------------------------
*
 */
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
