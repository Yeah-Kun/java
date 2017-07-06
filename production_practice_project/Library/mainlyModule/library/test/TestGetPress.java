/*
 * 2017��7��4��15:18:21
 * ����press�����ɾ���
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
	//����delete
	public void testdelete() {
		int id =3;
		boolean re = false;
		Press press = new Press();
		press.setId(id);
		re = psi.delete(press);
		Assert.assertTrue(re);
	}
	
	//@Test
	//����update
	public void testupdate() {
		int id =3;
		boolean re = false;
		Press press = new Press();
		PressServer getpress = new PressServer();
		press = getpress.FindbyID(id);
		if(press == null){
			System.out.println("��ID�����ڣ�");
		}
		else{
			press.setName("����������");
			re = getpress.update(press);
		}
		Assert.assertTrue(re);
	}
}
