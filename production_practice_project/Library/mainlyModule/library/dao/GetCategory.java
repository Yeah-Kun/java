/**
 * 2017年7月6日15:13:05
 * 图书类表的增删查改实现
 * 跟出版社表的实现方法一致
 */
package library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import library.model.Category;

public class GetCategory implements CategoryInterface{

	Connection conn = ConnectMySQL.getConnect();// 创建Connection对象
	ResultSet result = null; // 用来保存数据库的二维表信息
	PreparedStatement ps = null; // PreparedStatement对象，用于存储Connection对象返回的内容
	
	// 通过ID查找类名
	public Category FindbyID(int id) {
		Category cat= null; // 因为不知道id存不存在，所以不new
		String sql = "select * from Category where id=?"; // 使用sql语句查询数据库
		
		try {
			// 访问数据库 通过ID，获取一条数据
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			result = ps.executeQuery(); // 得到数据库信息，并保存到result
			
			// 执行以下语句，说明id存在
			// 将result的信息存储到Category对象里面
			if (result.next()){
				cat = new Category(); 
				
				// 将result的二维表内容放到Category对象里面
				cat.setId(result.getInt("id"));
				cat.setName(result.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return cat;
	}

	
	// 通过name查找类名
	public Category FindbyName(Category entity) {
		Category cat= null;
		String sql = "select * from Category where name=?";
		
		try {
			// 访问数据库，通过name查找数据库信息
			ps = conn.prepareStatement(sql);
			ps.setString(1, entity.getName());// 预处理
			result = ps.executeQuery(); // 执行，将结果返回
			
			if(result.next()){
				cat = new Category(); 
				
				// 将result的二维表内容放到Category对象里面
				cat.setId(result.getInt("id"));
				cat.setName(result.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return cat;
	}


	// 插入类名
	public int insert(Category entity) {
		int re=0;
		String sql = "INSERT INTO Category(name) VALUES(?)"; // 使用SQL语句查询数据库
		try {
			// 访问数据库，增加一条完整的信息
			ps = conn.prepareStatement(sql); // 跟mysql建立连接
			
			ps.setString(1, entity.getName());// 预处理
			re = ps.executeUpdate(); // 执行，将结果返回

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return re;
	
	}

	// 删除类名
	public int delete(Category entity) {
		int re=0;
		String sql = "delete from Category where id=?"; // 使用SQL语句查询数据库
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, entity.getId()); // 预处理
				re = ps.executeUpdate(); // 执行删除语句，返回结果
				if(re == 0){
					System.out.println("此ID不存在，请重新输入需要删除的信息");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		return re;
	}

	// 修改类名
	public int update(Category entity) {
		int re=0;
		String sql = "update Category set name = ? where id = ? "; // 使用SQL语句查询数据库
		try {
			// 访问数据库，增加一条完整的信息
			if(entity == null){
				System.out.println("该ID信息不存在！");
			}
			else{
				ps = conn.prepareStatement(sql); // 跟mysql建立连接
				
				// index = 占位符位置，x = 具体数据
				ps.setString(1, entity.getName());
				ps.setInt(2, entity.getId());
				re = ps.executeUpdate(); // 执行，并将结果返回
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return re;	
	}
	
}
