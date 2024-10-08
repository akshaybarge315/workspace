package com.tap.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException {
		System.out.println("init() method called");
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() service method called");
		PrintWriter writer = response.getWriter();
		writer.println("<h3>doGet() service method called</h3>");
		
		String username = request.getParameter("username");
		String desig = request.getParameter("desig");
		String ts = request.getParameter("techskills");
		System.out.println("username = "+username);
		System.out.println("designation = "+desig);
		System.out.println("tech skills = "+ts);

		RequestDispatcher rd =	request.getRequestDispatcher("/staticresp.html");
		rd.forward(request, response);

	}
	
	public void destroy() {
		System.out.println("destroy() method called");
	}

}
