package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
		
//		create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
//		create a session
		Session session = factory.getCurrentSession();
		
		try {
			
//			start a transaction
			session.beginTransaction();
			
//			get instructor from db
			int theId = 1;	
			Instructor instructor = session.get(Instructor.class, theId);
			
			System.out.println("Instructor: " + instructor);
			
//			get instructor courses
			System.out.println("Courses: " + instructor.getCourses());

//			commit the transaction
			session.getTransaction().commit();
			
		} finally {
			session.close();
			
			factory.close();
		}

	}

}
