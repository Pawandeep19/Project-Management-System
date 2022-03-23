package com.projectmanagement.model.service;

import com.projectmanagement.model.entities.User;

public interface UserService {
	public void AddUser(User user);

	public User getUserByUsername(String username);

	public Boolean validatePassword(String Password, User user);

	public void changePassword(User user, String password);
}
