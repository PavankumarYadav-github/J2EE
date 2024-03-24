package com.spider.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDelete {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_practice?user=root&password=root");
		Statement statement=connection.createStatement();
		int i=statement.executeUpdate("DELETE FROM STUDENT WHERE studentid=1");
		if(i>0) {
			System.out.println("Deleted....");
		}
		else {
			System.out.println("Not Deleted");
		}
		
		
		
	}

}
