package com.library.automation.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.library.automation.dto.BookDto;

public interface BookService {

	ResponseEntity<Object> createBook(BookDto bookDto);

	ResponseEntity<Object> getAllBooks();

	ResponseEntity<Object> getBookFindById(int id);

	ResponseEntity<Object> updateBookById(int id, BookDto bookDto);

	ResponseEntity<Object> deleteBookById(int id);
}
