package com.reflections.bookstoreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.reflections.bookstoreapi.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

	@Query(value = "SELECT * FROM AUTHOR A WHERE A.NAME = ?1", nativeQuery = true)
	public Author getAuthorByName(String name);
}
