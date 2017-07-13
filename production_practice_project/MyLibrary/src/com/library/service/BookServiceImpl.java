package com.library.service;

import java.util.ArrayList;

import com.library.dao.BookDaoImpl;
import com.library.model.Book;

public class BookServiceImpl implements IBookService {
	BookDaoImpl bkdi = new BookDaoImpl();

	@Override
	public int bookNumber() {
		// TODO 自动生成的方法存根
		int sum = 0;
		ArrayList<Book> bookList = new ArrayList<Book>();
		bookList = bkdi.findAll();
		for (Book book : bookList) {
			sum += book.getNumber();
		}
		return sum;
	}

	@Override
	public Book findByBook_ISBN(int ISBN) {
		// TODO 自动生成的方法存根
		return bkdi.findByISBN(ISBN);
	}

	@Override
	public Book findByBook_name(String name) {
		// TODO 自动生成的方法存根
		return bkdi.findByName(name);
	}

}
