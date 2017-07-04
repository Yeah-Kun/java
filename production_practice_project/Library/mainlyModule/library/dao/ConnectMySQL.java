/*
 * 2017年7月4日9:19:46
 * Drivermanager
 * 1. 配置mysql的驱动器
 * 2. 连接mysql
 */
package library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class ConnectMySQL {
	public static Connection getConnect(){
		Connection flag = null;
		try {
			// 1. 配置mysql的驱动器
			Class.forName("com.mysql.jdbc.Driver"); 
			// 2. 连接mysql
			String url = "jdbc:mysql://localhost:3306/library";
			String user = "root";
			String password = "123456";
			flag = DriverManager.getConnection(url, user, password);			
		} catch (ClassNotFoundException e) {
			System.out.println("驱动器配置失败，请检查配置");
		} catch (SQLException e) {
			System.out.println("连接失败！请确定重新连接！");
		}
		return flag;
	}
}
