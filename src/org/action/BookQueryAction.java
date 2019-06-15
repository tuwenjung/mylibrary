package org.action;

import java.util.List;

import org.apache.struts2.dispatcher.DefaultActionSupport;
import org.dao.BookQuery;
import org.module.Book;

import com.opensymphony.xwork2.ActionContext;

public class BookQueryAction extends DefaultActionSupport{
	private String column;
	private String basis;
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public String getBasis() {
		return basis;
	}
	public void setBasis(String basis) {
		this.basis = basis;
	}
	
	@Override
	public String execute() throws Exception {
		List<Book> bookList=new BookQuery().query(basis, column);
		ActionContext.getContext().getSession().put("books", bookList);
		return SUCCESS;
	}
	
	
}
