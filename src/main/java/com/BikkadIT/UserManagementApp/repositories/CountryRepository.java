package com.BikkadIT.UserManagementApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BikkadIT.UserManagementApp.entities.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
