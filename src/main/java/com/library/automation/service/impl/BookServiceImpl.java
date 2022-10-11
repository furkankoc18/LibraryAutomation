package com.library.automation.service.impl;

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

}
