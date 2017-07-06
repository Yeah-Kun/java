/**
 * 2017��7��6��15:21:40
 * ����㣬���ʳ־ò㣬���Category��Ϣ������Category��Ϣ
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
		return gs.insert(entity) > 0 ? true : false; // ����3Ŀ�����
	}


	public boolean delete(Category entity) {
		return gs.delete(entity) > 0 ? true : false;
	}


	public boolean update(Category entity) {
		return gs.update(entity) > 0 ? true : false;
	}
	
}
