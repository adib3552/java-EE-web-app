package com.demo.Controller;



import java.io.BufferedReader;
import java.io.IOException;

import com.demo.DAO.StudentDaoImp;
import com.demo.Model.Student;
import com.demo.Service.StudentService;
import com.google.gson.Gson;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class StudentLogin extends HttpServlet{
	
	private StudentService studentService;
	private Gson gson;
	
	public StudentLogin() {
		StudentDaoImp studentDao=new StudentDaoImp();
		studentService=new StudentService(studentDao);
		gson=new Gson();
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
		
		BufferedReader reader = req.getReader();
        StringBuilder jsonBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonBody.append(line);
        }

        // Parse JSON using Gson
        Student loginData = gson.fromJson(jsonBody.toString(), Student.class);

        int id = loginData.getId();
        String pass = loginData.getPassword();
        
        System.out.println(studentService.getStudentByID(id));
		
		if(studentService.checkStudent(id, pass)) {
			System.out.println("Sucessful");
		}
		else {
			System.out.println("Unucessful");
		}
		
	}
}
