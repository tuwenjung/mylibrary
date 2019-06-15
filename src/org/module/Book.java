package org.module;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8382367452299929256L;
	private Integer id;
	private String title;
	private String isbn;
	private String author;
	private String publisher;
	private String publishdate;
	private String summary;
	private Float price;
	private String photo;
	private String location;
	private Date createtime;
	private Date updatetime;
	private String status;
//	status restrict¡G'normal','display','reserve','collected','obsolete','discard'



	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}


	public Book() {
	}

	public Book(Integer id, String title, String isbn, String author, String publisher, String publishdate,
			String summary, Float price, String photo, String location, Date createtime, Date updatetime,
			String status) {
		super();
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.publisher = publisher;
		this.publishdate = publishdate;
		this.summary = summary;
		this.price = price;
		this.photo = photo;
		this.location = location;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.status = status;
	}

	public Book(Integer id, String title, String isbn, String author, String publisher, String publishdate,
			String summary, Float price, String photo, String location, String status) {
		this(title, isbn, author, publisher, publishdate, summary, price, photo, location,  status);
		this.id = id;
	}

	public Book(String title, String isbn, String author, String publisher, String publishdate, String summary,
			Float price, String photo, String location, String status) {
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.publisher = publisher;
		this.publishdate = publishdate;
		this.summary = summary;
		this.price = price;
		this.photo = photo;
		this.location = location;
		this.status = status;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
		
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
