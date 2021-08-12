package com.reflections.bookstoreapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reflections.bookstoreapi.model.Author;
import com.reflections.bookstoreapi.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepo;
	
	public int addAuthor(Author author) {
		return authorRepo.save(author).getId();
	}

	public List<Author> listAuthors() {
		return authorRepo.findAll();
	}
	
	public Author getAuthorByName(String name){
		return authorRepo.getAuthorByName(name);
	}
}
