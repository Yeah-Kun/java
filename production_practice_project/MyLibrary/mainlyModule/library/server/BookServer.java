/**
 * 2017年7月8日10:41:16
 * 访问持久层，获得Book信息，返回Book信息
 */
package library.server;

import java.util.ArrayList;

import library.dao.GetBook;
import library.model.Book;

public class BookServer implements BookServerInterface{
	
	GetBook gb = new GetBook(); // 建立持久层的press对象，用于服务层读取信息
	
	
	public ArrayList<Book> FindAll() {
		return gb.FindAll();
	}

	@Override
	public Book FindbyID(int id) {
		return gb.FindbyID(id);
	}

	@Override
	public Book FindbyName(Book entity) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean insert(Book entity) {
		// TODO 自动生成的方法存根
		return gb.insert(entity) > 0 ? true : false;
	}

	@Override
	public boolean delete(Book entity) {
		// TODO 自动生成的方法存根
		return gb.delete(entity) > 0 ? true : false;
	}

	@Override
	public boolean update(Book entity) {
		// TODO 自动生成的方法存根
		return gb.update(entity) > 0 ? true : false;
	}
	
}
