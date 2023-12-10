package com.nagarro.books.api.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.books.api.model.Book;

/**
 * Dao class for the book
 *  
 * @author rohanaggarwal
 *
 */
@Repository
public interface BookDao extends JpaRepository<Book, Long> {
	/**
	 * Returns a book object corresponding to a particular book code
	 * 
	 * @param bcode The book code to search by
	 * @return The book object corresponding to the book code
	 */
	Optional<Book> findByBcode(long bcode);
	
	/**
	 * Deletes a book object corresponding to a particular book code
	 * @param bcode The book code of the book to delete
	 * @return The book object deleted
	 */
	@Transactional
	Book deleteByBcode(long bcode);
}
