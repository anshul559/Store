package net.ash.shoppingBackend.SessionUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SessionUtil {
	
	public Session getAnnotatedSession() {
		
		Session ssn = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		return ssn;
	}
	
	public Session getNormalSession() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory fctry = cfg.buildSessionFactory();
		Session s = fctry.openSession();
		return s;
	}
}


	