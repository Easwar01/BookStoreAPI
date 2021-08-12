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

import com.reflections.bookstoreapi.model.Author;
import com.reflections.bookstoreapi.service.AuthorService;

@RestController
@RequestMapping("/v1/bookstore")
public class AuthorController {

	@Autowired
	private AuthorService service;

	@RequestMapping("/authors")
	public ResponseEntity<List<Author>> listAllAuthors() {
		return new ResponseEntity<List<Author>>(service.listAuthors(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/author")
	public ResponseEntity<Integer> addAuthor(@RequestBody Author author) {
		if(author == null) {
			return new ResponseEntity<Integer>(0, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Integer>(service.addAuthor(author), HttpStatus.OK);
	}

	@RequestMapping("/author/{name}")
	public ResponseEntity<Author> getAuthorDetails(@PathVariable String name) {
		if(name.isEmpty() || name == null || name.equals("")) {
			return new ResponseEntity<Author>(new Author(), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Author>(service.getAuthorByName(name), HttpStatus.OK);
	}
}
