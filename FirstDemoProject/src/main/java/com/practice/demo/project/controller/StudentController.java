package com.practice.demo.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.practice.demo.project.dao.*;
import com.practice.demo.project.model.Students;

@RestController
public class StudentController {
	
	@Autowired
	StudentsRepo repo;
	
	@GetMapping("/")
	public String home() {
		return "Home.jsp";
	}
	
	
	@GetMapping("/addStudents")
	public String addStudents(Students students) {
		repo.save(students);
		return "Home.jsp";
	}
	
	@PostMapping("/Students")
	public Students addStudent(Students students) {
		repo.save(students);
		return students;
	}
	
	@GetMapping("/fetchStudentsById")
	public ModelAndView fetchDetailsById(@RequestParam int stdId) {
		ModelAndView mv = new ModelAndView("Details.jsp");
		Optional<Students> students = repo.findById(stdId);
		
		System.out.println(repo.findBystdTech("Java"));
		System.out.println(repo.findBystdIdGreaterThan(102));
		System.out.println(repo.findBystdTechSorted("Java"));
		System.out.println(repo.countBystdTech("Java"));
		
		mv.addObject("students", students);
		return mv;
	}
	
	
	@GetMapping("/fetchAllStudents")
	public ModelAndView fetchAllDetails() {
		ModelAndView mv = new ModelAndView("AllDetails.jsp");
		Students students =(Students) repo.findAll();	
		mv.addObject("students", students);
		return mv;
	}
	
	
	
	@GetMapping("/Students")
	public List<Students> fetchStudents() {
		return repo.findAll();
	}
	
	
	@GetMapping("/Student/{stdId}")
	public Optional<Students> fetchStudent(@PathVariable("stdId") int stdId) {
		return repo.findById(stdId);
	}
}
