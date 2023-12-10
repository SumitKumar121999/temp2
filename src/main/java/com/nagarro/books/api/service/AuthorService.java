package com.nagarro.books.api.service;

import java.util.List;

import com.nagarro.books.api.model.Author;

/**
 * The service interface for the author
 * 
 * @author rohanaggarwal
 *
 */
public interface AuthorService {

	/**
	 * Returns the list of all the authors
	 * 
	 * @return The list of all the authors
	 */
	public List<Author> getAllAuthors();

	/**
	 * Returns the author object with a particular name
	 * 
	 * @param aname The author name
	 * @return The author object corresponding to the name
	 */
	public Author getAuthor(String authorName);

	/**
	 * Saves the author into the database
	 * 
	 * @param author The author object to be added
	 * @return The author object that was added
	 */
	public Author saveAuthor(Author author);

	/**
	 * Updates the author details for a particular author object
	 * 
	 * @param author The new author details
	 * @param aid    The author id for the author object to be updated
	 * @return The updated author object
	 */
	public Author updateAuthor(Author author, long authorId);

	/**
	 * Deletes the author object corresponding to an author id
	 * 
	 * @param aid The author id of the author object to be deleted
	 */
	public void deleteAuthor(long authorId);
}
