package org.action;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

import javax.servlet.http.Part;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.UploadedFile;
import org.dao.BookDao;
import org.dao.Dao;
import org.module.Book;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BookCRUDAction  extends ActionSupport{

	private static final long serialVersionUID = -7499710752617796166L;
	private Book book;
	private Integer readerid;
	public Integer getReaderid() {
		return readerid;
	}

	public void setReaderid(Integer readerid) {
		this.readerid = readerid;
	}

	private String photo;

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String get() throws Exception{
		BookDao dao=new BookDao();
		System.out.println("book:"+book);
		System.out.println("book id:"+book.getId());
		Book b=dao.get(book.getId());
		if(b!=null) {
			ActionContext.getContext().getSession().put("bk", b);
			ActionContext.getContext().getSession().put("msg", "已查到");
		}else {
			ActionContext.getContext().getSession().put("msg", "查無此書");
		}
		if(readerid==null) {
			return "book";
		}
		return "lend";
	}

	public String add() throws Exception{
		String photodir=(String) ActionContext.getContext().getApplication().get("photodir");
		System.out.println(photodir);
		Path path=new File(photodir,photo).toPath();
		// path to base64 ---> tools 
		InputStream is=Files.newInputStream(path);
		byte[] buf=new byte[is.available()];
		is.read(buf);
		String photoBase64=Base64.getEncoder().encodeToString(buf);
		
		book.setPhoto(photoBase64);
		Dao<Book> dao=new BookDao();
		int id=dao.add(book);
		if(id>0) {
			Book b=dao.get(id);
			ActionContext.getContext().getSession().put("bk", b);
			ActionContext.getContext().getSession().put("msg", "新增成功");
		} else {
			ActionContext.getContext().getSession().put("msg", "新增失敗");
		}
		return "book";
	}
	
	public String update() throws Exception{
		System.out.println(photo.getClass().getName());
		System.out.println("photo"+photo);
		Dao<Book> dao=new BookDao();
		if(photo=="") {	//沒有選圖片-->沿用前圖片
			photo=dao.get(book.getId()).getPhoto();
		}else {
			String photodir="E:\\My Pictures\\bookphoto\\";//ToDo:set context attr
			byte[] buf;
			try(InputStream is=Files.newInputStream(new File(photodir, photo).toPath());){
				buf=new byte[is.available()];
				is.read(buf);
			}
			photo=Base64.getEncoder().encodeToString(buf);
			
		}
		book.setPhoto(photo);
		System.out.println("book:"+book);
		int rs=dao.update(book);
		if(rs==1) {
			ActionContext.getContext().getSession().put("msg", "修改成功");
			ActionContext.getContext().getSession().put("bk", dao.get(book.getId()));
		}else {
			ActionContext.getContext().getSession().put("msg", "修改失敗");
		}
		return "book";
	}
	
	public String del() throws Exception{
		Dao<?> dao=new BookDao();
		int rs=dao.del(book.getId());
		if(rs==1) {
			ActionContext.getContext().getSession().put("msg", "資料已刪除");
			ActionContext.getContext().getSession().put("bk", new Book());
		}else {
			ActionContext.getContext().getSession().put("msg", "刪除失敗");
		}
		return "book";
	}
	
	public Book getBook(){
		return book;
	}

	public void setBook(Book book){
		this.book = book;
	}
}
