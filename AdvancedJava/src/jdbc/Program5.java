package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Program5 {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/employee";
		String un="root";
		String pwd="root";
		
		PreparedStatement pstmt=null;
		ResultSet res=null;
		Connection con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver successfully loaded");
			
			con=DriverManager.getConnection(url, un, pwd);
			
			System.out.println("Connection established");
			String query ="insert into emp(`id`,`name`,`desig`) values (?,?,?)";
			
			pstmt = con.prepareStatement(query);
			Scanner s =new Scanner(System.in);
			int n = s.nextInt();
			String s1 = s.next();
			String s2 = s.next();
			
			pstmt.setInt(1, n);
			pstmt.setString(2, s1);
			pstmt.setString(3, s2);
			
			pstmt.execute();
			System.out.println("Query executed");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
