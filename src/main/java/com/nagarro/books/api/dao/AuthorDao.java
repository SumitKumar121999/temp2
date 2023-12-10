package com.nagarro.books.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.books.api.model.Author;

/**
 * Dao class for the Author
 * 
 * @author rohanaggarwal
 *
 */
@Repository
public interface AuthorDao extends JpaRepository<Author, Long> {
	/**
	 * Returns the authors with a particular name
	 * 
	 * @param authorName Author name to search
	 * @return The author object(s) matching the name
	 */
	List<Author> findByAuthorName(String authorName);
}
