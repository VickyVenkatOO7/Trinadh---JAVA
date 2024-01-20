package com.practice.demo.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.practice.demo.project.dao.*;
import com.practice.demo.project.model.Students;

@Controller
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
	
	
	@RequestMapping("/fetchStudentsById")
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
	
	
	@RequestMapping("/fetchAllStudents")
	public ModelAndView fetchAllDetails() {
		ModelAndView mv = new ModelAndView("AllDetails.jsp");
		Students students =(Students) repo.findAll();	
		mv.addObject("students", students);
		return mv;
	}
}
