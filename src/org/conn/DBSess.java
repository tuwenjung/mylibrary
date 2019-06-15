package org.conn;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class DBSess {
	private static Session ses;
	public static Session ses() {
		if(ses==null) {
			Configuration config = new Configuration().configure();
			ses = config.buildSessionFactory().openSession();
		}
		return ses;
	}
	public static void close() {
		ses.close();
	}
	
	public static void main(String[] args) {
		System.out.println(DBSess.ses());

	}

}
