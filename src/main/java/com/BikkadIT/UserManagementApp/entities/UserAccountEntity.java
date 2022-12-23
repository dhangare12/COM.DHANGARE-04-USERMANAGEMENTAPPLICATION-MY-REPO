package com.BikkadIT.UserManagementApp.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="USERACCOUNT_ENTITY")
public class UserAccountEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
	@Column(name="USER_FIRSTNAME")
	private String fname;
	
	@Column(name="USER_LASTNAME")
	private String lname;
	
	@Column(name="USER_EMAIL")
	private String email;
	
	@Column(name="USER_PHONE")
	private String phone;
	
	@Column(name="USER_DOB")
	private Date dob;
	
	@Column(name="USER_GENDER")
	private String gender;
	
	@Column(name="USER_COUNTRY")
	private String country;
	
	@Column(name="USER_STATE")
	private String state;
	@Column(name="USER_CITY")
	private String city;
	
	@Column(name="USER_PASSWORD")
	private String password;
	
	@Column(name="USER_ACCOUNT_STATUS")
	private String accStatus;
	
	@CreationTimestamp
	@Column(name = "CREATED_DATE",updatable = false)
	private LocalDate createdDate;
	
	@UpdateTimestamp
	@Column(name = "UPDATED_DATE", insertable = false)
	private LocalDate updatedDate;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccStatus() {
		return accStatus;
	}

	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "UserAcountEntity [userId=" + userId + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", phone=" + phone + ", dob=" + dob + ", gender=" + gender + ", country=" + country + ", state="
				+ state + ", city=" + city + ", password=" + password + ", accStatus=" + accStatus + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + "]";
	}
}
