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

	@Autowired
	public MyUserDetailService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("user is not found");
		}
		// how to convert our user to the user that is understandable spring security
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
	}

}
