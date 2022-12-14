package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServer
 */
@WebServlet("/TestDbServer")
public class TestDbServer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		setup connection variables
		String user = "springstudent";
		String password = "springstudent";
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		
		String driver = "com.mysql.jdbc.Driver";
		
		
		try {
			PrintWriter out = response.getWriter();
			
			out.println("Connecting to database: "+ jdbcUrl);
			
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
			
			out.println("Connection succesful");
			
			conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
//		get connection to the database
	}

}
