package com.BikkadIT.UserManagementApp.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.UserManagementApp.entities.City;
import com.BikkadIT.UserManagementApp.entities.Country;
import com.BikkadIT.UserManagementApp.entities.State;
import com.BikkadIT.UserManagementApp.entities.UserAccountEntity;
import com.BikkadIT.UserManagementApp.model.Login;
import com.BikkadIT.UserManagementApp.model.UnlockAccount;
import com.BikkadIT.UserManagementApp.model.User;
import com.BikkadIT.UserManagementApp.repositories.CityRepository;
import com.BikkadIT.UserManagementApp.repositories.CountryRepository;
import com.BikkadIT.UserManagementApp.repositories.StateRepository;
import com.BikkadIT.UserManagementApp.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserServiceI{

	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<Country> getAllCountry() {
		List<Country> findAll = countryRepository.findAll();
		
		return findAll;
	}

	@Override
	public List<State> getAllState(int countryId) {
		 List<State> findByCountryId = stateRepository.findByCountryId(countryId);
		return findByCountryId;
	}

	@Override
	public List<City> getAllCity(int stateId) {
		List<City> findByStateId = cityRepository.findByStateId(stateId);
		return findByStateId;
	}


	@Override
	public boolean saveUser(User user) {

		user.setAccStatus("LOCKED");
		user.setPassword(generateRandomPassword());

		UserAccountEntity userAccountEntity = new UserAccountEntity();

		BeanUtils.copyProperties(user, userAccountEntity);

		UserAccountEntity entity = userRepository.save(userAccountEntity);

		if (entity != null) {
			return true;
		} else {

			return false;
		}
	}

	private String generateRandomPassword() {
		return null;

	}



	@Override
	public String loginCheck(Login login) {
		String email = login.getEmail();
		String password = login.getPassword();

		UserAccountEntity userAccountEntity = userRepository.findByEmailAndPassword(email, password);

		if (userAccountEntity != null) {

			if (userAccountEntity.getAccStatus().equals("LOCKED")) {

				return "Your Account is locked";
			} else {
				return "Login Success";
			}
		} else {

			return "Invalid  creditionals";
		}
	}

	@Override
	public boolean unlockAccount(UnlockAccount unlockAccount) {

		String tempPwd = unlockAccount.getTempPassword();
		String email = unlockAccount.getEmail();
		
		UserAccountEntity user = userRepository.findByEmailAndPassword(email, tempPwd);
		
		if(user !=null)
		{
			user.setAccStatus("UNLOCKED");
			user.setPassword(unlockAccount.getNewPassword());
		    userRepository.save(user);
		    return true;
		}
		else
		{
			return false;
		}
	}


	@Override
	public String forgotPassword(String email) {
		
		UserAccountEntity findByEmail = userRepository.findByEmail(email);
		
		if(findByEmail !=null)
		{
			return "Mail is sent to your registered mail id";
		}
		else
		{
		   return "Mail is not Registered Please Register First";
		}
	}
		
	
	


}
