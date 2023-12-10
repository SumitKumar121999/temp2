package com.nagarro.books.api.service;

import java.util.List;

import com.nagarro.books.api.model.Book;

/**
 * The service interface for the book
 * 
 * @author rohanaggarwal
 *
 */
public interface BookService {
	/**
	 * Saves a new book in the database
	 * 
	 * @param book The new book to be saved
	 * @return The book that was saved
	 */
	public Book saveBook(Book book);

	/**
	 * Returns a list of all the books in the database
	 * 
	 * @return The list of all the books in the database
	 */
	public List<Book> getAllBooks();

	/**
	 * Returns the book corresponding to a particular book code
	 * 
	 * @param bcode The book code
	 * @return The book corresponding to the book code
	 */
	public Book findByBcode(long bcode);

	/**
	 * Updates the data of an existing book
	 * 
	 * @param book The book object with the data to be updated
	 * @return The updated book object
	 */
	public Book updateBook(Book book);

	/**
	 * Deletes a particular book object
	 * 
	 * @param bcode The book code for which the object is to be deleted
	 */
	public void deleteBook(long bcode);
}
