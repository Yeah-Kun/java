/**
 * 2017年7月10日14:23:35
 * 读者信息界面功能
 */
package com.library.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;

import com.library.dao.ReaderDaoImpl;
import com.library.model.Reader;
import com.library.service.AdminServiceImpl;
import com.library.service.ReaderServiceImpl;
import com.library.view.ReaderView.TableModel;

public class ReaderView extends JFrame {
	
	ReaderDaoImpl rdi = new ReaderDaoImpl();
	ArrayList<Reader> data = new ArrayList<Reader>();
	{
		data = rdi.findAll();
	}

	// 读者信息管理界面
	public Component JP() {
		final JPanel jp = new JPanel(); // 总面板，下面有2块面板、一个表格
		JPanel jp1 = new JPanel(); // 面板1
		JPanel jp2 = new JPanel(); // 面板2

		// 以下为面板1内容
		// 按钮
		JButton bsearch = new JButton("查找");
		JButton breturn = new JButton("返回");
		// 查询方式复选框
		String[] search = new String[] { "用户名", "姓名" };
		JComboBox cb = new JComboBox(search);
		// 查询提醒文本文字
		JLabel jl = new JLabel("查找方式：");
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

		

		final TableModel btm = new TableModel();// 表模型
		final JTable t = new JTable(btm);// 生成表控件　
		JScrollPane js = new JScrollPane(t);// 用表控件构建滚动面板

		jp.setLayout(new BorderLayout());
		jp.add(jp1, BorderLayout.NORTH);
		jp.add(jp2, BorderLayout.CENTER);
		jp.add(js, BorderLayout.SOUTH);
		
		// 查询按钮的监听
				binsert.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

					}
				});

				// 添加按钮的监听
				binsert.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RInAndUp p = new RInAndUp();
						t.updateUI();
					}
				});

				// 修改按钮的监听
				bupdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(jp, "修改失败！");
					}
				});

				// 删除按钮的监听
				bdelete.addActionListener(new ActionListener(){//添加事件
		            public void actionPerformed(ActionEvent e){
		                int selectedRow = t.getSelectedRow();//获得选中行的索引
		                System.out.println(selectedRow);
		                if(selectedRow!=-1)  //存在选中行
		                {
		                    
		                }
		            }
		        });
		return jp;
	}

	// 更新事件
	class ReaderUpdate implements ActionListener { // 添加按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			//调用服务层，先查找用户名
			ReaderServiceImpl rsi = new ReaderServiceImpl();  // 读者服务层，通过查name找人
			AdminServiceImpl asi = new AdminServiceImpl();
			Reader r = new Reader();
					JOptionPane.showMessageDialog(null,"添加成功","系统信息",JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// 删除事件
	class Readerdelete implements ActionListener { // 添加按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			// 调用服务层，先查找用户名,
			ReaderServiceImpl rsi = new ReaderServiceImpl();
			AdminServiceImpl asi = new AdminServiceImpl();

			JOptionPane.showMessageDialog(null, "添加成功", "系统信息",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// 查询弹窗
	public class RSearch extends JFrame{
		
	}

	// 添加和修改弹窗
	public class RInAndUp extends JFrame {
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();

		JLabel t1 = new JLabel("姓名:");
		JLabel t2 = new JLabel("用户名:");
		JLabel t3 = new JLabel("密码:");
		JLabel t4 = new JLabel("电话:");
		JLabel t5 = new JLabel("所在系:");
		JLabel t6 = new JLabel("借阅数量:");
		JTextField tf1 = new JTextField();
		JTextField tf2 = new JTextField();
		JTextField tf3 = new JTextField();
		JTextField tf4 = new JTextField();
		JTextField tf5 = new JTextField();
		JTextField tf6 = new JTextField();

		// 弹窗的构造方法
		RInAndUp() {

			p1.setLayout(new GridLayout(6, 2));
			p1.add(t1);
			p1.add(tf1);
			p1.add(t2);
			p1.add(tf2);
			p1.add(t3);
			p1.add(tf3);
			p1.add(t4);
			p1.add(tf4);
			p1.add(t5);
			p1.add(tf5);
			p1.add(t6);
			p1.add(tf6);

			JButton b = new JButton("确定");// 确定按钮
			JButton breturn = new JButton("取消");// 添加按钮
			p2.add(b);
			p2.add(breturn);

			b.addActionListener(new ReaderInsert());
			// 取消按钮事件
			breturn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			this.setLayout(new BorderLayout());
			this.add(p1);
			this.add(p2, BorderLayout.SOUTH);
			setVisible(true);

		}

		// 添加事件
		class ReaderInsert implements ActionListener { // 添加按钮的事件监听器
			public void actionPerformed(final ActionEvent e) {
				// 调用服务层，先查找用户名
				Reader r = new Reader();
				AdminServiceImpl asi = new AdminServiceImpl();
				// 将输入框信息添加到对象中
				r.setName(tf1.getText());
				r.setUserid(tf2.getText());
				r.setPassword(tf3.getText());
				r.setPhone(Integer.parseInt(tf4.getText())); // Int类型强制转换
				r.setDepart(tf5.getText());
				r.setAmount(Integer.parseInt(tf6.getText()));
				if (asi.ReaderInsert(r)) {
					JOptionPane.showMessageDialog(null, "添加成功", "系统信息",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "添加失败", "系统信息",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	// 设置表格模型，填充表格数据
	public class TableModel extends AbstractTableModel {
		

		@Override
		public int getRowCount() {
			return data.size();
		}

		public void removeRow(int selectedRow) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public int getColumnCount() {
			// 根据实际情况返回列数
			return 6;
		}

		@Override
		public String getColumnName(int column) {
			// 根据实际情况返回列名
			if (column == 0)
				return "姓名";
			else if (column == 1)
				return "用户名";
			else if (column == 2)
				return "密码";
			else if (column == 3)
				return "电话";
			else if (column == 4)
				return "所在系";
			else if (column == 5)
				return "借书数量";
			return null;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Reader entity = data.get(rowIndex);
			if (columnIndex == 0)
				return entity.getName();
			else if (columnIndex == 1)
				return entity.getUserid();
			else if (columnIndex == 2)
				return entity.getPassword();
			else if (columnIndex == 3)
				return entity.getPhone();
			else if (columnIndex == 4)
				return entity.getDepart();
			else if (columnIndex == 5)
				return entity.getAmount();
			return null;
		}


	}
}