package com.nagarro.books.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.books.api.dao.BookDao;
import com.nagarro.books.api.exception.ResourceNotFoundException;
import com.nagarro.books.api.model.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	/**
	 * Saves a new book in the database
	 */
	public Book saveBook(Book book) {
		return bookDao.save(book);
	}

	/**
	 * Returns a list of all the books in the database
	 */
	public List<Book> getAllBooks() {
		return bookDao.findAll();
	}

	/**
	 * Returns the book corresponding to a particular book code
	 */
	public Book findByBcode(long bcode) {
		Optional<Book> book = bookDao.findByBcode(bcode);
		if (book.isPresent()) {
			return book.get();
		} else {
			throw new ResourceNotFoundException("Book", "Book id", bcode);
		}
	}

	/**
	 * Updates the data of an existing book
	 */
	@Override
	public Book updateBook(Book book) {
		Optional<Book> existingBook = bookDao.findByBcode(book.getBcode());
		if (existingBook.isPresent()) {
			existingBook.get().setBauthor(book.getBauthor());
			existingBook.get().setBname(book.getBname());
			bookDao.save(existingBook.get());
			return existingBook.get();
		} else {
			throw new ResourceNotFoundException("Book", "Book code", book.getBcode());
		}
	}

	/**
	 * Deletes a particular book object
	 */
	@Override
	public void deleteBook(long bcode) {
		Optional<Book> existingBook = bookDao.findByBcode(bcode);
		if (!existingBook.isPresent()) {
			throw new ResourceNotFoundException("Book", "Book code", bcode);
		}
		bookDao.deleteByBcode(bcode);
	}

}
