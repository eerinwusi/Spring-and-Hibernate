package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
//		create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
//		create a session
		Session session = factory.getCurrentSession();
		
		try {			
//			start a transaction
			session.beginTransaction();
			
//			get the instructor by id
			int theId = 1;
			Instructor instructor = session.get(Instructor.class, theId);
			
			System.out.println("Found instructor");
			
//			delete the instructors
			if (instructor != null) {
				System.out.println("Deleting....");
				
//				Note: This will also delete the InstructorDetail because of the CascadeType.ALL
				session.delete(instructor);
			}

//			commit the transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

	}

}
