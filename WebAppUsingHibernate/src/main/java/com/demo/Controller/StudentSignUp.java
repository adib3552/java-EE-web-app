package com.demo.Controller;

import java.io.IOException;

import com.demo.DAO.StudentDaoImp;
import com.demo.Model.Student;
import com.demo.Service.StudentService;
import com.google.gson.Gson;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sign-in")
public class StudentSignUp extends HttpServlet{
	
	private StudentService studentService;
	
	public StudentSignUp() {
        StudentDaoImp studentDao = new StudentDaoImp(); // Instantiate the DAO
        this.studentService = new StudentService(studentDao); // Instantiate the service with the DAO
    }
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		Student newStudent=new Gson().fromJson(req.getReader(),Student.class);
		
		studentService.createStudent(newStudent);
		
		
	}
}
