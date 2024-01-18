package com.practice.demo.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class StudentController {
	
	@RequestMapping("/")
	public String home() {
		return "Home.jsp";
	}
}
