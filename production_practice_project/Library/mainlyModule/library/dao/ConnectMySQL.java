/*
 * 2017��7��4��9:19:46
 * Drivermanager
 * 1. ����mysql��������
 * 2. ����mysql
 */
package library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class ConnectMySQL {
	public static Connection getConnect(){
		Connection flag = null;
		try {
			// 1. ����mysql��������
			Class.forName("com.mysql.jdbc.Driver"); 
			// 2. ����mysql
			String url = "jdbc:mysql://localhost:3306/library";
			String user = "root";
			String password = "123456";
			flag = DriverManager.getConnection(url, user, password);			
		} catch (ClassNotFoundException e) {
			System.out.println("����������ʧ�ܣ���������");
		} catch (SQLException e) {
			System.out.println("����ʧ�ܣ���ȷ���������ӣ�");
		}
		return flag;
	}
}
