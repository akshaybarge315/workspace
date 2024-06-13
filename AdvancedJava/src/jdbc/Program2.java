package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Program2 {

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
			String query="select * from emp";
			
			res = stmt.executeQuery(query);
			
			ResultSetMetaData metaData = res.getMetaData();
			System.out.println(metaData.getColumnCount());
			
			for(int i=1;i<metaData.getColumnCount();i++) {
				System.out.println(metaData.getColumnName(i)+" "+metaData.getColumnTypeName(i));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			res.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
