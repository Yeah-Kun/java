package com.library.service;

import com.library.dao.BookDaoImpl;
import com.library.dao.ReaderDaoImpl;
import com.library.model.Book;
import com.library.model.Reader;

public class AdminServiceImpl implements IAdminService{
	BookDaoImpl bkdi=new BookDaoImpl();
	ReaderDaoImpl rdi=new ReaderDaoImpl();
	@Override
	public boolean BookInsert(Book book) {
		// TODO 自动生成的方法存根
		return bkdi.BookInsert(book)>0?true:false;
	}
	@Override
	public boolean BookUpdate(Book book) {
		// TODO 自动生成的方法存根
		return bkdi.BookUpdate(book)>0?true:false;
	}
	@Override
	public boolean BookDelete(Book book) {
		// TODO 自动生成的方法存根
		return bkdi.BookDelete(book)>0?true:false;
	}
	@Override
	public boolean ReaderInsert(Reader reader) {
		// TODO 自动生成的方法存根
		return rdi.ReaderInsert(reader)>0?true:false;
	}
	@Override
	public boolean ReaderUpdate(Reader reader) {
		// TODO 自动生成的方法存根
		return rdi.ReaderUpdate(reader)>0?true:false;
	}
	@Override
	public boolean ReaderDelete(Reader reader) {
		// TODO 自动生成的方法存根
		return rdi.ReaderDelete(reader)>0?true:false;
	}

	

}
