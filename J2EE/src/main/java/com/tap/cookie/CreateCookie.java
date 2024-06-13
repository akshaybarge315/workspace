package com.tap.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateCookie")
public class CreateCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		Cookie ck = new Cookie("browser", "chrome");
		ck.setMaxAge(90);
		resp.addCookie(ck);
		writer.println("<h3>Cookie has been created</h3>");
		
		Cookie ck1 = new Cookie("browser", "chrome");
		ck1.setMaxAge(90);
		resp.addCookie(ck1);
		
		Cookie ck2 = new Cookie("os", "windows");
		ck2.setMaxAge(90);
		resp.addCookie(ck2);

	}

}
