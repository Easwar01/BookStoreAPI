package com.reflections.bookstoreapi.controller.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reflections.bookstoreapi.model.Author;
import com.reflections.bookstoreapi.service.AuthorService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@WebMvcTest
public class AuthorControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper mapper;

	@MockBean
	AuthorService service;

	Author author1 = new Author("author1", "book1");
	Author author2 = new Author("author2", "book2");
	Author author3 = new Author("author3", "book3");

	@Test
	public void listAllAuthors() {
		List<Author> authors = new ArrayList<Author>(Arrays.asList(author1, author2, author3));

		Mockito.when(service.listAuthors()).thenReturn(authors);

		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/v1/bookstore/authors")).andExpect(status().isOk())
					.andExpect(jsonPath("$", hasSize(3))).andExpect(jsonPath("$[2].name", is("author3")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getAuthorByName() {
		Mockito.when(service.getAuthorByName(author1.getName())).thenReturn(author1);
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/v1/bookstore/author/author1")).andExpect(status().isOk())
					.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].book", is("book1")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addAuthor() {
		Mockito.when(service.addAuthor(author1)).thenReturn(1);
		try {
			mockMvc.perform(MockMvcRequestBuilders.post("/v1/bookstore/author")).andExpect(status().isOk())
					.andExpect(jsonPath("$", notNullValue())).andExpect(jsonPath("$[0].book", is("book1")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
