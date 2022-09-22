package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

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
//			create the objects
			Instructor instructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
			
			InstructorDetail details = new InstructorDetail("http://www.luv2code.com/youtube", "Loves 2 code");
			
//			associate the objects together
			instructor.setInstructorDetail(details);
			
//			start a transaction
			session.beginTransaction();
			
//			save the instructor. 
//			NOTE: This will also save the details object because of the CascadeType.ALL
			System.out.println("Saving instructor");
			session.save(instructor);

//			commit the transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

	}

}
