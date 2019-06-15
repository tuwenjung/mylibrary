package org.action;

import org.dao.Dao;
import org.dao.ReaderDao;
import org.module.Reader;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class ReaderAction extends ActionSupport {
	private Reader reader;
	private String photo;
	
	public String get() throws Exception {
		System.out.println("into ReaderAction.get()");
		Dao<Reader> dao= new ReaderDao();
		Reader r=dao.get(reader.getId());
		ActionContext.getContext().getSession().put("reader", r);
		
		
		return "lend";
	}
	
	@Override
	public String execute() throws Exception {

		return super.execute();
	}
	public Reader getReader() {
		return reader;
	}
	public void setReader(Reader reader) {
		this.reader = reader;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
