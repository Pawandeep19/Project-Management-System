package com.projectmanagement.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDao extends JpaRepository<Project, Integer> {

	// used for search functionality
	@Query("SELECT p from Project p WHERE p.projectName LIKE %?1%")
	public List<Project> findAll(String keyword);
}
