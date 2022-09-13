package com.springboot.studentmanagement.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.studentmanagement.entity.Student;
import com.springboot.studentmanagement.repository.StudentRepository;
import com.springboot.studentmanagement.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	//No hace falta el autowired si tenemos un constructor en la clase
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAllSt() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return this.studentRepository.save(student);
		
	}

	@Override
	public Student getStudentById(Long id) {
		
		return this.studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {		
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentByID(Long id) {	
		   studentRepository.deleteById(id);
	}


	
}
