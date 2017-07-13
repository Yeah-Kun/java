/*
 * 2017年7月4日14:27:47
 * 服务层，访问持久层，获得press信息，返回press信息
 */
package library.server;

import library.dao.GetPress;
import library.model.Press;

public class PressServer implements PressInterfaceServer{
	GetPress gp = new GetPress(); // 建立持久层的press对象，用于服务层读取信息

	@Override
	public Press FindbyID(int id) {
		return gp.FindbyID(id);
	}
	
}
