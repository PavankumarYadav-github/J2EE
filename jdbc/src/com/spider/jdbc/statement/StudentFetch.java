package com.spider.jdbc.statement;

import java.io.FileReader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class StudentFetch {

	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static FileReader fileReader;
	private static Properties properties=new Properties();

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			fileReader=new FileReader("D:\\\\J2EE Practice\\\\jdbc\\\\Resource\\\\db-info.properties");
			properties.load(fileReader);
			
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_practice",properties);
			
			statement=connection.createStatement();
			resultSet=statement.executeQuery("SELECT * FROM student");
			
			if(resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
			}
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(connection!=null){
					connection.close();
				}
				if(statement!=null) {
					statement.close();
				}
				if(resultSet!=null) {
					resultSet.close();
				}
				
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
