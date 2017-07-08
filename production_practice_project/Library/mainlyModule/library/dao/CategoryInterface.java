/**
 * 2017��7��6��14:48:45
 * ����ͼ����Ľӿ�
 */
package library.dao;

import java.util.ArrayList;

import library.model.Book;
import library.model.Category;


public interface CategoryInterface {
	public ArrayList<Book> FindAll();
	public Category FindbyID(int id); // ͨ��ID����Category�����������
	public Category FindbyName(Category entity); // ͨ��name����Category�����������
	public int insert(Category entity);// ���һ��ʵ��
	public int delete(Category entity); //ɾ��
	public int update(Category entity); //�޸�
}
