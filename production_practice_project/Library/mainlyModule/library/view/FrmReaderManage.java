/**
 * 2017年7月9日22:51:38
 * 测试JFrame效果
 */
package library.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class FrmReaderManage {
	public static void main(String[] args) {
		JFrame f =  new JFrame("系统管理员");
		f.setSize(800,600);  // 设置窗口大小
		f.setLocation(800, 600);  
		f.setLocationRelativeTo(null);// 窗口归中
		
		
		// 
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JTabbedPane jt = new JTabbedPane(); // 
		jt.setTitleAt(0,"读者信息管理");
		jt.setTitleAt(1,"图书信息管理");
		f.setContentPane(jt);
		f.setVisible(true);
	}
	
}
