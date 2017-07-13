/*
 * 2017年7月4日14:22:10
 * 服务层，定义press（出版社信息）接口
 */
package library.server;

import library.model.Press;

public interface PressInterfaceServer {
	public Press FindbyID(int id); 
}
