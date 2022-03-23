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

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	// Add user
	@Override
	public void AddUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userDao.save(user);
	}

	// Change Password input and return kya kar raha hai
	@Override
	public void changePassword(User user, String password) {
		user.setPassword(bCryptPasswordEncoder.encode(password));
		userDao.save(user);
	}

	// validate password
	@Override
	public Boolean validatePassword(String Password, User user) {
		return bCryptPasswordEncoder.matches(Password, user.getPassword());
	}

	// to get a user by username
	@Override
	public User getUserByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
