package org.action;

import java.io.IOException;

import org.dao.AccountDao;
import org.module.Account;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private static final long serialVersionUID = 5135045257791832664L;
	private String user;
	private String pass;
	
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
