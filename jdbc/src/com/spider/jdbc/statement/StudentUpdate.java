package com.spider.jdbc.statement;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class StudentUpdate {

	private static Connection connection;
	private static Statement statement;
	private static Properties properties = new Properties();
	private static FileReader fileReader;

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			fileReader = new FileReader("D:\\J2EE Practice\\jdbc\\Resource\\db-info.properties");
			properties.load(fileReader);

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_practice", properties);
			statement = connection.createStatement();

			int i = statement.executeUpdate("UPDATE STUDENT SET sname='BOB' WHERE studentid=1");

			if (i >= 1) {
				System.out.println("Upadted....");
			} else {
				System.out.println("Not Updated");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

}
