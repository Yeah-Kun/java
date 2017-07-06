/*
 * 2017年7月4日15:18:21
 * 测试press表的增删查改
 */
package library.test;

import library.model.Press;
import library.server.PressServer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestGetPress {
	// public static void main(String[] args) {
	// GetPress psi = new GetPress();
	// Press p = psi.FindbyID(1);
	// System.out.println(p.toString());
	// }
	PressServer psi = null;

	// 测试PressServer对象，先创建这个对象
	@Before
	public void init() {
		psi = new PressServer(); // 用于测试FindbyID
	}

//	@Test
	// 测试FindbyID
	public void testFindbyID() {
		Assert.assertNotNull(psi.FindbyID(1));
		Assert.assertEquals("人民教育出版社", psi.FindbyID(1).getName());
	}
//	@Test
	// 测试insert
	public void testinsert() {
		Press press = new Press();
		press.setAdress("广州");
		press.setMail("68465@qq.com");
		press.setName("SBH48");
		press.setUrl("www.wyu.com");
		Assert.assertTrue(psi.insert(press));
	}
	
	@Test
	//测试delete
	public void testdelete() {
		int id =2;
		boolean re = false;
		Press press = new Press();
		press.setId(id);
		re = psi.delete(press);
		Assert.assertTrue(re);
	}
}
