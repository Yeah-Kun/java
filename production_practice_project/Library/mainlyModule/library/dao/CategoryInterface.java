/**
 * 2017��7��6��14:48:45
 * ����ͼ����Ľӿ�
 */
package library.dao;

import library.model.Category;


public interface CategoryInterface {
	public Category FindbyID(int id); // ͨ��ID����Category�����������
	public int insert(Category entity);// ���һ��ʵ��
	public int delete(Category entity); //ɾ��
	public abstract int update(Category entity); //�޸�
}
