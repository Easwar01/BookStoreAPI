package com.reflections.bookstoreapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reflections.bookstoreapi.model.Book;
import com.reflections.bookstoreapi.service.BookStoreService;

@RestController
@RequestMapping("/v1/bookstore")
public class BookStoreController {

	@Autowired
	private BookStoreService service;

	@RequestMapping(method = RequestMethod.POST, value = "/book")
	public ResponseEntity<Integer> addBook(@RequestBody Book book) {
		if (book == null) {
			return new ResponseEntity<Integer>(0, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Integer>(service.addBook(book), HttpStatus.OK);
	}

	@RequestMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks() {
		return new ResponseEntity<List<Book>>(service.getAllBooks(), HttpStatus.OK);
	}

	@RequestMapping("/book/{key}")
	public ResponseEntity<List<Book>> getByKey(@PathVariable String key) {
		if (key.isEmpty() || key == null || key.equals("")) {
			return new ResponseEntity<List<Book>>(new ArrayList<Book>(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Book>>(service.getByKey(key), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/book/{bookId}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable int bookId){
		if (book == null) {
			return new ResponseEntity<Book>(new Book(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Book>(service.updateBook(book, bookId), HttpStatus.OK);
	}
	
	@RequestMapping("/book/{bookId")
	public ResponseEntity<Integer> deleteBook(@PathVariable int bookId){
		if(bookId == 0) {
			return new ResponseEntity<Integer>(0, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Integer>(service.deletebook(bookId), HttpStatus.OK);
	}

}
