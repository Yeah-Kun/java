/*
 * 2017��7��4��16:20:24
 * �Ӵ��㣬չ��press�ľ�������
 */
package library.view;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class FrmPressDetail extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7942088206583178197L;
	public FrmPressDetail(){
		this.setSize(400, 200);
		this.setTitle("��������ϸ��Ϣ");
	}
	public void setContent(String content){
		JTextArea jta = new JTextArea();
		jta.setText(content);
		this.add(jta);
		this.setVisible(true);
	}
}
