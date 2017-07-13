/*
 * 2017年7月4日15:18:21
 * 测试press的输出
 */
package library.test;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import library.server.PressServer;

public class TestGetPress {
//	public static void main(String[] args) {
//		GetPress psi = new GetPress();
//		Press p = psi.FindbyID(1);
//		System.out.println(p.toString());
//	}
	PressServer psi = null;
	
	// 测试PressServer对象，先创建这个对象
	@Before
	public void init(){
		psi = new PressServer();
	}
	
	@Test
	public void testFindbyID(){
		Assert.assertNotNull(psi.FindbyID(1));
		Assert.assertEquals("人民教育出版社", psi.FindbyID(1).getName());
	}
}
