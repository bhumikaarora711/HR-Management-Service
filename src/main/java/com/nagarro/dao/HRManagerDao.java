package com.nagarro.dao;
/*
 * @Author Bhumika_Arora
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.model.HRManager;

public class HRManagerDao {
	
	public static SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public HRManagerDao() {
		super();
	}
	
	public HRManager getHRManager(final String username) {
		final Session session = sf.openSession();
		final HRManager obj = session.get(HRManager.class, username);
		session.close();
		return obj;
	}

}
