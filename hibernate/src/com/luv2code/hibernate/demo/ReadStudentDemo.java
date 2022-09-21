package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student student = new Student("hello", "hey", "hey@luv2code.com");
			
//			start a transaction
			session.beginTransaction();
			
//			save the object
			session.save(student);
			
//			commit the transaction
			session.getTransaction().commit();
			
//			RETRIEVING STUDENT
			
//			get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
//			retrieve student by id
			System.out.println(student.getId());
			
			Student myStudent = session.get(Student.class, student.getId());
			
			System.out.println("Student retrieved " + myStudent);
			
//			commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		} finally {
			factory.close();
		}

	}

}
