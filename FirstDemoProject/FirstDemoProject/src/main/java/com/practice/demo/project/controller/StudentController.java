package com.practice.demo.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.demo.project.dao.StudentsRepo;
import com.practice.demo.project.model.Students;


public class StudentController {
	
	@Autowired
	StudentsRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "Home.jsp";
	}
	
	
	@RequestMapping("/addStudents")
	public String addStudents(Students students) {
		repo.save(students);
		return "Home.jsp";
	}
}
