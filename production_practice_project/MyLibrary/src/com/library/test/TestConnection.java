/**
 * 2017年7月10日20:37:32
 * 测试连接数据库
 */
package com.library.test;

import java.sql.Connection;

import com.library.dao.BUtil;



public class TestConnection {
	public static void main(String[] args) {
		Connection flag = null;
		flag = BUtil.getConnection();
		System.out.println(flag);
	}
}
