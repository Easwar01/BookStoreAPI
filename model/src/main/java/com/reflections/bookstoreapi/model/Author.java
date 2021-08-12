package com.reflections.bookstoreapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Author {

	@Id
	@GeneratedValue
	private int Id;
	private String name;
	private String book;

	public Author() {

	}

	public Author(String name, String book) {
		super();
		this.name = name;
		this.book = book;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBook() {
		return book;
	}

	public void setBooks(String book) {
		this.book = book;
	}
}
