package com.BikkadIT.UserManagementApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.UserManagementApp.model.Login;
import com.BikkadIT.UserManagementApp.service.UserServiceI;

@RestController
public class LoginController {
	@Autowired
	private UserServiceI userServiceI;
	
	@PostMapping("/loginCheck")
	public ResponseEntity<String> loginCheck(@RequestBody Login login){
	String loginCheck = userServiceI.loginCheck(login);
		
		return new ResponseEntity<String>(loginCheck,HttpStatus.OK);
		
	}

	
	
	
	
	
}
