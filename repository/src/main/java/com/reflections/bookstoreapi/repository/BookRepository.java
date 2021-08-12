package com.reflections.bookstoreapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reflections.bookstoreapi.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query(value = "SELECT * FROM BOOK B WHERE B.TITLE = ?1 OR B.AUTHOR = ?2 OR B.ASINCODE = ?3 OR B.CATEGORY = ?4", nativeQuery = true)
	List<Book> findbyKey(String title, String author, String asinCode, String category);
}
