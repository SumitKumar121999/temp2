package com.nagarro.books.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bid;
	private long bcode;
	private String bname;
	private String bauthor;
	private String bdate;

	/**
	 * Returns the book id
	 * 
	 * @return The book id
	 */
	public long getBid() {
		return bid;
	}

	/**
	 * Sets the book id
	 * 
	 * @param bid The book id to be set
	 */
	public void setBid(long bid) {
		this.bid = bid;
	}

	/**
	 * Returns the book code
	 * 
	 * @return The book code
	 */
	public long getBcode() {
		return bcode;
	}

	/**
	 * Sets the book code
	 * 
	 * @param bcode The book code to be set
	 */
	public void setBcode(long bcode) {
		this.bcode = bcode;
	}

	/**
	 * Returns the book name
	 * 
	 * @return The book name
	 */
	public String getBname() {
		return bname;
	}

	/**
	 * Sets the book name
	 * 
	 * @param bname The book name to be set
	 */
	public void setBname(String bname) {
		this.bname = bname;
	}

	/**
	 * Returns the book author name
	 * 
	 * @return The book author name
	 */
	public String getBauthor() {
		return bauthor;
	}

	/**
	 * Sets the book author name
	 * 
	 * @param bauthor The book author name
	 */
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	/**
	 * Returns the date the book was added
	 * 
	 * @return The date the book was added
	 */
	public String getBdate() {
		return bdate;
	}

	/**
	 * Sets the date the book was added
	 * 
	 * @param bdate The date the book was added
	 */
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

}
