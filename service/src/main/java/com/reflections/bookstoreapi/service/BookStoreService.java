package com.reflections.bookstoreapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reflections.bookstoreapi.model.Book;
import com.reflections.bookstoreapi.repository.BookRepository;

@Service
public class BookStoreService {

	@Autowired
	private BookRepository bookRepo;

	private String createAsinCode() {
		long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		return Long.toString(number);
	}

	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}

	public int addBook(Book book) {
		book.setAsinCode(createAsinCode());
		return bookRepo.save(book).getId();
	}

	public List<Book> getByKey(String key) {
		return bookRepo.findbyKey(key, key, key, key);
	}

	public Book updateBook(Book book, int bookId) {
		Optional<Book> book1 = bookRepo.findById(bookId);

		if (book1.isPresent()) {
			Book newBook = book1.get();
			newBook.setCategory(book1.get().getCategory());
			newBook.setAuthor(book1.get().getAuthor());
			newBook.setAsinCode(book1.get().getAsinCode());
			newBook.setTitle(book1.get().getTitle());

			newBook = bookRepo.save(newBook);
			return newBook;
		} else {
			return bookRepo.save(book);
		}
	}

	public int deletebook(int bookId) {
		Optional<Book> book1 = bookRepo.findById(bookId);

		if (book1.isPresent()) {
			bookRepo.deleteById(bookId);
			return 1;
		}

		return 0;
	}
}
