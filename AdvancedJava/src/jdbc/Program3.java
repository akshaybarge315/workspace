package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program3 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/employee";
		String un = "root";
		String pwd = "root";
		
		Statement stmt = null;
		ResultSet res = null;
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver successfully loaded");
			con=DriverManager.getConnection(url, un, pwd);
			System.out.println("Connection established");
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,0);
			String query="insert into emp(`id`,`name`,`desig`) values (5,'jo','sme')";
			System.out.println(stmt.execute(query));
			System.out.println("Query executed successfully");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
