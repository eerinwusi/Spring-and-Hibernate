package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
//		create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		

		
		try {
			
			int studentId = 1;
			
//			get a new session and start transaction
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
//			retrieve student by id
			System.out.println("Getting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating student");
			myStudent.setFirstName("Scooby");
			
//			update email for all students
			System.out.println("Update email for all students");
			
			session.createQuery("update Student set email='foo@luv2code.com'").executeUpdate();
			
//			no need to save object again since it has been saved, just commit
//			commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		} finally {
			factory.close();
		}

	}

}
