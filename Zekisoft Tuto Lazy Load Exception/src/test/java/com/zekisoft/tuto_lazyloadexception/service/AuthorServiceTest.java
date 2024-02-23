package com.zekisoft.tuto_lazyloadexception.service;

import com.zekisoft.tuto_lazyloadexception.controller.AuthorController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class AuthorServiceTest {

	private static final Logger LOGGER =  LogManager.getLogger(AuthorServiceTest.class);

	@Autowired
	private AuthorController authorController;

	@Test
	void getAuthorBooks1_lazyLoadException() {
		Exception exception = assertThrows(LazyInitializationException.class, () -> authorController.getAuthorBooks1(3));
		LOGGER.error("Exception envoyée : ", exception);
	}

	@Test
	void getAuthorBooks2_lazyLoadException() {
		Exception exception = assertThrows(LazyInitializationException.class, () -> authorController.getAuthorBooks2(3));
		LOGGER.error("Exception envoyée : ", exception);
	}

	@Test
	void getAuthorBooks3_ok() {
		var authorBooks = authorController.getAuthorBooks3(3);
		Assertions.assertEquals("Do Androids Dream of Electric Sheep?;The Man in the High Castle;Ubik", authorBooks);
	}

}
