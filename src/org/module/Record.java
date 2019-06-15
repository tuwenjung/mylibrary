package org.module;

import java.util.Date;

public class Record {
	private  Integer id;
	private  Integer readerid;
	private  Integer bookid;
	private  Integer adminid;
	private  Date lendtime;
	private  Date returntime;
	private  Date reservetime;
	
	public Record() {}
	public Record(Integer readerid, Integer bookid, Integer adminid) {
		this.readerid = readerid;
		this.bookid = bookid;
		this.adminid = adminid;
	}
	public enum SHIFT{
		RT("returntime"),
		LT("lendtime"),
		PT("preservetime");
		private String value;
		private SHIFT(String value) {
			this.value=value;
		}
		public String value() {
			return value;
		}
	}
	



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getReaderid() {
		return readerid;
	}
	public void setReaderid(Integer readerid) {
		this.readerid = readerid;
	}
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public Integer getAdminid() {
		return adminid;
	}
	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}
	public Date getLendtime() {
		return lendtime;
	}
	public void setLendtime(Date lendtime) {
		this.lendtime = lendtime;
	}
	public Date getReturntime() {
		return returntime;
	}
	public void setReturntime(Date returntime) {
		this.returntime = returntime;
	}
	public Date getReservetime() {
		return reservetime;
	}
	public void setReservetime(Date reservetime) {
		this.reservetime = reservetime;
	}

}
