/*
 * 2017年7月4日11:04:46
 * 定义接口
 */
package library.dao;

import library.model.Press;

public interface PressInterface {
	public  Press FindbyID(int id); // 通过ID查找press表里面的内容

}
