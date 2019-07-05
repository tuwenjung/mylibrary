package org.dao;

import java.util.List;
import org.conn.DBSess;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.module.Book;
import org.module.Record;
import org.module.Record.SHIFT;

public class RecordDao implements Dao<Record> {

	public static void main(String[] args) {
		RecordDao dao=new RecordDao();
		dao.updateTime(5, SHIFT.RT);
		
	}

	@Override
	public Record get(int id) {
		Session ses=DBSess.ses();
		return ses.load(Record.class, id);
	}
	// returntime=null -> 未還	lendtime!=null -> 已借	lendtime==null -> 未借(預約)
	public List<Record> getNotReturn(Integer readerid,SHIFT shift){
		Session ses=DBSess.ses();
		String YN=shift==SHIFT.LT?"NOT":""; //not:lendtime not null：借出    | lendtime is null:預約 	   
		String sql = "SELECT * FROM record WHERE readerid=? AND returntime IS NULL AND lendtime IS "+YN+" NULL";
		NativeQuery<Record> query=ses.createSQLQuery(sql);
		query.addEntity(Record.class);
		query.setParameter(1, readerid);
		List<Record> list=query.list();
		return list;
	}
	
	public List<Book> getAllLendBooks(Integer readerid) {
		Session ses=DBSess.ses();
		String sql = "SELECT * FROM book WHERE id in (SELECT bookid FROM record WHERE readerid=? AND returntime  IS NULL)";
		NativeQuery<Book> query=ses.createSQLQuery(sql);
		query.addEntity(Book.class);
		query.setParameter(1, readerid);
		List<Book> list=query.list();
		return list;
	}
	
	@Override
	public int add(Record r) {
		return add(r,"lendtime");
	}
	
	public int addReserve(Record r) {
		return add(r,"reservetime");
	}
	 
	private int add(Record r,String kindOfTime) {
		Session ses=DBSess.ses();
		Transaction tx = null;
		if(!ses.getTransaction().isActive()) {
			tx=ses.beginTransaction();
		}
		try {
			String sql="INSERT INTO record(readerid,bookid,adminid,"+kindOfTime+") VALUES(?,?,?,NOW())";
			NativeQuery query=ses.createSQLQuery(sql);
			query.setParameter(1, r.getReaderid());
			query.setParameter(2,r.getBookid());
			query.setParameter(3,r.getAdminid());
			query.addEntity(Record.class);
			query.executeUpdate();
			tx.commit();
			return 1;
		}catch(Exception e){
			tx.rollback();
			
		}
		return 0;
	}
	@Override
	public int update(Record r) {
		Session ses=DBSess.ses();
		Transaction tx=ses.beginTransaction();
		try {
			ses.update(r);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}
		return 0;
	}

	@Override
	public int del(int id) {
		Session ses=DBSess.ses();
		Transaction tx=ses.beginTransaction();
		try {
			Record r=this.get(id);
			ses.delete(r);
			tx.commit();
			return 1;
		}catch(Exception e){
			tx.rollback();
		}
		return 0;
	}

	
	public void updateTime(Integer id, Record.SHIFT shift) {
		Session ses=DBSess.ses();
		System.out.println(shift+":"+id);
		String sql="UPDATE record SET "+shift.value()+"=NOW() WHERE id=?";
		System.out.println("%%%%%%%%%%% sql="+sql);
		NativeQuery<?> query=ses.createSQLQuery(sql);
		query.setParameter(1,id);
		Transaction tx=ses.beginTransaction();
		try {
			query.executeUpdate();
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	// 批次更新借(預約)(還)書時間
	public void updatTimes(Integer[] ids,Record.SHIFT shift) {
		System.out.println("批次shift="+shift.value());
		Session ses=DBSess.ses();
		for(Integer id:ids) {
			updateTime(id,shift);
		}
		
	}





}
