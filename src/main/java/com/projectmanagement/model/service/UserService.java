/**
* Project Name : Project Management System
* @company YMSLI
* @author Pawandeep Singh
* @date 17 March 2022
* Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.
*
* Description
* -------------------------------------------------------------------------------------------------
* UserService Interface : Defines methods for performing User related operations for
* implementation of Business Logic.
* --------------------------------------------------------------------------------------------------
*/

package com.projectmanagement.model.service;

import com.projectmanagement.model.entities.User;

public interface UserService {
	public void AddUser(User user);

	public User getUserByUsername(String username);

	public Boolean validatePassword(String Password, User user);

	public void changePassword(User user, String password);
}
