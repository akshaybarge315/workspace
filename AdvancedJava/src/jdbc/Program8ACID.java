package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program8ACID {
	
	static final String SQL = "UPDATE `employee` SET `salary` = `salary` + ? WHERE `name` = ?";
	static final String SELECT_QUERY = "select * from `employee`";
	static final Scanner sc = new Scanner(System.in);
	
	private static Connection connection;
	
	public static void main(String[] args) {
		
		
		String url = "jdbc:mysql://localhost:3306/jdbcclasses";
		String un = "root";
		String pass = "root";
		
		try {
			
			connection = DriverManager.getConnection(url, un, pass);

			display();
			
			connection.setAutoCommit(false);			
			transcation();

			display();

			
		} catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	static void transcation() throws SQLException {
		System.out.println("Enter Sender's name");
		String sender = sc.next();
		
		System.out.println("Enter Reciver's name");
		String reciver = sc.next();
		
		System.out.println("Enter Amount");
		int amount = sc.nextInt();
		
		int i = updateSalary(sender, -amount);
		int j = updateSalary(reciver, amount);
		
		if(isConfirm(i, j)) {
			connection.commit();
		}else {
			connection.rollback();
		}
	}
	
	
	static int updateSalary(String user, int amount) throws SQLException{
		PreparedStatement statement = connection.prepareStatement(SQL);
		
		statement.setInt(1, amount);
		statement.setString(2, user);
		
		int i = statement.executeUpdate();
		
		return i;
	}
	
	
	static boolean isConfirm(int i, int j) {
		System.out.println("DO you want to confirm this transcation?? (Yes/No)");
		String choice = sc.next();
		
		return choice.equalsIgnoreCase("yes") && i==1 && j==1;
	}
	
	 
	static void display() {
		try {
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery(SELECT_QUERY);
			
	        while(res.next()) {
	    		int id = res.getInt("id");
	            String name = res.getString("name");
	            String email = res.getString("email");
	            String department = res.getString("department");
	            String salary = res.getString("salary");
	            
	            System.out.println(id + " " + name + " " + email + " " + department + " " + salary);
	        }
		} catch (SQLException e) {
            e.printStackTrace();
        }
	}
}