/**
 * 2017年7月6日15:21:40
 * 服务层，访问持久层，获得Category信息，返回Category信息
 */
package library.server;

import library.dao.GetCategory;
import library.model.Category;

public class CategoryServer implements CategoryServerInterface{
	GetCategory gs = new GetCategory();
	
	public Category FindbyID(int id) {
		return gs.FindbyID(id);
	}


	public boolean insert(Category entity) {
		return gs.insert(entity) > 0 ? true : false; // 运用3目运算符
	}


	public boolean delete(Category entity) {
		return gs.delete(entity) > 0 ? true : false;
	}


	public boolean update(Category entity) {
		return gs.update(entity) > 0 ? true : false;
	}
	
}
