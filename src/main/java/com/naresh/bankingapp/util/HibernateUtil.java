package com.naresh.bankingapp.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	// SessionFactory is an object designed to create sessions that will interact
	// with our database
	private static SessionFactory sf;

	private HibernateUtil() {
	};

	public static SessionFactory getSessionFactory() {

		if (sf == null) {
			// configuration is an "interface" that will instruct how to connect to our
			// database
			// It tells the sessionfactory how to connect to a database
			Configuration cfg = new Configuration();
			sf = cfg.configure().buildSessionFactory();
		}

		return sf;
	}

}
