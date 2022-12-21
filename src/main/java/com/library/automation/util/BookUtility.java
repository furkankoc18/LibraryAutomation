package com.library.automation.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.library.automation.dto.BookDto;
import com.library.automation.model.Book;

public class BookUtility {
	@Autowired
	private ModelMapper modelMapper;

	public BookDto copyModelBookToBookDto(Book book) {
		BookDto bookDto=new BookDto();
		modelMapper.map(book, BookDto.class);
		
		return null;
	}
	
}
