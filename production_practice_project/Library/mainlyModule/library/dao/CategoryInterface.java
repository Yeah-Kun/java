/**
 * 2017年7月6日14:48:45
 * 定义图书类的接口
 */
package library.dao;

import java.util.ArrayList;

import library.model.Book;
import library.model.Category;


public interface CategoryInterface {
	public ArrayList<Book> FindAll();
	public Category FindbyID(int id); // 通过ID查找Category表里面的内容
	public Category FindbyName(Category entity); // 通过name查找Category表里面的内容
	public int insert(Category entity);// 添加一个实体
	public int delete(Category entity); //删除
	public int update(Category entity); //修改
}
