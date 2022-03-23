package com.projectmanagement.model.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "project_table")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectId;
	private String projectName;
	private Date startDate;
	private Date endDate;
	private String projectStatus;
	private String clientName;
	private String createdBy;
	private String resourcesAllocated;

	public Project() {
		super();
	}

	public Project(String projectName, Date startDate, Date endDate, String projectStatus, String clientName,
			String createdBy, String resourcesAllocated) {
		super();
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.projectStatus = projectStatus;
		this.clientName = clientName;
		this.createdBy = createdBy;
		this.resourcesAllocated = resourcesAllocated;
	}

}
