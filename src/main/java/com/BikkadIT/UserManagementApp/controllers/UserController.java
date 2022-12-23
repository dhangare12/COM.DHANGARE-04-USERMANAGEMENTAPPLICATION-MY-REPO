package com.BikkadIT.UserManagementApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.UserManagementApp.entities.City;
import com.BikkadIT.UserManagementApp.entities.Country;
import com.BikkadIT.UserManagementApp.entities.State;
import com.BikkadIT.UserManagementApp.model.User;
import com.BikkadIT.UserManagementApp.service.UserServiceI;

@RestController
public class UserController {

	@Autowired
	private UserServiceI userServiceI;
	
	@GetMapping(value = "/getAllCountry" , produces = "application/json")
	public ResponseEntity<List<Country>> getAllCountry(){
	
		List<Country> allCountry = userServiceI.getAllCountry();
		return new ResponseEntity<List<Country>>(allCountry,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/getAllState/{countryId}" , produces = "application/json")
	public ResponseEntity<List<State>> getAllState(@PathVariable Integer countryId){
	
		 List<State> allState = userServiceI.getAllState(countryId);
		return new ResponseEntity<List<State>>(allState,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/getAllCity/{stateId}" , produces = "application/json")
	public ResponseEntity<List<City>> getAllCity(@PathVariable Integer stateId){
	
 List<City> allCity = userServiceI.getAllCity(stateId);
		return new ResponseEntity<List<City>>(allCity,HttpStatus.OK);
		
	}
	@PostMapping(value = "/saveUser", consumes = "application/json")
	public ResponseEntity<String> saveUser(@RequestBody User user) {

		boolean saveUser = userServiceI.saveUser(user);

	
		if (saveUser) {
			String msg = "User Saved";
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} else {
			String msg="User Not Saved";
		
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);

		}
	}
	
}
