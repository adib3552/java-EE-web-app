package com.demo.Service;

import com.demo.DAO.StudentDao;
import com.demo.Model.Student;

public class StudentService {
	private StudentDao studentDao;
	
	public StudentService(StudentDao studentDao) {
		this.studentDao=studentDao;
	}
	
	public void createStudent(Student student) {
		studentDao.saveStudent(student);
	}
	
	public Student getStudentByID(int id) {
		Student student=studentDao.getById(id);
		return student;
	}
	
	public boolean checkStudent(int id, String pass) {
		
		return studentDao.checkStudent(id, pass);
	}
}
