package com.spider.jdbc.preparedstatement;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class EmployeeInsert {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static Properties properties = new Properties();
	private static FileReader fileReader;

	public static void main(String[] args) {

		try {
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the id");
			int eid = scanner.nextInt();
			scanner.nextLine();
			
			System.out.println("Enter the name");
			String ename = scanner.nextLine();

			System.out.println("Enter the salary");
			int esalary = scanner.nextInt();
			
			scanner.nextLine();
			System.out.println("Enter the address");
			String eaddress = scanner.nextLine();
			
			Class.forName("com.mysql.cj.jdbc.Driver");

			fileReader = new FileReader("D:\\J2EE Practice\\jdbc\\Resource\\db-info.properties");
			properties.load(fileReader);

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_practice",
					properties.getProperty("user"), properties.getProperty("password"));
			
			preparedStatement = connection.prepareStatement("INSERT INTO employee VALUES(?,?,?,?)");
			preparedStatement.setInt(1,eid);
			preparedStatement.setString(2,ename);
			preparedStatement.setInt(3,esalary);
			preparedStatement.setString(4, eaddress);
			
			int count = preparedStatement.executeUpdate();
			
			
			
			if (count >= 0) {
				System.out.println("DATA Inserted...");
			} else {
				System.out.println("DATA NOT Inserted...");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
