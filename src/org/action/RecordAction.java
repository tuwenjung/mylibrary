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
		List<Record> records=dao.getNotReturn(readerid,SHIFT.LT);
		List<Book> books=dao.getAllLendBooks(readerid);
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("books", books);
		req.setAttribute("records", records);
		RequestDispatcher d;
		if(req.getParameter("src")==null) {
			d=req.getRequestDispatcher("/lend/lend.jsp");
		}else {
			d=req.getRequestDispatcher("/reader/reader.jsp");
			req.setAttribute("src", "reader");
		}
		d.forward(req, ServletActionContext.getResponse());
	}
	public void queryReserveRecords() throws IOError, ServletException, IOException{
		RecordDao dao= new RecordDao();
		//已預約的未借(當然未還)
		List<Record> records=dao.getNotReturn(readerid,SHIFT.RT);
		List<Book> books=dao.getAllLendBooks(readerid);
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("books", books);
		req.setAttribute("records", records);
		RequestDispatcher d;
		if(req.getParameter("src")==null) {
			d=req.getRequestDispatcher("/lend/lend.jsp");
		}else {
			d=req.getRequestDispatcher("/reader/reader.jsp");
			req.setAttribute("src", "reader");
		}
		d.forward(req, ServletActionContext.getResponse());
	}
	
	public Integer getReaderid() {
		return readerid;
	}
	public void setReaderid(Integer readerid) {
		this.readerid = readerid;
	}
}
