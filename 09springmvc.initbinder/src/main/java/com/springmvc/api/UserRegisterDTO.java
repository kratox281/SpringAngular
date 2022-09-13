package com.springmvc.api;


import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

import com.springmvc.validator.Age;

@Component
public class UserRegisterDTO {

	@NotEmpty(message="No puede estar vacío")
	private String name;
	private String userName;
	private char[] password;	
	private String country;
	private String[] hobbies;
	private String gender;
	private UserContactDTO userContact;	
	
	@Age(lower=18, upper=75)
	private Integer age;
		
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}
	
	
	public UserContactDTO getUserContact() {
		return userContact;
	}


	public void setUserContact(UserContactDTO userContact) {
		this.userContact = userContact;
	}

	
	
}
