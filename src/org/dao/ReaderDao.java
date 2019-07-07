package org.dao;

import java.math.BigInteger;
import java.util.List;

import org.conn.DBSess;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.module.Reader;

public class ReaderDao implements Dao<Reader>{
	public static void main(String[] args) {
		ReaderDao dao=new ReaderDao();
		System.out.println(dao.check(1));
	}
	public boolean check(int id) {
		Session ses=DBSess.ses();
		String sql="SELECT 5 FROM reader WHERE id=?";
		NativeQuery<?> sq=ses.createSQLQuery(sql);
		sq.setParameter(1, id);
		List<?> list=sq.getResultList();
		BigInteger rs=list.size()>0?(BigInteger) list.get(0):null;
		return rs==null?false:true;

	}
	
	@Override
	public Reader get(int id) {
		Session ses=DBSess.ses();
		return ses.load(Reader.class, id);
	}

	@Override
	public int add(Reader r) {
		
		Session ses=DBSess.ses();
		Transaction  tx=ses.beginTransaction();
		try {
			ses.save(r);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
			return 0;
		}
		return 1;
	}

	@Override
	public int update(Reader ac) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int del(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int update(Integer accountId, String number) {
		Session ses=DBSess.ses();
		String sql="UPDATE reader SET accountid=? WHERE number=?";
		NativeQuery<?> query=ses.createSQLQuery(sql);
		query.setParameter(1, accountId);
		query.setParameter(2, number);
		query.addEntity(Reader.class);
		Transaction tx=ses.beginTransaction();
		try {
			int rs=query.executeUpdate();
			tx.commit();
			return rs;
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return 0;
	}

}
