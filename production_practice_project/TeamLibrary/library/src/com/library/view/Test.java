package com.library.view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Test extends JFrame {
	public static void main(String[] args) {
		Test t = new Test();
	}
	public Test() {// 构造函数
		CountingView cv=new CountingView();
		JTabbedPane jtp = new JTabbedPane();
		JFrame jp = new JFrame();
	
		ReaderView rm = new ReaderView();
		BookView bm = new BookView();
		jtp.add("读者信息管理界面",rm.JP());
		jtp.add("图书信息管理界面",bm.JP());
		jtp.add("统计信息",cv);

//		this.add(rm.rInAndUp("添加"));
		this.add(jtp);
		this.setTitle("管理员界面");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		// 显示窗口true
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
