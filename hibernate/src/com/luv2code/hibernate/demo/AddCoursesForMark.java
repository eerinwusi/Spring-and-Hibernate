package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForMark {

	public static void main(String[] args) {
		
//		create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
//		create a session
		Session session = factory.getCurrentSession();
		
		try {
			
//			start a transaction
			session.beginTransaction();

//			create a course
			Course course = new Course("Pacman - How to score one million points");
			
//			save the course ... and leverage the cascade all
			System.out.println("Saving...");
			session.save(course);
			
//			create a student
			Student student = new Student("John", "Doe", "john@luv2code.com");
			Student student1 = new Student("Mark", "Ma", "mark@luv2code.com");
					
//			add student to the course
			course.addStudent(student);
			course.addStudent(student1);
			
//			save the student
			System.out.println("Saving....");
			session.save(student);
			session.save(student1);

//			commit the transaction
			session.getTransaction().commit();
			
		} finally {
			session.close();
			
			factory.close();
		}

	}

}
