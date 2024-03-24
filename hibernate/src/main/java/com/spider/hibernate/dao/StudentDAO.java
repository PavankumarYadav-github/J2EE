package com.spider.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.spider.hibernate.dto.StudentDTO;

public class StudentDAO {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("hiber");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		
		StudentDTO student1=new StudentDTO();
		student1.setSid(2);
		student1.setSname("joyes");
		student1.setSemail("joyes@gmail.com");
		student1.setSmarks(95);
		student1.setSaddress("Streat-3,USA");
		
		entityManager.persist(student1);
		entityTransaction.commit();
	}

}
