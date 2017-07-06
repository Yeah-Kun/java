/**
 * 2017��7��6��15:16:27
 * ����ͼ����ķ����ӿ�
 */
package library.server;

import library.model.Category;

public interface CategoryServerInterface {
	public Category FindbyID(int id); 
	public boolean insert(Category entity);
	public boolean delete(Category entity);
	public boolean update(Category entity);
}
