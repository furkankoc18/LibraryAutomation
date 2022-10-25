package com.library.automation.service;

import java.util.List;

import com.library.automation.dto.BookDto;
import com.library.automation.exceptions.BookException;

public interface BookService {

	BookDto createBook(BookDto bookDto);

	List<BookDto> getAllBooks();

	BookDto getBookFindById(int id);

	BookDto updateBookById(int id, BookDto bookDto);
}
