/**
* Project Name : Project Management System
* @company YMSLI
* @author Pawandeep Singh
* @date 16 March, 2022
* Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.
*
* Description
* ---------------------------------------------------------------------------------------------------------
* UserDao Interface : It extends JpaRepository Interface and defines methods for getting
* data from database table, user_table.
* ---------------------------------------------------------------------------------------------------------
*
 */

package com.projectmanagement.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectmanagement.model.entities.User;


@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	//used to find user by username
	public User findByUsername(String username);
}
