package org.action;

import java.nio.charset.Charset;

import org.apache.struts2.ServletActionContext;
import org.dao.Dao;
import org.dao.ReaderDao;
import org.module.Account;
import org.module.Reader;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class ReaderAction extends ActionSupport {
	private Reader reader;
	private Integer accountid;
	
	
	public String get() throws Exception {
		System.out.println("into ReaderAction.get()");
		Dao<Reader> dao= new ReaderDao();
		Reader r=dao.get(reader.getId());
		ActionContext.getContext().getSession().put("reader", r);
		return SUCCESS;
	}
	
	// update前的查詢(讀者是以account登入，所以用acountid查詢)
	public void getFromAccountId() throws Exception {
		ReaderDao dao= new ReaderDao();
		System.out.println("**********"+accountid);
		Object acid=ServletActionContext.getRequest().getParameter("accountid");
		System.out.println("*****ac*****"+acid);
		Reader r=dao.getByAccountId(accountid);
		Gson gson=new Gson();
		String rJson=gson.toJson(r);
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().getWriter().write(rJson);
		//ServletActionContext.getRequest().setAttribute("reader", r);
	}
	
	public String update() throws Exception {
		System.out.println("into ReaderAction.update()");
		
		ReaderDao dao= new ReaderDao();
		
		Account ac=(Account) ActionContext.getContext().getSession().get("ac");
		if(ac==null) {//未登入
			ServletActionContext.getRequest().setAttribute("msg", "Not Login");
			return "index";
		}
		Reader originReader=dao.getByAccountId(ac.getId());
		reader.setId(originReader.getId());
		reader.setAccountid(ac.getId());
		System.out.println("crtime:"+originReader.getCreatetime());
		reader.setCreatetime(originReader.getCreatetime());
		String ph=reader.getPhoto();
		System.out.println("photo:"+ph);
		if(ph=="") {
			reader.setPhoto(originReader.getPhoto());
		}
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
	
	
	public Integer getAccountid() {
		return accountid;
	}

	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}

	public Reader getReader() {
		return reader;
	}
	
	public void setReader(Reader reader) {
		this.reader = reader;
	}

}
