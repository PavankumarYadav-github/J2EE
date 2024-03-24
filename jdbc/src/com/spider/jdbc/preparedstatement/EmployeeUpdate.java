package com.spider.jdbc.preparedstatement;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class EmployeeUpdate {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static Properties properties=new Properties();
	private static FileReader fileReader;
	
	public static void main(String[] args) {
		
		try {
			
			
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter id to update");
			int id=scan.nextInt();
			
			System.out.println("Enter salary to update");
			int salary=scan.nextInt();
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			fileReader=new FileReader("D:\\J2EE Practice\\jdbc\\Resource\\db2-info.properties");
			properties.load(fileReader);
			
			connection=DriverManager.getConnection(properties.getProperty("dburl"),properties.getProperty("user"),properties.getProperty("password"));
			
			String query="UPDATE employee SET esalary=? WHERE empid=?";
			preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setInt(1,salary);
			preparedStatement.setInt(2, id);
			boolean check=preparedStatement.execute();
			if(check) {
				System.out.println("Not Updated");
			}
			else {
				System.out.println("Updated...");
			}
			
			
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(connection!=null) {
					connection.close();
				}
				if(preparedStatement!=null) {
					preparedStatement.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
