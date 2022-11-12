package com.ozu.exam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TBOOK")
public class Book {
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher=" + publisher + "]";
	}

	@Id
	@Column(length = 10)
	private String isbn;

	@Column(length = 50, nullable = false)
	private String title;
	
	@Column(length = 20)
	private String author;
	
	@Transient
	@Column(name = "PUBLISHING_COMPANY")
	private String publisher;

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

	

	public Book(String isbn, String title, String author, String publisher) {
		super();
		this.isbn = isbn;
		this.title=title;
		this.author = author;
		this.publisher = publisher;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

}
