package com.insuranceapp.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.realm.JNDIRealm.User;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insuranceapp.model.AppUser;
import com.insuranceapp.service.AppUserServiceImpl;
import com.insuranceapp.util.JwtTokenUtil;

@RestController
@RequestMapping("/user-api/v1")
public class AppUserController {

	@Autowired
	private AppUserServiceImpl userServiceImpl;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired 
	private PasswordEncoder encoder;
	@Autowired
	JwtTokenUtil tokenUtil;

	// 2nd call for the registered user (similar to login - this returns the jwt
	// token)
	@PostMapping("/authenticate")
	public ResponseEntity<String> generateToken(@RequestBody AppUser appUser) {
		System.out.println(appUser);
		authenticate(appUser.getUserName(), appUser.getPassword());
		System.out.println(appUser);
		UserDetails userDetails = userServiceImpl.loadUserByUsername(appUser.getUserName());
		String token = tokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(token);
	}

	// 1st call for any new user
	@PostMapping("/register")
	public ResponseEntity<Void> addUser(@RequestBody AppUser appUser) {
		UserDetails userDetails = convertToUserDetails(appUser);
		userServiceImpl.createUser(userDetails);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	private void authenticate(String username, String password) {
		try {
			System.out.println(username);
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			System.out.println(authentication.getPrincipal());
		} catch (BadCredentialsException e) {
			System.out.println("Invalid credentials");
		} catch (DisabledException e) {
			System.out.println("disabled");
		}
	}

	private UserDetails convertToUserDetails(AppUser appUser) {
		String username = appUser.getUserName();
		String password = encoder.encode(appUser.getPassword());
		List<GrantedAuthority> authorities = appUser.getRole().stream().map(role -> new SimpleGrantedAuthority(role))
				.collect(Collectors.toList());
		// create a User object
		UserDetails userDetails = new User(username, password, authorities);

		return userDetails;
	}
}