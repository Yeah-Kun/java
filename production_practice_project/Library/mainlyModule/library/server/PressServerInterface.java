/*
 * 2017��7��4��14:22:10
 * ����㣬����press����������Ϣ���ӿ�
 */
package library.server;

import java.util.ArrayList;

import library.model.Press;

public interface PressServerInterface {
	public ArrayList<Press> FindAll();
	public Press FindbyID(int id); 
	public boolean insert(Press entity);
	public boolean delete(Press entity);
	public boolean update(Press entity);
}
