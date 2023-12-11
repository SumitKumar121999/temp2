package com.nagarro.books.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.books.api.model.Book;
import com.nagarro.books.api.service.BookService;


@RestController
@RequestMapping("/bookapi/v1/book")
public class BookController {

	@Autowired
	private BookService bookService;

	/**
	 * Create operation for the book
	 * 
	 * @param book The new book to be saved
	 * @return The book saved
	 */
	@PostMapping()
	public ResponseEntity<Book> saveBook(@RequestBody Book book) {
		return new ResponseEntity<Book>(bookService.saveBook(book), HttpStatus.CREATED);
	}

	/**
	 * Read operation for all the books
	 * 
	 * @return The list of all the books
	 */
	@GetMapping()
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	/**
	 * Read operation for a book with a particular book code
	 * 
	 * @param bcode The book code
	 * @return The book returned with that book code
	 */
	@GetMapping("{bcode}")
	public ResponseEntity<Book> getBookByBcode(@PathVariable("bcode") long bcode) {
		return new ResponseEntity<Book>(bookService.findByBcode(bcode), HttpStatus.OK);
	}

	/**
	 * Update operation for the book
	 * 
	 * @param bcode The book code for the book to be updated
	 * @param book  The updated details of the book
	 * @return The updated object of the book
	 */
	@PutMapping("{bcode}")
	public ResponseEntity<Book> updateBook(@PathVariable("bcode") long bcode, @RequestBody Book book) {
		return new ResponseEntity<Book>(bookService.updateBook(book), HttpStatus.OK);
	}

	/**
	 * Delete operation for the book
	 * 
	 * @param bcode The book code of the book to be deleted
	 * @return A Success message
	 */
	@DeleteMapping("{bcode}")
	public ResponseEntity<String> deleteBook(@PathVariable("bcode") long bcode) {
		bookService.deleteBook(bcode);
		return new ResponseEntity<String>("Successfully deleted the book", HttpStatus.OK);
	}
}
