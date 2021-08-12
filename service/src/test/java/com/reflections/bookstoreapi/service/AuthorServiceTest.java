package com.reflections.bookstoreapi.service;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.*;

import com.reflections.bookstoreapi.model.Author;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AuthorServiceTest {

	@Autowired
	AuthorService service = new AuthorService();

	@Test
	void getAuthorByName() {
		List<Author> author = service.getAuthorByName("author1");
		assertThat(author.size()).isNotNull();
	}
}
