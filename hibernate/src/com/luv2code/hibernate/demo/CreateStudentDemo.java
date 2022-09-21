package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
//		create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
//		create a session
		Session session = factory.getCurrentSession();
		
		try {
//			create the student object
			Student student = new Student("Paul", "Will", "paul@luv2code.com");
			
//			start a transaction
			session.beginTransaction();
			
//			save the object
			session.save(student);
			
//			commit the transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

	}

}
