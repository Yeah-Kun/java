/*
 * 2017��7��4��9:41:35
 * ���Դ���
 * ��������mysql��������������
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
