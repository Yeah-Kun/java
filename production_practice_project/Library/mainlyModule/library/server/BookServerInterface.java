/**
 * 2017年7月8日10:37:17
 * 定义Book（图书信息）接口
 */
package library.server;

import java.util.ArrayList;

import library.model.Book;

public interface BookServerInterface {
	public ArrayList<Book> FindAll();
	public Book FindbyID(int id); 
	public Book FindbyName(Book entity);
	public boolean insert(Book entity);
	public boolean delete(Book entity);
	public boolean update(Book entity);
}
