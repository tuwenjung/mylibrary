package org.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.dao.AccountDao;
import org.dao.ReaderDao;
import org.module.Account;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private static final long serialVersionUID = 5135045257791832664L;
	private String user;
	private String pass;
	private String number;
	
	public String execute() throws Exception{
		AccountDao dao=new AccountDao();
		Account ac=dao.get(user, pass);
		if(ac==null) {
			return ERROR;
		}
		ActionContext.getContext().getSession().put("ac", ac);
		if(ac.getRole()==0) {
			return "admin";
		}else {
			return "reader";
			  
		}
	}
	
	public String add() throws IOException{
		AccountDao dao=new AccountDao();
		byte role=1; // 讀者
		String key=ServletActionContext.getServletContext().getInitParameter("admin_key").toString();
		if(number.equals(key)) {
			role=0;	 // 管理員
		}
		Account ac=new Account(user,pass,role);
		int rowCount=dao.add(ac);
		if(role==1) { // reader
			ReaderDao rDao=new ReaderDao();
			Integer accountId=dao.get(user, pass).getId();
			int rs=rDao.update(accountId,number);
			System.out.println("建立讀者帳號和會員帳號的關聯，更新讀者資訊:"+rs);
		}
		String msg=rowCount>0?"addV":"addX";
		ServletActionContext.getRequest().setAttribute("l_msg", msg);
		return SUCCESS;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String logout() throws IOException{
		ActionContext.getContext().getSession().remove("ac");
		return SUCCESS;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
		
	
}
