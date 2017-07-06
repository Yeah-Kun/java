/**
 * 2017年7月4日16:20:24
 * 视窗层，展现press的具体数据
 * 1. 调用GUI容器：JFrame
 * 2. 设置窗口基本信息（大小、标题、窗口是否可见、窗口信息框）
 * 3. 展现内容
 */
package library.view;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class FrmPressDetail extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7942088206583178197L;// 每个电脑都不一样，记得修改
	public FrmPressDetail(){
		this.setSize(400, 200); // 设置窗口大小
		this.setTitle("出版社详细信息");
	}
	public void setContent(String content){
		JTextArea jta = new JTextArea();// 创建文本区对象
		jta.setText(content); 
		this.add(jta);
		this.setVisible(true); // 设置窗口是否可见
	}
}
