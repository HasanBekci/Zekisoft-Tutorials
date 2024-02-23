package com.zekisoft.tuto_lazyloadexception.controller;

import com.zekisoft.tuto_lazyloadexception.model.Author;
import com.zekisoft.tuto_lazyloadexception.service.AuthorService;

import org.springframework.stereotype.Controller;

@Controller
public class AuthorController {

	private final AuthorService authorService;

	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}

	public Author getAuthor(long authorId) {
		return authorService.getAuthor(authorId);
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
