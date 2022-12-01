package com.library.automation.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	public BookDto createBook(BookDto bookDto) {
		Book book = modelMapper.map(bookDto, Book.class);
		BookDto dto = modelMapper.map(bookRepository.save(book), BookDto.class);
		return dto;
	}

	@Override
	public List<BookDto> getAllBooks() {
		List<Book> books = bookRepository.findAll();
		List<BookDto> bookDtos = new ArrayList<>();
		books.stream().forEach(book -> {
			bookDtos.add(modelMapper.map(book, BookDto.class));
		});
		return bookDtos;
	}

	@Override
	public BookDto getBookFindById(int id) {
		Optional<Book> optional = bookRepository.findById(id);
		if (optional.isPresent()) {
			Book book = optional.get();
			return modelMapper.map(book, BookDto.class);
		} else
			return null;
	}

	@Override
	public BookDto updateBookById(int id, BookDto obj) {
		Optional<Book> optional = bookRepository.findById(id);
		if (optional.isPresent()) {
			Book book = optional.get();
			book.setName(obj.getName());
			book.setPublisher(obj.getPublisher());
			book.setWriter(obj.getWriter());
			bookRepository.save(book);
			return modelMapper.map(book, BookDto.class);
		} else
			return null;
	}

}
