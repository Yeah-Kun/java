/**
 * 2017年7月6日15:21:40
 * 服务层，访问持久层，获得Category信息，返回Category信息
 */
package library.server;

import library.dao.GetCategory;
import library.model.Category;

public class CategoryServer implements CategoryServerInterface {
	GetCategory gs = new GetCategory();

	// 通过ID查找数据，返回数据，如果查找不到，则返回null
	public Category FindbyID(int id) {
		return gs.FindbyID(id);
	}

	// 通过name查找数据，返回数据，如果查找不到，则返回null
	public Category FindbyName(Category entity) {
		return gs.FindbyName(entity);
	}

	// 增加数据，成功为真，失败为假
	public boolean insert(Category entity) {
		if (gs.FindbyName(entity) == null) {
			return gs.insert(entity) > 0 ? true : false;
		} else {
			return true;
		}
	}

	// 删除
	public boolean delete(Category entity) {
		return gs.delete(entity) > 0 ? true : false;
	}

	// 修改
	public boolean update(Category entity) {
		return gs.update(entity) > 0 ? true : false;
	}

}
