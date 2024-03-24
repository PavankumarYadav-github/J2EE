package com.spider.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentInsert {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String classname="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/jdbc_practice";
		String username="root";
		String password="root";
		String query="INSERT INTO student VALUES('1','Alex')";
		
		Class.forName(classname);
		Connection connection=DriverManager.getConnection(url,username,password);
		
		Statement statement =connection.createStatement();
		int i=statement.executeUpdate(query);
		
		if(i>=1) {
			System.out.println("Data inserted");
		}
		else {
			System.out.println("Data Not Inserted");
		}
		
		connection.close();
		
		
	}
}
