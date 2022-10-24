package com.library.automation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.library.automation.dto.BookDto;
import com.library.automation.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping(value = "/api")
@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping(value = "/books", consumes = "application/json", produces = "application/json")
	public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
		BookDto dto = bookService.createBook(bookDto);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/books", produces = "application/json")
	public ResponseEntity<List<BookDto>> getAllBooks() {
		return ResponseEntity.ok(bookService.getAllBooks());
	}

	@GetMapping(value = "/books/{id}", produces = "application/json")
	public ResponseEntity<BookDto> getBook(@PathVariable(required = true) int id) {
		return ResponseEntity.ok(bookService.getBookFindById(id));
	}

}
