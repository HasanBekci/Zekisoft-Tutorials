package com.zekisoft.tuto_lazyloadexception.service;

import com.zekisoft.tuto_lazyloadexception.controller.AuthorController;
import com.zekisoft.tuto_lazyloadexception.controller.BookController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class BookServiceTest {

	private static final Logger LOGGER =  LogManager.getLogger(BookServiceTest.class);

	@Autowired
	private BookController bookController;

	@Autowired
	private AuthorController authorController;

	@Test
	void setBookAuthor1_ok() {
		bookController.setBookAuthor1(7, 2);
		var authorBooks = authorController.getAuthorBooks3(2);
		Assertions.assertEquals("Robots and Empire;The Caves of Steel;The Robots of Dawn", authorBooks);
		bookController.setBookAuthorNull(7);
	}

	@Test
	void setBookAuthor2_ok() {
		bookController.setBookAuthor2(7, 2);
		var authorBooks = authorController.getAuthorBooks3(2);
		Assertions.assertEquals("Robots and Empire;The Caves of Steel;The Robots of Dawn", authorBooks);
		bookController.setBookAuthorNull(7);
	}

	@Test
	void setBookAuthor3_ok() {
		bookController.setBookAuthor3(7, 2);
		var authorBooks = authorController.getAuthorBooks3(2);
		Assertions.assertEquals("Robots and Empire;The Caves of Steel;The Robots of Dawn", authorBooks);
		bookController.setBookAuthorNull(7);
	}

	@Test
	void setBookAuthor4_lazyLoadException() {
		Exception exception = assertThrows(LazyInitializationException.class, () -> bookController.setBookAuthor4(7, 2));
		LOGGER.error("exception envoyée : ", exception);
		bookController.setBookAuthorNull(7);
	}

}
