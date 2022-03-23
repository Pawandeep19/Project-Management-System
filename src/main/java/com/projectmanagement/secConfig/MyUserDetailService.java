/**
* Project Name : Project Management System
* @company YMSLI
* @author Pawandeep Singh
* @date 17 March 2022
* Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.
*
* Description
* -------------------------------------------------------------------------------------------------
* MyUserDetailsService class : for converting the Custom User to Spring security User for authentication
* --------------------------------------------------------------------------------------------------
*/

package com.projectmanagement.secConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projectmanagement.model.entities.User;
import com.projectmanagement.model.service.UserService;

@Service
public class MyUserDetailService implements UserDetailsService {

	private UserService userService;

	/**Constructor Autowiring Reference of UserService interface to apply user related business logic operations
	*/
	@Autowired
	public MyUserDetailService(UserService userService) {
		this.userService = userService;
	}

	/**
	* @param username
	* @throws UsernameNotFoundException
	* method to load spring secure User from custom User's username
	* @return UserDetails
	*/
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("user is not found");
		}
		// to convert our user to the user that is understandable spring security
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
	}

}
