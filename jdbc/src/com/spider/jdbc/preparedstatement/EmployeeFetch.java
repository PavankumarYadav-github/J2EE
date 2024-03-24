package com.spider.jdbc.preparedstatement;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class EmployeeFetch {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static Properties properties = new Properties();
	private static FileReader fileReader;
	private static ResultSet resultSet;
	
	public static void main(String[] args) {
		
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			fileReader=new FileReader("D:\\J2EE Practice\\jdbc\\Resource\\db2-info.properties");
			properties.load(fileReader);
			
			connection=DriverManager.getConnection(properties.getProperty("dburl"),properties.getProperty("user"),properties.getProperty("password"));
			String query="SELECT * FROM employee";
			
			preparedStatement=connection.prepareStatement(query);
			
			//we can also use executequery here
			boolean check=preparedStatement.execute();
			
			if(check) {
				resultSet=preparedStatement.getResultSet();
				while (resultSet.next()) {
					System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3)+" "+resultSet.getString(4));
					
				}
			}
			else {
				System.out.println("Done");
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
