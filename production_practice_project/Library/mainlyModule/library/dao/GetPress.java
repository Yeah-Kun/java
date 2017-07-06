/**
 * 2017年7月4日11:04:33
 * 实现出版社类表的增删查改
 * 具体实现过程：
 * 1. 使用Connection对象连接mysql
 * 2. Connection对象通过sql语句访问数据库，获取数据，返回PreparedStatement对象
 * 3. 使用executeQuery方法解析PreparedStatement对象，将得到的二维表数据存储到result
 * 4. 将result的二维表数据转存到press对象（调用press的set方法）
 * 5. 对press对象进行操作
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

	// 通过ID查找出版社信息
	public Press FindbyID(int id) {
		Press press = null;
		String sql = "select * from press where id=?"; // 使用sql语句查询数据库
		try {
			// 访问数据库 通过ID，获取一条数据
			ps = conn.prepareStatement(sql); 
			ps.setInt(1, id);
			
			result = ps.executeQuery(); // 得到数据库信息，并保存到result
			
			// 执行以下语句，说明id存在
			// 将result的信息存储到press对象里面
			if (result.next()) {
				press = new Press();

				// 将result的二维表内容放到press对象里面
				press.setId(result.getInt("id")); // 从result中获取id
				press.setAdress(result.getString("adress"));
				press.setMail(result.getString("mail"));
				press.setName(result.getString("name"));
				press.setUrl(result.getString("url"));
			}
		} catch (SQLException e) {
			//System.out.println("数据库提取信息错误！");
			e.printStackTrace();
		}

		return press; // 如果获取失败则为null
	}

	// 增加出版社信息
	public int insert(Press entity) {
		int re=0;
		String sql = "INSERT INTO Press(name,adress,url,mail) VALUES(?,?,?,?)"; // 使用SQL语句查询数据库
		try {
			// 访问数据库，增加一条完整的信息
			ps = conn.prepareStatement(sql); // 跟mysql建立连接
			ps.setString(1, entity.getName());
			ps.setString(2, entity.getAdress());
			ps.setString(3, entity.getUrl());
			ps.setString(4, entity.getMail());
			re = ps.executeUpdate(); // 执行，将结果返回

		} catch (SQLException e) {
			// System.out.println("数据库插入信息错误！");
			e.printStackTrace();
		}
		return re;
	}

	// 删除出版社信息
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
				// System.out.println("数据库删除失败，请检查原因！");
				e.printStackTrace();
			} 
		return re;
	}

	// 修改出版社信息
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
				// index = 占位符位置，x = 具体数据
				ps.setString(1, entity.getName());
				ps.setString(2, entity.getAdress());
				ps.setString(3, entity.getUrl());
				ps.setString(4, entity.getMail());
				ps.setInt(5, entity.getId());
				re = ps.executeUpdate(); // 执行，并将结果返回

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return re;	
	}

}
