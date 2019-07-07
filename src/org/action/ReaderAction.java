package org.action;

import org.apache.struts2.ServletActionContext;
import org.dao.Dao;
import org.dao.ReaderDao;
import org.module.Reader;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class ReaderAction extends ActionSupport {
	private Reader reader;
	
	
	public String get() throws Exception {
		System.out.println("into ReaderAction.get()");
		Dao<Reader> dao= new ReaderDao();
		Reader r=dao.get(reader.getId());
		ActionContext.getContext().getSession().put("reader", r);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		System.out.println("into ReaderAction.update()");
		Dao<Reader> dao= new ReaderDao();
		//TODO:photo
		dao.update(reader);
		//ActionContext.getContext().getSession().put("reader", r);
		return SUCCESS;
	}	
	
	public String add() throws Exception {
		System.out.println("in ReaderAction.add()");
		if(reader!=null) {
			Dao<Reader> dao= new ReaderDao();
			int rs=dao.add(reader);
			ServletActionContext.getRequest().setAttribute("r_msg", rs==0?"addX":"addV");
		}
		return SUCCESS;
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

}
