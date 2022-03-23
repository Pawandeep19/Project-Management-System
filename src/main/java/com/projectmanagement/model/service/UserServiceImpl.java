/**
* Project Name : Project Management System
* @company YMSLI
* @author Pawandeep Singh
* @date March 17, 2022
* Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.
*
* Description
* -----------------------------------------------------------------------------------
* Services for User Operations
*
* This module has the following functions:-
* 1. AddUser- to create a new User
* 2. changePassword- to change the old password to a new password
* 3. validatePassword - validates the current password of the current logged in user
* 4. getUserByUsername-to get a particular user using username
*/
package com.projectmanagement.model.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import com.projectmanagement.model.dao.UserDao;
import com.projectmanagement.model.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	private UserDao userDao;
	
	/**Constructor Autowiring Reference of UserDao interface to interact with database table*/
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	
	/**
	* @param User
	* method to create a new User and save it in database
	*/
	
	@Override
	public void AddUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userDao.save(user);
	}

	/**
	* @param User
	* @param String (password)
	* method to set new password
	*/
	
	@Override
	public void changePassword(User user, String password) {
		user.setPassword(bCryptPasswordEncoder.encode(password));
		userDao.save(user);
	}

	/**
	* @param User
	* @param String (password)
	* method validates the current password of the user
	* @return Boolean
	*/
	
	@Override
	public Boolean validatePassword(String Password, User user) {
		return bCryptPasswordEncoder.matches(Password, user.getPassword());
	}

	/**
	* @param String (username)
	* method to get a particular user by username
	* @return User
	*/
	
	@Override
	public User getUserByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
