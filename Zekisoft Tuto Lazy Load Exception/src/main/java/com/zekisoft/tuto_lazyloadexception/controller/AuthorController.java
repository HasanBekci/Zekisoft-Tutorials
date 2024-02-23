package com.zekisoft.tuto_lazyloadexception.controller;

import com.zekisoft.tuto_lazyloadexception.service.AuthorService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorController {

	private static final Logger LOGGER =  LogManager.getLogger(AuthorController.class);

	private final AuthorService authorService;

	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}

	public String getAuthorBooks1(long authorId) {
		var author = authorService.getAuthor(authorId);
		return authorService.getAuthorBooks1(author);
	}

	public String getAuthorBooks2(long authorId) {
		var author = authorService.getAuthor(authorId);
		return authorService.getAuthorBooks2(author);
	}

	public String getAuthorBooks3(long authorId) {
		return authorService.getAuthorBooks3(authorId);
	}

}
