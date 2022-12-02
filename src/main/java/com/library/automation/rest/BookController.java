package com.library.automation.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.library.automation.dto.BookDto;
import com.library.automation.service.BookService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping(value = "/api")
@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping(value = "/books", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createBook(@RequestBody BookDto bookDto) {
		return new ResponseEntity<BookDto>(bookService.createBook(bookDto), HttpStatus.CREATED);
	}

	@GetMapping(value = "/books", produces = "application/json")
	public ResponseEntity<?> getAllBooks() {
		return new ResponseEntity<List<BookDto>>((bookService.getAllBooks()), HttpStatus.OK);
	}

	@GetMapping(value = "/books/{id}", produces = "application/json")
	public ResponseEntity<?> getBook(@PathVariable(required = true) int id) {
		return new ResponseEntity<BookDto>(bookService.getBookFindById(id), HttpStatus.OK);
	}

	@PutMapping(value = "/books/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateBookById(@PathVariable(required = true) int id, @RequestBody BookDto bookDto) {
		return new ResponseEntity<BookDto>(bookService.updateBookById(id, bookDto), HttpStatus.OK);
	}

	@DeleteMapping(value = "books/{id}")
	public void removeBookById(@PathVariable(required = true) int id) {
		bookService.deleteBookById(id);
	}

}
