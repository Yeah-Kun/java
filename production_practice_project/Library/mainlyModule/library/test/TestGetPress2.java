/*
 * 2017��7��6��9:33:22
 * ���ԣ���Press�������ɾ���
 */
package library.test;

import library.dao.GetPress;
import library.model.Press;

public class TestGetPress2 {
	// / /������ӣ����´������ʹ��
	// public static void main(String[] args) {
	// int re;
	// Press press = new Press();
	// GetPress getpress = new GetPress();
	// press.setAdress("����");
	// press.setMail("68465@qq.com");
	// press.setName("SBH48");
	// press.setUrl("www.wyu.com");
	// re = getpress.insert(press);
	// System.out.println(re);
	// }
	
	// ����ɾ�������´������ʹ��
	public static void main(String[] args) {
		int id = 4, re = 0;
		Press press = new Press();
		GetPress getpress = new GetPress();
		press.setId(id);
		re = getpress.delete(press);
		System.out.println(re);
	}
}
