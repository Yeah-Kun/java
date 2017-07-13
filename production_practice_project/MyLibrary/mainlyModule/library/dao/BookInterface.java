/**
 * 2017年7月8日10:03:23
 * 定义图书类的接口
 */
package library.dao;

import java.util.ArrayList;

import library.model.Book;

public interface BookInterface {
	public ArrayList<Book> FindAll(); // 查找所有图书的信息
	public Book FindbyID(int id); // 通过ID查找press表里面的内容
	public int insert(Book entity);// 添加一个实体，顺序为：name、adress、url、mail
	public int delete(Book enity); //删除
	public int update(Book entity); //修改
	
}
