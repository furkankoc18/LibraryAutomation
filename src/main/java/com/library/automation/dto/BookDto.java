package com.library.automation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {
	private int id;
	private String name;
	private String writer;
	private String publisher;

}
