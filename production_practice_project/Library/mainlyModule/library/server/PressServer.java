/*
 * 2017��7��4��14:27:47
 * ����㣬���ʳ־ò㣬���press��Ϣ������press��Ϣ
 */
package library.server;

import library.dao.GetPress;
import library.model.Press;

public class PressServer implements PressInterfaceServer{
	GetPress gp = new GetPress(); // �����־ò��press�������ڷ�����ȡ��Ϣ

	@Override
	public Press FindbyID(int id) {
		return gp.FindbyID(id);
	}
	
}
