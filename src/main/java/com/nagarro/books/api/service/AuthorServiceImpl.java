package com.nagarro.books.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.books.api.dao.AuthorDao;
import com.nagarro.books.api.exception.ResourceNotFoundException;
import com.nagarro.books.api.model.Author;

/**
 * Implements the author service interface
 * 
 * @author rohanaggarwal
 *
 */
@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDao authorDao;

	/**
	 * Returns the list of all the authors
	 */
	public List<Author> getAllAuthors() {
		return authorDao.findAll();
	}

	/**
	 * Returns the author object with a particular name
	 */
	public Author getAuthor(String authorName) {
		return authorDao.findByAuthorName(authorName).get(0);
	}

	/**
	 * Saves the author into the database
	 */
	@Override
	public Author saveAuthor(Author author) {
		return authorDao.save(author);
	}

	/**
	 * Updates the author details for a particular author object
	 */
	@Override
	public Author updateAuthor(Author author, long authorId) {
		Optional<Author> existingAuthor = authorDao.findById(authorId);
		if (existingAuthor.isPresent()) {
			existingAuthor.get().setAuthorName(author.getAuthorName());
			authorDao.save(existingAuthor.get());
			return existingAuthor.get();
		} else {
			throw new ResourceNotFoundException("Book", "Book code", authorId);
		}
	}

	/**
	 * Deletes the author object corresponding to an author id
	 */
	@Override
	public void deleteAuthor(long aid) {
		Optional<Author> existingAuthor = authorDao.findById(aid);
		if (!existingAuthor.isPresent()) {
			throw new ResourceNotFoundException("Author", "Author id", aid);
		}
		authorDao.deleteById(aid);
	}

}
