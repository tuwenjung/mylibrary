package org.action;

import java.io.File;
import java.io.IOException;
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
			if(readerid==null) { //book.jsp
				ActionContext.getContext().getSession().put("bk", b);
			}else { //lend.jsp
				ServletActionContext.getRequest().setAttribute("bk", b);
			}
			ServletActionContext.getRequest().setAttribute("msg", "getV");
		}else {
			ServletActionContext.getRequest().setAttribute("msg", "getX");
		}
		if(readerid==null) { // 從book畫面要求查詢
			return "book";
		}
		return "lend"; //從lend畫面要求查詢
	}
	
	// filename(加上預設的資料夾)轉成base64
	private String getPhotoBase64(String photoName) {
		String base64="";
		String photodir=(String) ActionContext.getContext().getApplication().get("photodir");
		System.out.println(photodir);
		Path path=new File(photodir,photoName).toPath();
		// path to base64 ---> tools
		byte[] buf = null;
		try (InputStream is = Files.newInputStream(path)){
			buf=new byte[is.available()];
			is.read(buf);
			base64=Base64.getEncoder().encodeToString(buf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return base64;
	}
	
	
	public String add() throws Exception{
		// 設定書籍照片
		String photoBase64="";
		if(photo!=null) {
			photoBase64=getPhotoBase64(photo);
		}
		book.setPhoto(photoBase64);
		// 寫入書籍資料
		Dao<Book> dao=new BookDao();
		int id=dao.add(book);
		// 
		if(id>0) { // 寫入成功：回傳Book到網頁
			Book b=dao.get(id);
			ActionContext.getContext().getSession().put("bk", b);
			ServletActionContext.getRequest().setAttribute("msg", "addV");
		} else {
			ServletActionContext.getRequest().setAttribute("msg", "addX");
		}
		return "book";
	}
	
	public String update() throws Exception{
		Dao<Book> dao=new BookDao();
		String base64;
		System.out.println("*photoo****"+photo);
		if(photo=="") {	//沒有選圖片-->沿用前圖片(空字串(不是NULL))
			base64=dao.get(book.getId()).getPhoto();
			System.out.println("*****"+base64);
		}else {
			base64=getPhotoBase64(photo);
		}
		book.setPhoto(base64);
		System.out.println("*****book:"+book);
		int rs=dao.update(book);
		if(rs==1) {
			ServletActionContext.getRequest().setAttribute("msg", "updV");
			ActionContext.getContext().getSession().remove("bk");
		}else {
			ServletActionContext.getRequest().setAttribute("msg", "updX");
		}
		return "book";
	}
	
	public String del() throws Exception{
		Dao<?> dao=new BookDao();
		int rs=dao.del(book.getId());
		if(rs==1) {
			ServletActionContext.getRequest().setAttribute("msg",  "delV");
			ActionContext.getContext().getSession().remove("bk");
		}else {
			ServletActionContext.getRequest().setAttribute("msg", "delX");
		}
		return "book";
	}
	// 清除Session:book
	public String clear() throws Exception{
		ActionContext.getContext().getSession().remove("bk");
		return "lend";
	}
	
	
	
	public Book getBook(){
		return book;
	}

	public void setBook(Book book){
		this.book = book;
	}

	public Integer getReaderid() {
		return readerid;
	}

	public void setReaderid(Integer readerid) {
		this.readerid = readerid;
	}

}
