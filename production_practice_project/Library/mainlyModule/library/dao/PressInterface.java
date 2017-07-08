/**
 * 2017年7月4日11:04:46
 * 定义出版社类的接口
 */
package library.dao;

import java.util.ArrayList;

import library.model.Press;

public interface PressInterface {
	public ArrayList<Press> FindAll();
	public Press FindbyID(int id); // 通过ID查找press表里面的内容
	public int insert(Press entity);// 添加一个实体，顺序为：name、adress、url、mail
	public int delete(Press enity); //删除
	public int update(Press entity); //修改
	
}
