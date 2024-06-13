package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program1 {
	public static void main(String args[]) {
		String url = "jdbc:mysql://localhost:3306/employee";
		String un = "root";
		String pwd = "root";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver successfully loaded");
			Connection con = DriverManager.getConnection(url, un, pwd);
			System.out.println("Connection established");
			Statement stmt = con.createStatement();
			String query = "select * from emp1";
			ResultSet res = stmt.executeQuery(query);
			System.out.println("Query executed");
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Driver not loaded");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
