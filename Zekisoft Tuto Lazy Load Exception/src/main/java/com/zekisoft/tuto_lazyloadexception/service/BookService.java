package com.zekisoft.tuto_lazyloadexception.service;

import com.zekisoft.tuto_lazyloadexception.dao.AuthorDao;
import com.zekisoft.tuto_lazyloadexception.dao.BookDao;
import com.zekisoft.tuto_lazyloadexception.model.Author;
import com.zekisoft.tuto_lazyloadexception.model.Book;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

	private static final Logger LOGGER =  LogManager.getLogger(BookService.class);

	private final BookDao bookDao;
	private final AuthorDao authorDao;

	public BookService(BookDao bookDao, AuthorDao authorDao) {
		this.bookDao = bookDao;
		this.authorDao = authorDao;
	}

	public Book getBook(long bookId) {
		LOGGER.info("--- Récupération du livre depuis la BDD");
		return bookDao.findById(bookId).orElseThrow();
	}

	@Transactional
	public void setBookAuthorNull(long bookId) {

		LOGGER.info("--- Récupération du livre depuis la BDD");
		var book = bookDao.findById(bookId).orElseThrow();

		LOGGER.info("--- Suppression de l'auteur du livre");
		book.setAuthor(null);

	}

	@Transactional
	public void setBookAuthor1(long bookId, long authorId) {

		LOGGER.info("--- Récupération du livre depuis la BDD");
		var book = bookDao.findById(bookId).orElseThrow();

		LOGGER.info("--- Récupération de l'auteur depuis la BDD");
		var author = authorDao.findById(authorId).orElseThrow();

		LOGGER.info("--- Définition de l'auteur du livre");
		book.setAuthor(author);

	}

	@Transactional
	public void setBookAuthor2(long bookId, long authorId) {

		LOGGER.info("--- Récupération du livre depuis la BDD");
		var book = bookDao.getReferenceById(bookId);

		LOGGER.info("--- Récupération de l'auteur depuis la BDD");
		var author = authorDao.getReferenceById(authorId);

		LOGGER.info("--- Définition de l'auteur du livre");
		book.setAuthor(author);

	}

	@Transactional
	public void setBookAuthor3(long bookId, long authorId) {

		LOGGER.info("--- Récupération du livre depuis la BDD");
		var book = bookDao.getReferenceById(bookId);

		LOGGER.info("--- Récupération de l'auteur depuis la BDD");
		var author = authorDao.getReferenceById(authorId);

		LOGGER.info("--- Définition de l'auteur du livre");
		book.setAuthor(author);

		LOGGER.info("--- Auteur '" + author.getName() + "' mis à jour");

	}

	@Transactional
	public Author setBookAuthor4(long bookId, long authorId) {

		LOGGER.info("--- Récupération du livre depuis la BDD");
		var book = bookDao.getReferenceById(bookId);

		LOGGER.info("--- Récupération de l'auteur depuis la BDD");
		var author = authorDao.getReferenceById(authorId);

		LOGGER.info("--- Définition de l'auteur du livre");
		book.setAuthor(author);

		return author;
	}

}
