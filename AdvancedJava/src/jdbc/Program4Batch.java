package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program4Batch {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/employee";
		String un="root";
		String pwd="root";
		
		Statement stmt=null;
		ResultSet res=null;
		Connection con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver sucessfully loaded");
			con=DriverManager.getConnection(url, un, pwd);
			System.out.println("Connection established");
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,0);
			
			String query="insert into emp(`id`,`name`,`desig`) values (7,'rob','sme')";
			String query1="insert into emp(`id`,`name`,`desig`) values (8,'rob','sme')";
			String query2="insert into emp(`id`,`name`,`desig`) values (9,'rob','sme')";
			
			stmt.addBatch(query);
			stmt.addBatch(query1);
			stmt.addBatch(query2);
			
			stmt.executeBatch();
			System.out.println("Query executed sucessfully");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
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
