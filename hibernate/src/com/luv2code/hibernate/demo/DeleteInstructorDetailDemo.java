package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

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
			
//			get the instructor detail object
			int theId = 2;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);
			
//			print instructor detail
			System.out.println("InstructorDetail: " + instructorDetail);
			
//			print associated instructor
			System.out.println("Associated instructor: " + instructorDetail.getInstructor());
			
//			delete instructorDetail
			System.out.println("Deleting...");
			session.delete(instructorDetail);
			
//			commit the transaction
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}  finally {
			session.close();
			
			factory.close();
		}

	}

}
