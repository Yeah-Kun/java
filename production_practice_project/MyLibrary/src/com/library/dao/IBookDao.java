package com.library.dao;

import java.util.ArrayList;

import com.library.model.Book;

public interface IBookDao {
	public Book findByISBN(int ISBN);
	public Book findByName(String name);
	public ArrayList<Book> findAll();
	public int BookInsert(Book book);
	public int BookUpdate(Book book);
	public int BookDelete(Book book);
	
}
