package com.springboot.thymeleaf;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	
	private String userName;
	private String email;
	private String role;
	
	

}
