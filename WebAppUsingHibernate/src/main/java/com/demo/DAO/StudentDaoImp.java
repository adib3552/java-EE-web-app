package com.demo.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.Model.Student;

public class StudentDaoImp implements StudentDao{
	
	private SessionFactory sessionFactory;
	private HibernateUtil hibutil=new HibernateUtil();

	@Override
	public Student getById(int id) {
		sessionFactory=hibutil.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		
		Student student=(Student)session.get(Student.class, id);
		
		return student;
	}

	@Override
	public void saveStudent(Student student) {
		sessionFactory=hibutil.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		
		session.save(student);
		
		tr.commit();
		
		session.close();
	}

	@Override
	public boolean checkStudent(int id, String pass) {
		
		Student student=getById(id);
		System.out.println(student);
		
		if(student!=null && student.getPassword().equals(pass)) {
			return true;
		}
		return false;
	}

}
