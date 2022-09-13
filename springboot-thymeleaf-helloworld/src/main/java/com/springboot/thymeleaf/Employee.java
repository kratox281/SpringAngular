package com.springboot.thymeleaf;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

	private long id;

	private String firstName;

	private String lastName;

	private String email;

}
