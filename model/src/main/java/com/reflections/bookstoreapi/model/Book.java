package com.reflections.bookstoreapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String title;
	private String author;
	private String asinCode;
	private String category;

	public Book() {

	}

	public Book(String title, String author, String category) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAsinCode() {
		return asinCode;
	}

	public void setAsinCode(String asinCode) {
		this.asinCode = asinCode;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
