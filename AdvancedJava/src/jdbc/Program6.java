package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Program6 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/employee";
		String un = "root";
		String pwd = "root";
		
		PreparedStatement pstmt = null;
		ResultSet res = null;
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver successfully loaded");
			
			con=DriverManager.getConnection(url, un, pwd);
			System.out.println("Connection established");
			
			String query ="insert into emp(`id`,`name`,`desig`,`salary`) values (?,?,?,?)";
			
			pstmt = con.prepareStatement(query);
			
			Scanner scan =new Scanner(System.in);
			int n = scan.nextInt();
			
			for(int i = 1;i <= n;i++)
			{
				int id = scan.nextInt();
				String name = scan.next();
				String desig = scan.next();
				int salary = scan.nextInt();
				
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3, desig);
				pstmt.setInt(4, salary);
				
				pstmt.execute();
			}
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
