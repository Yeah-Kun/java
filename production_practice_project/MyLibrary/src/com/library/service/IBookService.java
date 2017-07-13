package com.library.service;

import java.util.ArrayList;

import com.library.model.Book;

public interface IBookService {
	public int bookNumber();

	public Book findByBook_ISBN(int ISBN);

	public Book findByBook_name(String name);
}
