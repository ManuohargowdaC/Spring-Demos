package com.insuranceapp.model;

import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
@Component
public class AppUserMapper {
	
	public AppUser convertToAppUser(UserDetails userDetails) {
		String username = userDetails.getUsername();
		String password = userDetails.getPassword();
		AppUser appUser = new AppUser();
		appUser.setUserName(username);
		appUser.setPassword(password);
		
		return appUser;
		
	}

}
