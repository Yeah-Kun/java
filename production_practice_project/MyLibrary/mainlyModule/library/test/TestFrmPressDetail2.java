/*
 * 2017��7��5��11:13:11
 * 1. 
 */
package library.test;

import library.server.PressServer;
import library.view.FrmPressDetail;

public class TestFrmPressDetail2 {
	public static void main(String[] args) {
		FrmPressDetail Fpd = null;
		PressServer psi = null;
		psi = new PressServer();  // ��������
		Fpd = new FrmPressDetail(); // �Ӵ������
		Fpd.setContent(psi.FindbyID(1).toString()); // ������ȡ��Ϣ���Ӵ���չʾ
	}
}
