package com.library.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BookView {
	// 图书信息管理系统
	public JPanel JP() {
		JPanel jp = new JPanel(); // 总面板，下面有2块面板、一个表格
		JPanel jp1 = new JPanel(); // 面板1
		JPanel jp2 = new JPanel(); // 面板2

		// 以下为面板1内容
		JButton bsearch = new JButton("查找");// 按钮
		JButton breturn = new JButton("返回");
		
		// 查询方式复选框
		String[] search = new String[] { "ISBN", "书名" };
		JComboBox cb = new JComboBox(search);
		
		JLabel jl = new JLabel("查找方式：");// 查询提醒文本文字
		
		// 输入框
		JTextField jtf = new JTextField();
		jtf.setText("请输入信息");
		jtf.setPreferredSize(new Dimension(150, 30)); // 设置输入框大小
		
		jp1.add(jl);// 文本文字
		jp1.add(cb);// 复选框
		jp1.add(jtf);// 输入框
		jp1.add(bsearch);// 查询按钮
		jp1.add(breturn);// 返回按钮
		// 以下为面板2内容
		JButton binsert = new JButton("添加");// 添加按钮
		JButton bdelete = new JButton("删除");// 删除按钮
		JButton bupdate = new JButton("修改");// 修改按钮
		jp2.add(binsert);
		jp2.add(bupdate);
		jp2.add(bdelete);
		// 以下为表格内容
		String[] columnNames = new String[] { "ISBN", "书名", "出版社", "可借数量" };
		String[][] contant = new String[][] { { "117", "Java从入门到放弃", "和谐出版社", "50" },
				{ "129","计算机二级", "山西出版社", "10" }, { "123", "会计学导论", "北京出版社", "10" } };
		JTable t = new JTable(contant, columnNames);
		JScrollPane js = new JScrollPane(t);

		jp.setLayout(new BorderLayout());
		jp.add(jp1, BorderLayout.NORTH);
		jp.add(jp2, BorderLayout.CENTER);
		jp.add(js, BorderLayout.SOUTH);
		return jp;
	}

}
