package org.action;

import java.io.IOError;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.dao.Dao;
import org.dao.RecordDao;
import org.module.Book;
import org.module.Record;
import org.module.Record.SHIFT;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RecordAction extends ActionSupport{
	Integer readerid;

	public void queryLendRecords() throws IOError, ServletException, IOException{
		RecordDao dao= new RecordDao();
		//已借出的未還
		List<Record> records=dao.getNeverReturn(readerid,SHIFT.LT);
		List<Book> books=dao.getAllLendBooks(readerid);
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("books", books);
		req.setAttribute("records", records);
		System.out.println(books+","+books);
		RequestDispatcher d=req.getRequestDispatcher("/lend/lend.jsp");
		d.forward(req, ServletActionContext.getResponse());
//		return "lend";
	}
	public void queryReserveRecords() throws IOError, ServletException, IOException{
		RecordDao dao= new RecordDao();
		//已預約的未借(當然未還)
		List<Record> records=dao.getNeverReturn(readerid,SHIFT.RT);
		List<Book> books=dao.getAllLendBooks(readerid);
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("books", books);
		req.setAttribute("records", records);
		System.out.println(books+","+books);
		RequestDispatcher d=req.getRequestDispatcher("/lend/lend.jsp");
		d.forward(req, ServletActionContext.getResponse());
//		return "lend";
	}
	
	public Integer getReaderid() {
		return readerid;
	}
	public void setReaderid(Integer readerid) {
		this.readerid = readerid;
	}
}
