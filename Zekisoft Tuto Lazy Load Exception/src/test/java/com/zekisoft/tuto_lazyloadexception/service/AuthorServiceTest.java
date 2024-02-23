package com.zekisoft.tuto_lazyloadexception.service;

import com.zekisoft.tuto_lazyloadexception.controller.AuthorController;

import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class AuthorServiceTest {

	@Autowired
	private AuthorController authorController;

	@Test
	void getAuthorBooks1_lazyLoadException() {
		assertThrows(LazyInitializationException.class, () -> authorController.getAuthorBooks1(3));
	}

	@Test
	void getAuthorBooks2_lazyLoadException() {
		assertThrows(LazyInitializationException.class, () -> authorController.getAuthorBooks2(3));
	}

	@Test
	void getAuthorBooks3_ok() {
		var authorBooks = authorController.getAuthorBooks3(3);
		Assertions.assertEquals("Do Androids Dream of Electric Sheep?;The Man in the High Castle;Ubik", authorBooks);
	}

}
