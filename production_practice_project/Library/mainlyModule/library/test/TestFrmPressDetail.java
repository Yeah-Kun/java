/*
 * 2017��7��4��16:34:55
 * �Ӵ�����ԣ��ȴ�������㣬�ٽ��������Ϣӳ�䵽�Ӵ���
 */
package library.test;

import library.server.PressServer;
import library.view.FrmPressDetail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestFrmPressDetail {
	FrmPressDetail Fpd = null;
	PressServer psi = null;
	
	// ����PressServer�����ȴ����������
	@Before
	public void init(){
		psi = new PressServer();  // ��������
		Fpd = new FrmPressDetail(); // �Ӵ������
		
	}
	
	@Test
	public void testFindbyID(){
		Fpd.setContent(psi.FindbyID(1).toString()); // ������ȡ��Ϣ���Ӵ���չʾ
		Assert.assertNotNull(Fpd);
	}
}
