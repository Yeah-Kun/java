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
import library.model.Press;

public class GetBook implements BookInterface{
	
	Connection conn = ConnectMySQL.getConnect();// 创建Connection对象
	ResultSet result = null; // 用来保存数据库的二维表信息
	PreparedStatement ps = null; // PreparedStatement对象，用于存储Connection对象返回的内容
	Book book = null;
	GetCategory gc = null;
	GetPress gp = null;
	
	public ArrayList<Book> FindAll(){ // 由于查找到的图书信息可能不止一条，所以用一个列表存储
		ArrayList<Book> bookList = new ArrayList<>();

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
		Book book = null;
		String sql = "select * from book where id=?"; // 使用sql语句查询数据库
		try {
			// 访问数据库 通过ID，获取一条数据
			ps = conn.prepareStatement(sql); 
			ps.setInt(1, id);
			
			result = ps.executeQuery(); // 得到数据库信息，并保存到result
			
			// 执行以下语句，说明id存在
			// 将result的信息存储到book对象里面
			if (result.next()) {
				book = new Book();
				gp = new GetPress();
				gc = new GetCategory();
				// 将result的二维表内容放到press对象里面
				book.setId(result.getInt("id")); // 从result中获取id
				book.setISBN(result.getString("ISBN"));
				book.setName(result.getString("name"));
				book.setPrice(result.getDouble("price"));
				book.setPress(gp.FindbyID(result.getInt("pressID")));
				book.setCategory(gc.FindbyID(result.getInt("categoryID")));
			}
		} catch (SQLException e) {
			//System.out.println("数据库提取信息错误！");
			e.printStackTrace();
		}

		return book; // 如果获取失败则为null

	}

	@Override
	public int insert(Book entity) {
		int re=0;
		String sql = "INSERT INTO Press(name,ISBN,price,pressID,categoryID) VALUES(?,?,?,?,?)"; // 使用SQL语句查询数据库
		try {
			// 访问数据库，增加一条完整的信息
			ps = conn.prepareStatement(sql); // 跟mysql建立连接
			ps.setString(1, entity.getName());
			ps.setString(2, entity.getISBN());
			ps.setDouble(3, entity.getPrice());
			ps.setString(4, entity.getPress());
			re = ps.executeUpdate(); // 执行，将结果返回

		} catch (SQLException e) {
			// System.out.println("数据库插入信息错误！");
			e.printStackTrace();
		}
		return re;
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
