package com.spider.jdbc.preparedstatement;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class EmployeeDelete {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static FileReader fileReader;
	private static Properties properties=new Properties();
	
	public static void main(String[] args) {
		
		try {
			
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter id to be deleted");
			int id=scanner.nextInt();
			
			
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			fileReader=new FileReader("D:\\J2EE Practice\\jdbc\\Resource\\db2-info.properties");
			properties.load(fileReader);
			
			connection=DriverManager.getConnection(properties.getProperty("dburl"),properties.getProperty("user"),properties.getProperty("password"));
			
			String query="DELETE FROM employee WHERE empid=?";
			preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setInt(1, id);
			
			int count=preparedStatement.executeUpdate();
			if(count>=1) {
				System.out.println(count+" Record Deleted");
			}
			else {
				System.out.println(count+" Not Deleted");
			}
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
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
