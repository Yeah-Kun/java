/**
 * 2017��7��6��14:17:11
 * �����ţ�չ��������Ϣ
 * 1. ����ID���ʷ���㣬��ȡ����
 * 2. ʹ��ս�߲�չʾ��Ϣ
 */
package library.view;

import java.util.Scanner;

import library.server.PressServer;

public class ShowPressDetail {
	
	public static void main(String[] args) {
		PressServer psi = new PressServer(); // ��һ�������������������ݿ�����
		FrmPressDetail fd = new FrmPressDetail(); // չʾ���������չʾ 
		System.out.print("������������ţ�");
		Scanner in = new Scanner(System.in);
		int id = in.nextInt();
		fd.setContent(psi.FindbyID(id).toString());
	}
}
