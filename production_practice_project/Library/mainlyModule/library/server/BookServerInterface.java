/**
 * 2017��7��8��10:37:17
 * ����Book��ͼ����Ϣ���ӿ�
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
