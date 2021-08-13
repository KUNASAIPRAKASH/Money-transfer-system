package com.project.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LocalEntityManageFactory {

	private static EntityManagerFactory emf;

	//static block will execute only one-time'
	static {
		emf = Persistence.createEntityManagerFactory("my-pu");
	}

	public static EntityManagerFactory emf() {
		return emf;
	}

}