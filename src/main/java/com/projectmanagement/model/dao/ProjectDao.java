/**
* Project Name : Project Management System
* @company YMSLI
* @author Pawandeep Singh
* @date 16 March, 2022
* Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.
*
* Description
* ---------------------------------------------------------------------------------------------------------
* ProjectDao Interface : It extends JpaRepository Interface and defines methods for getting
* data from database table, project_table.
* ---------------------------------------------------------------------------------------------------------
*
 */

package com.projectmanagement.model.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projectmanagement.model.entities.Project;
import com.projectmanagement.model.entities.User;


@Repository
public interface ProjectDao extends JpaRepository<Project, Integer> {

	// used for search functionality
	@Query("SELECT p FROM Project p WHERE UPPER(p.projectName) LIKE UPPER(concat('%', ?1,'%'))")
	public List<Project> findAll(String keyword);

	public Long countByProjectStatusAndCreatedBy(String status, String currentUser);
}
