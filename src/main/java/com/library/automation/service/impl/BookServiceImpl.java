package com.library.automation.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.library.automation.api.ResponseHandler;
import com.library.automation.dto.BookDto;
import com.library.automation.model.Book;
import com.library.automation.repo.BookRepository;
import com.library.automation.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ResponseEntity<Object> createBook(BookDto bookDto) {
		Book book = modelMapper.map(bookDto, Book.class);
		BookDto dto = modelMapper.map(bookRepository.save(book), BookDto.class);
		return ResponseHandler.generateResponse("message", HttpStatus.OK, dto);
	}

	@Override
	public ResponseEntity<Object> getAllBooks() {
		List<Book> books = bookRepository.findAll();
		List<BookDto> bookDtos = new ArrayList<>();
		books.stream().forEach(book -> {
			bookDtos.add(modelMapper.map(book, BookDto.class));
		});
		return ResponseHandler.generateResponse("message", HttpStatus.OK, bookDtos);
	}

	@Override
	public ResponseEntity<Object> getBookFindById(int id) {
		Optional<Book> optional = bookRepository.findById(id);
		if (optional.isPresent()) {
			Book book = optional.get();
			return ResponseHandler.generateResponse("message", HttpStatus.OK, book);
		} else
			return null;
	}

	@Override
	public ResponseEntity<Object> updateBookById(int id, BookDto obj) {
		Optional<Book> optional = bookRepository.findById(id);
		if (optional.isPresent()) {
			Book book = optional.get();
			book.setName(obj.getName());
			book.setPublisher(obj.getPublisher());
			book.setWriter(obj.getWriter());
			bookRepository.save(book);
			return ResponseHandler.generateResponse("message", HttpStatus.OK, book);
		} else
			return null;
	}

	@Override
	public ResponseEntity<Object> deleteBookById(int id) {
		bookRepository.deleteById(id);
		return ResponseHandler.generateResponse("message", HttpStatus.OK, "");
	}

}
