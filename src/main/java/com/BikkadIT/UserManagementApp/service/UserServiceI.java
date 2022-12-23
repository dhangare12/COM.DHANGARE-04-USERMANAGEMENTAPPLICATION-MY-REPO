package com.BikkadIT.UserManagementApp.service;

import java.util.List;

import com.BikkadIT.UserManagementApp.entities.City;
import com.BikkadIT.UserManagementApp.entities.Country;
import com.BikkadIT.UserManagementApp.entities.State;
import com.BikkadIT.UserManagementApp.model.Login;
import com.BikkadIT.UserManagementApp.model.UnlockAccount;
import com.BikkadIT.UserManagementApp.model.User;

public interface UserServiceI {

	
	public List<Country> getAllCountry();
	
	public List<State> getAllState(int countryId);
	
	public List<City> getAllCity(int stateId);
	
	public boolean saveUser(User user);
	
	public String  loginCheck(Login login);
	
	public boolean unlockAccount(UnlockAccount unlockAccount);

    public String forgotPassword(String email);
	
	}
	

