package com.springboot.studentmanagement.service;

import java.util.List;

import com.springboot.studentmanagement.entity.Student;

public interface StudentService {
	
	List<Student> getAllSt();
	Student saveStudent(Student student);
	Student getStudentById(Long id);
	Student updateStudent(Student student);
	void deleteStudentByID(Long id);

}
