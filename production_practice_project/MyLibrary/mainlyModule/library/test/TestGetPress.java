/*
 * 2017��7��4��15:18:21
 * ����press�����
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
	
	// ����PressServer�����ȴ����������
	@Before
	public void init(){
		psi = new PressServer();
	}
	
	@Test
	public void testFindbyID(){
		Assert.assertNotNull(psi.FindbyID(1));
		Assert.assertEquals("�������������", psi.FindbyID(1).getName());
	}
}
