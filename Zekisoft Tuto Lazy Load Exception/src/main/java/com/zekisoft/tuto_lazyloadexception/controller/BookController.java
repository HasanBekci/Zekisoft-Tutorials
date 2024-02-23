package com.zekisoft.tuto_lazyloadexception.controller;

import com.zekisoft.tuto_lazyloadexception.model.Book;
import com.zekisoft.tuto_lazyloadexception.service.BookService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

	private static final Logger LOGGER =  LogManager.getLogger(BookController.class);

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	public Book getBook(long bookId) {
		return bookService.getBook(bookId);
	}

	public void setBookAuthorNull(long bookId) {
		bookService.setBookAuthorNull(bookId);
	}

	public void setBookAuthor1(long bookId, long authorId) {
		bookService.setBookAuthor1(bookId, authorId);
	}

	public void setBookAuthor2(long bookId, long authorId) {
		bookService.setBookAuthor2(bookId, authorId);
	}

	public void setBookAuthor3(long bookId, long authorId) {
		bookService.setBookAuthor3(bookId, authorId);
	}

	public void setBookAuthor4(long bookId, long authorId) {
		var author = bookService.setBookAuthor4(bookId, authorId);
		LOGGER.info("--- Auteur '" + author.getName() + "' mis à jour");
	}

}
