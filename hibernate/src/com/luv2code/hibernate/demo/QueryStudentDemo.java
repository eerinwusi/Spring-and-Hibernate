package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
//		create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
//		create a session
		Session session = factory.getCurrentSession();
		
		try {		
			
//			start a transaction
			session.beginTransaction();
			
//			query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
//			display the students
			displayStudents(theStudents);
			
//			query students lastname='Doe'
			List<Student> theStudent = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			
//			display the students
			System.out.println("Students with last name 'Doe'");
			displayStudents(theStudent);
			
//			commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

}
