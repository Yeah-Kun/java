/*
 * 2017年7月4日9:41:35
 * 测试代码
 * 测试配置mysql的驱动器和连接
 */
package library.test;

import java.sql.Connection;

import library.dao.ConnectMySQL;

public class TestConnection {
	public static void main(String[] args) {
		Connection flag = null;
		flag = ConnectMySQL.getConnect();
		System.out.println(flag);
	}
}
