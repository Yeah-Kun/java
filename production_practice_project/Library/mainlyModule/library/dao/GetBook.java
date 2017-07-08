/**
 * 2017年7月8日10:10:00
 * 
 */
package library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import library.model.Book;

public class GetBook implements BookInterface{
	
	Connection conn = ConnectMySQL.getConnect();// 创建Connection对象
	ResultSet result = null; // 用来保存数据库的二维表信息
	PreparedStatement ps = null; // PreparedStatement对象，用于存储Connection对象返回的内容
	Book book = null;
	
	public ArrayList<Book> FindAll(){ // 由于查找到的图书信息可能不止一条，所以用一个列表存储
		ArrayList<Book> bookList = new ArrayList<>();
		Book book = null;
		GetCategory gc = null;
		GetPress gp = null;
		
		String sql = "select * from book";
		try {
			ps = conn.prepareStatement(sql);
			result = ps.executeQuery();
			while(result.next()){
				book = new Book();
				gp = new GetPress();
				gc = new GetCategory();
				book.setId(result.getInt("id"));
				book.setName(result.getString("name"));
				book.setISBN(result.getString("ISBN"));
				book.setPrice(result.getDouble("price"));
				book.setPress(gp.FindbyID(result.getInt("pressID")));
				book.setCategory(gc.FindbyID(result.getInt("categoryID")));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}
	@Override
	public Book FindbyID(int id) {

		return null;
	}

	@Override
	public int insert(Book entity) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int delete(Book enity) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int update(Book entity) {
		// TODO 自动生成的方法存根
		return 0;
	}
	
}
