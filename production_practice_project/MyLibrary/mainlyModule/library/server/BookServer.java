/**
 * 2017��7��8��10:41:16
 * ���ʳ־ò㣬���Book��Ϣ������Book��Ϣ
 */
package library.server;

import java.util.ArrayList;

import library.dao.GetBook;
import library.model.Book;

public class BookServer implements BookServerInterface{
	
	GetBook gb = new GetBook(); // �����־ò��press�������ڷ�����ȡ��Ϣ
	
	
	public ArrayList<Book> FindAll() {
		return gb.FindAll();
	}

	@Override
	public Book FindbyID(int id) {
		return gb.FindbyID(id);
	}

	@Override
	public Book FindbyName(Book entity) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public boolean insert(Book entity) {
		// TODO �Զ����ɵķ������
		return gb.insert(entity) > 0 ? true : false;
	}

	@Override
	public boolean delete(Book entity) {
		// TODO �Զ����ɵķ������
		return gb.delete(entity) > 0 ? true : false;
	}

	@Override
	public boolean update(Book entity) {
		// TODO �Զ����ɵķ������
		return gb.update(entity) > 0 ? true : false;
	}
	
}
