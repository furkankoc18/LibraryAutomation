package com.library.automation.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.automation.dto.BookDto;
import com.library.automation.service.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping(value = "/book")
@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
		BookDto dto = bookService.createBook(bookDto);
		return ResponseEntity.ok(dto);
	}

}
