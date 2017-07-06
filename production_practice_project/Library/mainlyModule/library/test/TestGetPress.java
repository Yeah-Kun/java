/*
 * 2017��7��4��15:18:21
 * ����press�����
 */
package library.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import library.model.Press;
import library.server.PressServer;

public class TestGetPress {
	// public static void main(String[] args) {
	// GetPress psi = new GetPress();
	// Press p = psi.FindbyID(1);
	// System.out.println(p.toString());
	// }
	PressServer psi = null;

	// ����PressServer�����ȴ����������
	@Before
	public void init() {
		psi = new PressServer(); // ���ڲ���FindbyID
	}

//	@Test
	// ����FindbyID
	public void testFindbyID() {
		Assert.assertNotNull(psi.FindbyID(1));
		Assert.assertEquals("�������������", psi.FindbyID(1).getName());
	}
//	@Test
	// ����insert
	public void testinsert() {
		Press press = new Press();
		press.setAdress("����");
		press.setMail("68465@qq.com");
		press.setName("SBH48");
		press.setUrl("www.wyu.com");
		Assert.assertTrue(psi.insert(press));
	}
	
	@Test
	public void testdelete() {
		int id =5;
		boolean re = false;
		Press press = new Press();
		press.setId(id);
		re = psi.delete(press);
		Assert.assertTrue(re);
	}
}
