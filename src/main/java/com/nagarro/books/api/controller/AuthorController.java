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

import com.nagarro.books.api.model.Author;
import com.nagarro.books.api.service.AuthorService;


@RestController
@RequestMapping("/bookapi/v1/author")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	/**
	 * Read operation for all the authors
	 * 
	 * @return list of all the authors
	 */
	@GetMapping()
	public List<Author> getAllAuthors() {
		return authorService.getAllAuthors();
	}

	/**
	 * Create operation for the author
	 * 
	 * @param author The new author to be created and saved
	 * @return The saved author and http status
	 */
	@PostMapping()
	public ResponseEntity<Author> saveAuthor(@RequestBody Author author) {
		return new ResponseEntity<Author>(authorService.saveAuthor(author), HttpStatus.CREATED);
	}

	/**
	 * Update operation for the author
	 * 
	 * @param aid    The author id
	 * @param author The author object with updated details
	 * @return The updated object and http status
	 */
	@PutMapping("{aid}")
	public ResponseEntity<Author> updateBook(@PathVariable("aid") long aid, @RequestBody Author author) {
		return new ResponseEntity<Author>(authorService.updateAuthor(author, aid), HttpStatus.OK);
	}

	/**
	 * Delete operation for the author
	 * 
	 * @param aid The author id for which the author is to be deleted
	 * @return The success message and http status
	 */
	@DeleteMapping("{aid}")
	public ResponseEntity<String> deleteBook(@PathVariable("aid") long aid) {
		authorService.deleteAuthor(aid);
		return new ResponseEntity<String>("Successfully deleted the author", HttpStatus.OK);
	}

}
