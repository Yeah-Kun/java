/**
 * 2017��7��8��10:03:23
 * ����ͼ����Ľӿ�
 */
package library.dao;

import java.util.ArrayList;

import library.model.Book;

public interface BookInterface {
	public ArrayList<Book> FindAll(); // ��������ͼ�����Ϣ
	public Book FindbyID(int id); // ͨ��ID����press�����������
	public int insert(Book entity);// ���һ��ʵ�壬˳��Ϊ��name��adress��url��mail
	public int delete(Book enity); //ɾ��
	public int update(Book entity); //�޸�
	
}
