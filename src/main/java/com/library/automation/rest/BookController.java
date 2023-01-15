package com.library.automation.rest;

import org.springframework.beans.factory.annotation.Autowired;
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
		return bookService.createBook(bookDto);
	}

	@GetMapping(value = "/books", produces = "application/json")
	public ResponseEntity<?> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping(value = "/books/{id}", produces = "application/json")
	public ResponseEntity<?> getBook(@PathVariable(required = true) int id) {
		return bookService.getBookFindById(id);
	}

	@PutMapping(value = "/books/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateBookById(@PathVariable(required = true) int id, @RequestBody BookDto bookDto) {
		return bookService.updateBookById(id, bookDto);
	}

	@DeleteMapping(value = "books/{id}")
	public ResponseEntity<?> removeBookById(@PathVariable(required = true) int id) {
		return bookService.deleteBookById(id);
	}

}
