package org.dao;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.module.Book;

public class BookDao implements Dao<Book>{
	@Override
	public int add(Book book) {
		Session ses=new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx=ses.beginTransaction();
		try {
			Integer id=(Integer) ses.save(book);
			if(id!=null) {
				return id;
			}
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			ses.close();
		}
		return 0;
		
	}
	
	
	
	public static void main(String[] args) {
		BookDao dao=new BookDao();
		//新增
		Book book =new Book("jQuery錦囊妙計","978-968-276-280-6",
				"jQuery Community Experts","碁峯資訊",
				"2011-7-1",
				"jQuery新手的參考書",(float)680,"","板橋","normal");
		if(dao.add(book)==0) return;
		System.out.println("新增成功");
		//修改
//		Book book =dao.get(4);
//		book.setStatus("collected");
//		int rs=dao.update(book);
//		System.out.println(rs);
//		int rs=dao.del(4);
//		System.out.println(rs);
	}



	@Override
	public Book get(int id) {
		Session ses=new Configuration().configure().buildSessionFactory().openSession();
		Book book=ses.get(Book.class, id);
		return book;
	}



	@Override
	public int update(Book book) {
		Session ses=new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx=ses.beginTransaction();
		try {
			ses.update(book);
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
			return 0;
		}
		return 1;
	}



	@Override
	public int del(int id) {
		Session ses=new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx=ses.beginTransaction();
		try {
			ses.delete(get(id));
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return 0;
		} finally {
			ses.close();
		}
		return 1;
	}
}
