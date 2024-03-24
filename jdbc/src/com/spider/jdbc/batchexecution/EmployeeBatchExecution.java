package com.spider.jdbc.batchexecution;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class EmployeeBatchExecution {
	
	public static void main(String[] args) {
		
		Employee emp1=new Employee();
		emp1.setId(1);
		emp1.setName("Alex");
		emp1.setSalary(200000);
		emp1.setAddress("Street1");
		
		Employee emp2=new Employee();
		emp2.setId(2);
		emp2.setName("Jone");
		emp2.setSalary(200000);
		emp2.setAddress("Street-5");
		
		List<Employee> list=new ArrayList<Employee>();
	    list.add(emp1);
	    list.add(emp2);
	    
	    
	    try {
	    	Driver driver=new Driver();
	    	DriverManager.registerDriver(driver);
	    	
	    	FileInputStream fileInputStream = new FileInputStream("D:\\J2EE Practice\\jdbc\\Resource\\db2-info.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			
			Connection connection = DriverManager.getConnection(properties.getProperty("dburl"),
					properties.getProperty("user"), properties.getProperty("password"));
			
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee VALUES (?,?,?,?)");
			for(Employee employee:list) {
				preparedStatement.setInt(1, employee.getId());
				preparedStatement.setString(2, employee.getName());
				preparedStatement.setInt(3, employee.getSalary());
				preparedStatement.setString(4, employee.getAddress());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			System.out.println("Batch Execution Done");
	    }
	    catch (SQLException e) {
			e.printStackTrace();
		}
	    catch (IOException e) {
			e.printStackTrace();
		}
	    
	    
		
	}

}
