/**
 * 2017年7月6日15:16:27
 * 定义图书类的服务层接口
 */
package library.server;

import library.model.Category;

public interface CategoryServerInterface {
	public Category FindbyID(int id); 
	public boolean insert(Category entity);
	public boolean delete(Category entity);
	public boolean update(Category entity);
}
