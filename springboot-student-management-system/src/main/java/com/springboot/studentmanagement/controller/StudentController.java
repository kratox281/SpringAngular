package com.springboot.studentmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.studentmanagement.entity.Student;
import com.springboot.studentmanagement.service.StudentService;

@Controller
public class StudentController {
	
	
	private StudentService studentService;
	
	
	
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping("/")
	public String getAllStudents()	{
		return "redirect:/findAll";
	}


	@GetMapping("/findAll")
	public String getAllStudents(Model model)	{
		
		model.addAttribute("lista", this.studentService.getAllSt());
		return "list-students";
	}


	@GetMapping("/students/new")
	public String createStudent(Model model)
	{
		
		Student student = new Student();
		
		model.addAttribute("student", student);		
		
		return "create-student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student)
	{
		
		this.studentService.saveStudent(student);
		
		return "redirect:/findAll";
	}
	
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model)
	{
		
		model.addAttribute("student", this.studentService.getStudentById(id));
		
		return "edit-student";
	}
	
	@PostMapping("/students/update/{id}")
	public String updateStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student, Model model)
	{
		//get Student from database
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setEmail(student.getEmail());
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		
		studentService.updateStudent(existingStudent);
		
		return "redirect:/findAll";
	}

	
	
	@GetMapping("/students/delete/{id}")
	public String updateStudent(@PathVariable("id") Long id)
	{
		
		studentService.deleteStudentByID(id);
		
		return "redirect:/findAll";
	}
	
}
