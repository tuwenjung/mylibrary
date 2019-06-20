package org.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.dao.BookDao;
import org.dao.Dao;
import org.dao.ReaderDao;
import org.dao.RecordDao;
import org.module.Account;
import org.module.Book;
import org.module.Record;
import org.module.Record.SHIFT;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class LendAction extends ActionSupport {
	
	private int readerid;
	private Book book;
	private Integer[] ids;
	private int bookid;

	public void checkReader() throws Exception{
		ReaderDao dao=new ReaderDao();
		HttpServletRequest req=ServletActionContext.getRequest();
		if(dao.check(readerid)) {
			req.getSession().setAttribute("rid",readerid);
		}
		req.getRequestDispatcher("/lend/lend.jsp").forward(req, ServletActionContext.getResponse());
	}
	
	private boolean editRecord(String doing) throws IOException {
		RecordDao rDao=new RecordDao();
		Record record=null;
		switch(doing) {
			case "lend":// add Record with lendtime    	TODO:set status as outer
				Account admin=(Account) ActionContext.getContext().getSession().get("ac");
				record=new Record(readerid,book.getId(),admin.getId());
				int rs=rDao.add(record);
				break;	
			case "return": // write Record.returntime	TODO:set status as inner
				rDao.updatTimes(ids,Record.SHIFT.RT);
				break;
			case "lendSome": // write Record.lendtime
				rDao.updatTimes(ids,Record.SHIFT.LT);
				break;
			case "reserve" :
				System.out.println("reserve");
				Account ac= (Account) ActionContext.getContext().getSession().get("ac");
				if(ac==null) {
					return false;
				}
				System.out.println(ac.getId()+","+bookid);
				record=new Record(ac.getId(), bookid, Integer.valueOf(0));
				rDao.addReserve(record);
		}
		return true;
	}
	
	public String lendBook() throws Exception {
		editRecord("lend");
		return "lend";
	}

	public String lendBooks() throws Exception {
		editRecord("lendSome");
		return "lend";
	}	
	
	public String returnBooks() throws Exception {
		editRecord("return");
		return "lend";
	}
	
	public String reserveBook() throws Exception{
		if(!editRecord("reserve")) {
			return ERROR;
		}
		//回傳book
		System.out.println("********************end");
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpServletResponse rsp=ServletActionContext.getResponse();
		req.setAttribute("rsbook",book);
		req.getRequestDispatcher("/query/reserveok.jsp").forward(req, rsp);
		return SUCCESS;
	}
	
	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
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
