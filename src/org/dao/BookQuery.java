package org.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.module.Book;

public class BookQuery {
	public List<Book> queryByISBN(String ISBN) {
		return query(ISBN, "isbn");
	}

	public List<Book> queryByAuthor(String author) {
		return query(author, "author");
	}

	public List<Book> queryByTitle(String title) {
		return query(title, "title");
	}

	public List<Book> query(String basis, String column) {
		Session ses = new Configuration().configure().buildSessionFactory().openSession();
		String sql="";
		if(column=="title") {
			sql = "SELECT * FROM library.book WHERE " + column + " like ?";
			basis="%"+basis+"%".intern();
		}else {
			sql = "SELECT * FROM library.book WHERE " + column + "=?";
		}
		NativeQuery nq = ses.createSQLQuery(sql);
		nq.setParameter(1, basis);
		List<Object[]> listAry = nq.list();
		return ListArrayToListBook(listAry);
	}
	
	
	private List<Book> ListArrayToListBook(List<Object[]> listAry){
		List<Book> listBook = new ArrayList<Book>();
		for (Object[] o : listAry) {
			Book b = new Book((Integer) o[0], o[1].toString(), o[2].toString(),
					o[3].toString(), o[4].toString(),o[5].toString(),
					o[6].toString(), (Float) o[7], o[8].toString(), o[9].toString(),
					(Date) o[10],(Date) o[11], o[12].toString());
			listBook.add(b);
		}
		return listBook;
	}

	public static void main(String[] args) {
		BookQuery bq = new BookQuery();
//		List<Book> listBook = bq.queryByISBN("978-968-276-280-6");
//		List<Book> listBook = bq.queryByAuthor("¤ì©ö");
		List<Book> listBook = bq.queryByTitle("ÀAÅn§®­p");
		for(Book b:listBook) {
			System.out.println(b.getTitle()+","+b.getId());
		}
	}

}
