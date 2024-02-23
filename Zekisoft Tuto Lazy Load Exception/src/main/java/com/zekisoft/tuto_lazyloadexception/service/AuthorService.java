package com.zekisoft.tuto_lazyloadexception.service;

import com.zekisoft.tuto_lazyloadexception.dao.AuthorDao;
import com.zekisoft.tuto_lazyloadexception.model.Author;
import com.zekisoft.tuto_lazyloadexception.model.Book;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class AuthorService {

	private static final Logger LOGGER =  LogManager.getLogger(AuthorService.class);

	private final AuthorDao authorDao;

	public AuthorService(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}

	public Author getAuthor(long authorId) {

		LOGGER.info("--- Récupération de l'auteur depuis la BDD");
		var author = authorDao.findById(authorId).orElseThrow();

//		author.getBooks().size(); // A éviter

		return author;

	}

	public String getAuthorBooks1(Author author) {

		LOGGER.info("--- Récupération des livres de l'auteur");
		var books = author.getBooks();

		LOGGER.info("--- Calcul du résultat");
		var result = books.stream().map(Book::getTitle).sorted().collect(Collectors.joining(";"));

		LOGGER.info("--- Résultat retourné");

		return result;

	}


	@Transactional
	public String getAuthorBooks2(Author author) {

		LOGGER.info("--- Récupération des livres de l'auteur");
		var books = author.getBooks();

		LOGGER.info("--- Calcul du résultat");
		var result = books.stream().map(Book::getTitle).sorted().collect(Collectors.joining(";"));

		LOGGER.info("--- Résultat retourné");

		return result;

	}

	@Transactional
	public String getAuthorBooks3(long authorId) {

		LOGGER.info("--- Récupération de l'auteur depuis la BDD");
		var author = authorDao.findById(authorId).orElseThrow();

		LOGGER.info("--- Récupération des livres de l'auteur");
		var books = author.getBooks();

		LOGGER.info("--- Calcul du résultat");
		var result = books.stream().map(Book::getTitle).sorted().collect(Collectors.joining(";"));

		LOGGER.info("--- Résultat retourné");

		return result;

	}

}
