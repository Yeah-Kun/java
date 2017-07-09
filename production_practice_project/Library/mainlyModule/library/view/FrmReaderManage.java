/**
 * 2017年7月9日19:51:49
 * 测试框架结构
 */
package library.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class FrmReaderManage {
	public static void main(String[] args) {
		JFrame f =  new JFrame("读者信息管理界面");
		f.setSize(800,600);  // 设置大小
		f.setLocation(800, 600);  
		f.setLocationRelativeTo(null);// 屏幕归中
		
		
		// 设置面板
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JTabbedPane jt = new JTabbedPane(); // 设置菜单面板
		jt.setTitleAt(0,"读者信息管理");
		jt.setTitleAt(1,"读者信息管理");
		f.setContentPane(jt);
		f.setVisible(true);
	}
	
}
