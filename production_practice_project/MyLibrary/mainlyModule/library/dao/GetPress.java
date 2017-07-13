/*
 * 2017年7月4日11:04:33
 * 从数据库提取出版社的基本数据
 * 1. 创建
 */
package library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import library.model.Press;

public class GetPress implements PressInterface {
	// 创建对象
	Connection conn = ConnectMySQL.getConnect();
	ResultSet result = null; // 用来保存数据库的二维表信息
	PreparedStatement ps = null;

	@Override
	public Press FindbyID(int id) {
		Press press = null;
		String sql = "select * from press where id=?";
		try {
			ps = conn.prepareStatement(sql); // 访问数据库
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
			System.out.println("数据库操作错误！");
		}

		return press;
	}

}
