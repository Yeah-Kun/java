/**
 * 2017��7��4��14:27:47
 * ����㣬���ʳ־ò㣬���press��Ϣ������press��Ϣ
 */
package library.server;

import library.dao.GetPress;
import library.model.Press;

public class PressServer implements PressServerInterface {
	GetPress gp = new GetPress(); // �����־ò��press�������ڷ�����ȡ��Ϣ

	@Override
	public Press FindbyID(int id) {
		return gp.FindbyID(id);
	}

	@Override
	public boolean insert(Press entity) {
		return gp.insert(entity) > 0 ? true : false; // ����3Ŀ�����
	}

	@Override
	public boolean delete(Press entity) {
		return gp.delete(entity) > 0 ? true : false;
	}

	@Override
	public boolean update(Press entity) {
		return gp.update(entity) > 0 ? true : false;
	}

}
