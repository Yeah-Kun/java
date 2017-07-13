/*
 * 2017年7月4日14:22:10
 * 服务层，定义press（出版社信息）接口
 */
package library.server;

import java.util.ArrayList;

import library.model.Press;

public interface PressServerInterface {
	public ArrayList<Press> FindAll();
	public Press FindbyID(int id); 
	public boolean insert(Press entity);
	public boolean delete(Press entity);
	public boolean update(Press entity);
}
