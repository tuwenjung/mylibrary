package org.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.dao.BookDao;
import org.dao.Dao;
import org.dao.ReaderDao;
import org.dao.RecordDao;
import org.module.Account;
import org.module.Book;
import org.module.Record;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class LendAction extends ActionSupport {
	
	private int readerid;
	private Book book;
	private Integer[] ids;
	

	public void checkReader() throws Exception{
		ReaderDao dao=new ReaderDao();
		HttpServletRequest req=ServletActionContext.getRequest();
		if(dao.check(readerid)) {
			req.setAttribute("rid", readerid);
		}
		req.getRequestDispatcher("/lend/lend.jsp").forward(req, ServletActionContext.getResponse());
	}
	
	private void editRecord(String doing) {
		RecordDao rDao=new RecordDao();
		Record record=null;
		switch(doing) {
			case "lend":// add Record with lendtime
				Account admin=(Account) ActionContext.getContext().getSession().get("ac");
				record=new Record(readerid,book.getId(),admin.getId());
				int rs=rDao.add(record);
				break;
			case "return": // write Record.returntime
				System.out.println("*****還書recordids:"+ids);
				rDao.updatTimes(ids,Record.SHIFT.RT);
				break;
			case "lendSome": // write Record.lendtime
				System.out.println("********借一些recordids:"+ids);
				rDao.updatTimes(ids,Record.SHIFT.LT);
		}
		
		
	}
	
	public String lendBook() throws Exception {
		editRecord("lend");
		return "lend";
	}

	public String lendBooks() throws Exception {
		System.out.println("借一些");
		editRecord("lendSome");
		return "lend";
	}	
	
	public String returnBooks() throws Exception {
		System.out.println("還書");
		editRecord("return");
		
		return "lend";
	}
	
	public int getReaderid() {
		return readerid;
	}

	public void setReaderid(int readerid) {
		this.readerid = readerid;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	
	

}
