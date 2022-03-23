package com.projectmanagement.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectmanagement.model.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	public User findByUsername(String username);
}
