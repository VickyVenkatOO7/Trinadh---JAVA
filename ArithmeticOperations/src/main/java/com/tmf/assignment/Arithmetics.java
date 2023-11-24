package com.tmf.assignment;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Arithmetics extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int i = Integer.parseInt(req.getParameter("num1"));
		String operator = req.getParameter("operators");
		int j = Integer.parseInt(req.getParameter("num2"));
		
		PrintWriter out = res.getWriter();
		if("add".equals(operator)) {
			out.println("The Sum is " + (i+j));
		}
		else if ("subtract".equals(operator)) {
			out.println("The Difference is " + (i-j));
		}
		else if ("multiply".equals(operator)) {
			out.println("The Product is " + (i*j));
		}
		else if ("division".equals(operator)) {
			if (j > 0) {
				out.println("The Division is " + (i/j));
			}
			else {
				out.println("Division by ZERO is not valid.");
			}
		}
		else {
			out.println("Invalid Operator");
		}
	}
}
