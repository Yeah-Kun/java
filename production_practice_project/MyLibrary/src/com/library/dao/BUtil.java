package com.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BUtil {
	public static Connection getConnection() {
		Connection conn = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("配置mysql服务器失败！");
				e.printStackTrace();
			}
			String url = "jdbc:mysql://119.29.28.136:3306/library";
			String user = "library";
			String password = "123456";
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				System.out.println("连接失败！");
				e.printStackTrace();
			}
		return conn;
	}

}
