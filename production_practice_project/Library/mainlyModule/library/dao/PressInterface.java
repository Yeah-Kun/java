/**
 * 2017��7��4��11:04:46
 * �����������Ľӿ�
 */
package library.dao;

import java.util.ArrayList;

import library.model.Press;

public interface PressInterface {
	public ArrayList<Press> FindAll();
	public Press FindbyID(int id); // ͨ��ID����press�����������
	public int insert(Press entity);// ���һ��ʵ�壬˳��Ϊ��name��adress��url��mail
	public int delete(Press enity); //ɾ��
	public int update(Press entity); //�޸�
	
}
