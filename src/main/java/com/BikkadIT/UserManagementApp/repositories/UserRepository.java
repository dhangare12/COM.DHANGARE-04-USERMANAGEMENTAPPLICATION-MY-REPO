package com.BikkadIT.UserManagementApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BikkadIT.UserManagementApp.entities.UserAccountEntity;

@Repository
public interface UserRepository extends JpaRepository<UserAccountEntity, Integer> {


	public UserAccountEntity  findByEmailAndPassword(String email ,String padssword);
	
	public UserAccountEntity findByEmail(String email);

}
