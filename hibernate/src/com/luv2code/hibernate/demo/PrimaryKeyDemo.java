package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
//		create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
//		create a session
		Session session = factory.getCurrentSession();
		
		try {
//			create three students object
			Student student = new Student("Mark", "Ma", "paul@luv2code.com");
			Student student1 = new Student("John", "Doe", "john@luv2code.com");
			Student student2 = new Student("Foo", "Bar", "foo@luv2code.com");
			
//			start a transaction
			session.beginTransaction();
			
//			save the object
			session.save(student);
			session.save(student1);
			session.save(student2);
			
//			commit the transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
