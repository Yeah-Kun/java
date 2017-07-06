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

	@Override
	public int insert(Press eneity) {
		int re=0;
		String sql = "INSERT INTO Press(name,adress,url,mail) VALUES(?,?,?,?)"; // 使用SQL语句查询数据库
		try {
			// 访问数据库，增加一条完整的信息
			ps = conn.prepareStatement(sql); // 跟mysql建立连接
			ps.setString(1, eneity.getName());
			ps.setString(2, eneity.getAdress());
			ps.setString(3, eneity.getUrl());
			ps.setString(4, eneity.getMail());
			re = ps.executeUpdate(); // 将结果返回

		} catch (SQLException e) {
			System.out.println("数据库插入信息错误！");
		}
		return re;
	}

	public int delete(Press entity) {
		int re=0;
		String sql = "delete from press where id=?"; // 使用SQL语句查询数据库
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, entity.getId()); // 预处理
				re = ps.executeUpdate(); // 执行删除语句，返回结果
				if(re == 0){
					System.out.println("此ID不存在，请重新输入需要删除的信息");
				}
			} catch (SQLException e) {
				System.out.println("数据库删除失败，请检查原因！");
			} 
		return re;
	}

	public int update(Press entity) {
		int re=0;
		String sql = "update press set name = ?,adress = ?, url = ?, mail = ? where id = ? "; // 使用SQL语句查询数据库
		try {
			// 访问数据库，增加一条完整的信息
			if(entity == null){
				System.out.println("该ID信息不存在！");
			}
			else{
				ps = conn.prepareStatement(sql); // 跟mysql建立连接
				ps.setString(1, entity.getName());
				ps.setString(2, entity.getAdress());
				ps.setString(3, entity.getUrl());
				ps.setString(4, entity.getMail());
				ps.setInt(5, entity.getId());
				re = ps.executeUpdate(); // 执行，并将结果返回

			}
		} catch (SQLException e) {
			System.out.println("数据库插入信息错误！");
		}
		return re;	
	}

}
