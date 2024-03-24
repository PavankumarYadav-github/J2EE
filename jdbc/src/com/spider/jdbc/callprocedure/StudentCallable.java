package com.spider.jdbc.callprocedure;

import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


import com.mysql.cj.jdbc.Driver;

public class StudentCallable {
	
	private static Connection connection;
	private static CallableStatement callableStatement;
	private static FileReader fileReader;
	private static Properties properties=new Properties();
	
	public static void main(String[] args) {
		
		try {
//			Driver driver=new Driver();
//			DriverManager.registerDriver(driver);
			
			
			
			fileReader=new FileReader("D:\\J2EE Practice\\jdbc\\Resource\\db2-info.properties");
			properties.load(fileReader);
			
			Class.forName(properties.getProperty("className"));
			
			connection=DriverManager.getConnection(properties.getProperty("dburl"),properties.getProperty("user"),properties.getProperty("password"));
			
			callableStatement=connection.prepareCall("call jdbc_practice.storedata()");
			
			boolean check=callableStatement.execute();
			System.out.println(check);
			if (check) {
				System.out.println("Inserted Successfully");
				ResultSet resultSet=callableStatement.getResultSet();
				while(resultSet.next()) {
					System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2));
				}
			} else {
				System.out.println("Failed to Insert");
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
				if(connection!=null) {
					connection.close();
				}
				if(callableStatement!=null) {
					callableStatement.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	

}
