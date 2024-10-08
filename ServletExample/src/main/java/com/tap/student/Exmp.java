package com.tap.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Exmp")
public class Exmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String url = null;
	String un = null;
	String pwd = null;

	Connection con;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	
    
	@Override
	public void init(ServletConfig sc) throws ServletException {
		try {
			url = sc.getInitParameter("url");
			un = sc.getInitParameter("username");
			pwd = sc.getInitParameter("password");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, un, pwd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		try {
			String query = "select * from tapstudent where un = ? and pwd = ?";
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			res = pstmt.executeQuery();
			
			if (res.next() == true) {
				writer.println("<h3>Welcome "+ res.getString(2)+"!</h3>");
			}
			else {
				writer.println("<h3>Invalid login details.Please try again!</h3>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
