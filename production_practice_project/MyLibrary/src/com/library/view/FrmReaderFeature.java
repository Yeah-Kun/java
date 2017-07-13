package com.library.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;

import com.library.dao.BookDaoImpl;
import com.library.dao.JieYueDaoImpl;
import com.library.model.Book;
import com.library.model.Borrow;
import com.library.model.JieYue;
import com.library.model.Reader;

public class FrmReaderFeature extends JFrame implements MouseListener {// 继承JFrame操作ActionListener接口
	JTabbedPane jtp = new JTabbedPane();
	JTable table;
	Reader entity = new Reader();{entity.setName("庄仕鹏");}
	Borrow bor = null;
	Book book = null;
	

	public static void main(String[] args) {
		new FrmReaderFeature();
	}

	public FrmReaderFeature() {// 构造函数
		jtp.addTab("借阅功能", FrmTab1()); // 将FrmTab1的内容放在选项卡中
		jtp.addTab("查询功能", FrmTab2()); // 将FrmTab2的内容放在选项卡中
		this.add(jtp);
		this.setTitle("读者功能选择");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null); // 窗口居中
		
		// 显示窗口true
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private Component FrmTab2() { // 查询功能
		JPanel tab = new JPanel();
		JPanel tab1 = new JPanel();
		JPanel tab2 = new JPanel();
		tab.setLayout(new BorderLayout());// 设置为边界布局
		tab1.setLayout(new FlowLayout());// 设置为顺序布局
		tab2.setLayout(new FlowLayout());// 设置为顺序布局

		// 向面板tab1中添加组件，并放置在tab的上方
		JLabel l = new JLabel("查找方式：");// 设置标签
		JLabel l1 = new JLabel("查找内容：");// 设置标签
		String[] list = new String[] { "图书编号", "图书名称" };
		final JComboBox co = new JComboBox(list); // 设置下拉框
		JTextField tf = new JTextField(""); // 设置输入文本框
		tf.setText("请输入查找内容");
		tf.setPreferredSize(new Dimension(100, 27)); // 设置文本框的大小
		JButton b1 = new JButton("搜索");
		tab1.add(l);
		tab1.add(co);
		tab1.add(l1);
		tab1.add(tf);
		tab1.add(b1); // 将查找方式，查找的内容放进面板1中
		tab.add(tab1, BorderLayout.NORTH);

		// 向面板tab1添加表格组件，放置在tab面板的中间
		/*String[] columnNames = new String[] { "图书编号", "图书名称", "出版社", "剩余数量" };// 设置表格标题
		String[][] ctable = new String[][] {};// 表格内容
		JTable t = new JTable(ctable, columnNames); // 创建表*/
		// 根据t创建 JScrollPane
		TableModel2 btm = new TableModel2();
		final JTable t1 = new JTable(btm);
		JScrollPane sp = new JScrollPane(t1);// 滚动表格
		tab.add(sp);

		// 向面板tab2添加借书、返回按钮，放置在面板tab最下方
		JButton b2 = new JButton("借书");
		JButton b3 = new JButton("返回");
		tab2.add(b2);
		tab2.add(b3);
		tab.add(tab2, BorderLayout.SOUTH);

		b1.addActionListener(new ActionListener() { // 给按钮搜索增加监听
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		b2.addActionListener(new ActionListener() { // 给按钮搜索增加监听
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(jtp, "借书成功！");
			}
		});
		b3.addActionListener(new ActionListener() { // 给按钮搜索增加监听
			public void actionPerformed(ActionEvent e) {
				// JOptionPane.showMessageDialog(jtp, "搜索成功！");
				jtp.setVisible(true);
			}
		});

		// item add listener

		co.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (ItemEvent.SELECTED == e.getStateChange()) {
					System.out.println("选择的值：" + co.getSelectedItem());
				}

			}
		});
		
		
		return tab;
	}

	private Component FrmTab1() {// 选项卡借阅功能的内容
		JPanel tab = new JPanel();// 创建面板
		tab.setLayout(new BorderLayout());// 设置为边界布局
		
		JPanel tab2 = new JPanel();// 创建面板
		tab2.setLayout(new BorderLayout());// 设置为边界布局
		JLabel l = new JLabel("借阅记录", SwingConstants.CENTER);// 设置标签，并放中间
		JLabel l1 = new JLabel("欢迎你！"+entity.getName(), SwingConstants.LEFT);// 设置标签，并放左边
		l.setFont(new java.awt.Font("Swing", 1, 20));// 设置字体为粗体，20号大小
		tab2.add(l1, BorderLayout.WEST );// 将标签放在面板最上方
		tab2.add(l);// 将标签放在面板最上方
		tab.add(tab2,BorderLayout.NORTH);
		

		//String[] columnNames = new String[] { "图书编号", "图书名称", "出版社", "借书日期",
				//"应还日期" };// 设置表格标题
		//String[][] heros = new String[][];// 表格内容
		//JTable t = new JTable(heros, columnNames); // 创建表
		// 根据t创建 JScrollPane
		TableModel btm = new TableModel();
		final JTable t1 = new JTable(btm);
		JScrollPane sp = new JScrollPane(t1);// 滚动表格
		tab.add(sp);
		

		JPanel tab1 = new JPanel(); // 创建面板，添加续借、返回按钮，将面板放在最下方
		JButton b1 = new JButton("续借");
		JButton b2 = new JButton("返回");
		tab1.add(b1, BorderLayout.WEST);
		tab1.add(b2, BorderLayout.EAST);
		tab.add(tab1, BorderLayout.SOUTH);
		// 给按钮 增加 监听
		class ReaderInsert implements ActionListener { // 添加按钮的事件监听器
			public void actionPerformed(final ActionEvent e) {
				//调用服务层，先查找用户名
				JieYueDaoImpl asi = new JieYueDaoImpl();
				// 将输入框信息添加到对象中
				int row = t1.getSelectedRow();
				Date db = (Date) t1.getValueAt(row, 5);
				int i = (int) t1.getValueAt(row, 1);
				Calendar rightNow = Calendar.getInstance();
				rightNow.setTime(db);//使用给定的 Date 设置此 Calendar 的时间。 
				rightNow.add(Calendar.MONTH, -2);// 日期减2个月
				Date dt1 = (Date) rightNow.getTime();//返回一个表示此 Calendar 时间值的 Date 对象。
				asi.findByBookISBN(i).getJborrow().setReptime(dt1);
				JOptionPane.showMessageDialog(null,"续借成功","系统信息",JOptionPane.INFORMATION_MESSAGE);
				/*if(asi.ReaderInsert(r)){
					JOptionPane.showMessageDialog(null,"添加成功","系统信息",JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null,"添加失败","系统信息",JOptionPane.ERROR_MESSAGE);
				}	*/
			}
		}
		
		b1.addActionListener(new ActionListener() { // 给按钮搜索增加监听
			//new ReaderInsert();
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(jtp, "借书成功！");
			}
		});

		return tab;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		int col = table.getSelectedColumn();
		Object value = table.getValueAt(row, col);
		JOptionPane.showMessageDialog(null, value);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	public class TableModel extends AbstractTableModel {
		JieYueDaoImpl rdi = new JieYueDaoImpl();
		ArrayList<JieYue> data = new ArrayList<JieYue>();{
			data = rdi.findByName(entity.getName());
		}
		
		@Override
		public int getRowCount() {
			return data.size();
		}

		@Override
		public int getColumnCount() {
			// 根据实际情况返回列数
			return 5;
		}
		
		@Override
		public String getColumnName(int column) {
			// 根据实际情况返回列名
			if (column == 0)
				return "图书编号";
			else if (column == 1)
				return "图书名称";
			else if (column == 2)
				return "出版社";
			else if (column == 3)
				return "借书日期";
			else if (column == 4)
				return "应还日期";
			return null;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			JieYue entity = data.get(rowIndex);
			if (columnIndex == 0)
				return entity.getJbook().getISBN();
			else if (columnIndex == 1)
				return entity.getJbook().getName();
			else if (columnIndex == 2)
				return entity.getJbook().getPress();
			else if (columnIndex == 3)
				return entity.getJborrow().getBortime();
			else if (columnIndex == 4)
				return entity.getJborrow().getReptime();
			return null;
		}


		public void setData(ArrayList<JieYue> data) {
			if (data == null)
				throw new IllegalArgumentException("参数data不能为null。");

			this.data = data;

			fireTableDataChanged();
		}

	}
	
	public class TableModel2 extends AbstractTableModel {
		BookDaoImpl rdi = new BookDaoImpl();
		ArrayList<Book> data = new ArrayList<Book>();{
			data = rdi.findAll();
		}
		
		@Override
		public int getRowCount() {
			return data.size();
		}

		@Override
		public int getColumnCount() {
			// 根据实际情况返回列数
			return 4;
		}
		
		@Override
		public String getColumnName(int column) {
			// 根据实际情况返回列名
			if (column == 0)
				return "图书编号";
			else if (column == 1)
				return "图书名称";
			else if (column == 2)
				return "出版社";
			else if (column == 3)
				return "剩余数量";
			return null;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Book entity = data.get(rowIndex);
			if (columnIndex == 0)
				return entity.getISBN();
			else if (columnIndex == 1)
				return entity.getName();
			else if (columnIndex == 2)
				return entity.getPress();
			else if (columnIndex == 3)
				return entity.getNumber();
			return null;
		}


		public void setData(ArrayList<Book> data) {
			if (data == null)
				throw new IllegalArgumentException("参数data不能为null。");

			this.data = data;

			fireTableDataChanged();
		}

	}
}
