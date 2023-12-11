package com.nagarro.books.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long authorId;

	String authorName;

	/**
	 * Returns the author id
	 * 
	 * @return The author id
	 */
	public Long getAuthorId() {
		return authorId;
	}

	/**
	 * Sets the author id
	 * 
	 * @param aid The author id to be set
	 */
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	/**
	 * Returns the author name
	 * 
	 * @return The author name to be set
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * Sets the author name
	 * 
	 * @param aname The author name to be set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

}
