/*
 * 2017��7��4��16:20:24
 * �Ӵ��㣬չ��press�ľ�������
 * 1. ����GUI������JFrame
 * 2. ���ô��ڻ�����Ϣ����С�����⡢�����Ƿ�ɼ���������Ϣ��
 * 3. չ������
 * 	3.1 
 */
package library.view;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class FrmPressDetail extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7942088206583178197L;// ÿ�����Զ���һ�����ǵ��޸�
	public FrmPressDetail(){
		this.setSize(400, 200); // ���ô��ڴ�С
		this.setTitle("��������ϸ��Ϣ");
	}
	public void setContent(String content){
		JTextArea jta = new JTextArea();// �����ı�������
		jta.setText(content); 
		this.add(jta);
		this.setVisible(true); // ���ô����Ƿ�ɼ�
	}
}
