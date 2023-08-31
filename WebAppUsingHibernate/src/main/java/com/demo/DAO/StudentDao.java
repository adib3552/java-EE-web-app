package com.demo.DAO;

import com.demo.Model.Student;

public interface StudentDao {
	Student getById(int id); 
	void saveStudent(Student student);
	boolean checkStudent(int id,String pass);
}
