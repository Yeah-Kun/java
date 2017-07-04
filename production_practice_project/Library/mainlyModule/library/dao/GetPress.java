/*
 * 2017年7月4日11:04:33
 * 从数据库提取出版社的基本数据
 * 1. 使用Connection对象连接mysql
 * 2. Connection对象通过sql语句访问数据库，获取数据，返回PreparedStatement对象
 * 3. 使用executeQuery方法解析PreparedStatement对象，将得到的二维表数据存储到result
 * 4. 将result的二维表数据转存到press对象（调用press的set方法）
 */
package library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import library.model.Press;

public class GetPress implements PressInterface {
	
	Connection conn = ConnectMySQL.getConnect();// 创建Connection对象
	ResultSet result = null; // 用来保存数据库的二维表信息
	PreparedStatement ps = null; // PreparedStatement对象，用于存储Connection对象返回的内容

	@Override
	public Press FindbyID(int id) {
		Press press = null;
		String sql = "select * from press where id=?"; // 使用sql语句查询数据库
		try {
			// 访问数据库 通过ID，获取一条数据
			ps = conn.prepareStatement(sql); 
			ps.setInt(1, id);
			
			result = ps.executeQuery(); // 得到数据库信息，并保存到result
			if (result.next()) {
				press = new Press();// 创建press对象，用于保存读取到的数据库数据

				// 将result的二维表内容放到press对象里面
				press.setId(result.getInt("id")); // 从result中获取id
				press.setAdress(result.getString("adress"));
				press.setMail(result.getString("mail"));
				press.setName(result.getString("name"));
				press.setUrl(result.getString("url"));
			}
		} catch (SQLException e) {
			System.out.println("数据库提取信息错误！");
		}

		return press;
	}

}
