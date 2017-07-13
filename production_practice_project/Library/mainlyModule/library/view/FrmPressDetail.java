/*
 * 2017年7月4日16:20:24
 * 视窗层，展现press的具体数据
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
		this.setTitle("出版社详细信息");
	}
	public void setContent(String content){
		JTextArea jta = new JTextArea();
		jta.setText(content);
		this.add(jta);
		this.setVisible(true);
	}
}
