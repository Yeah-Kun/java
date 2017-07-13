package library.view;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;

import library.model.Press;
import library.server.PressServer;

public class FrmPressManage1 extends JFrame implements MouseListener {

	
	// 定义添加界面
	FrmPressAdd fpa = null;
	PressServer psi = new PressServer();
	JTable table;

	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		int col = table.getSelectedColumn();
		Object value = table.getValueAt(row, col);
		JOptionPane.showMessageDialog(null, value);
	}

	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	public void FrmPressManage() {
		// 添加页面实例化
		fpa = new FrmPressAdd();

		JButton buttonadd, buttonclose;
		// 添加删除面板
		final JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1,
				false));
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setVgap(2);
		flowLayout.setHgap(30);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_1.setLayout(flowLayout);

		buttonadd = new JButton();
		buttonadd.addActionListener(new addBookActionListener());
		buttonadd.setText("添加");
		panel_1.add(buttonadd);

		buttonclose = new JButton();
		// buttonclose.addActionListener(new CloseActionListener());
		buttonclose.setText("关闭");
		panel_1.add(buttonclose);
		// 内部类，表模型
		TableModel btm = new TableModel();
		// 生成表控件　
		table = new JTable(btm);
		// 在表上添加鼠标监听
		table.addMouseListener(this);
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(WIDTH);
		// 用表控件构建滚动面板
		JScrollPane scrollPane = new JScrollPane(table);
		// 获取JFrame容器控件
		JPanel jp = (JPanel) getContentPane();

		// 容器控件中添加滚动面板控件
		jp.add(scrollPane, BorderLayout.CENTER);

		jp.add(panel_1, BorderLayout.NORTH);
		// JFrame外观设置
		setTitle("出版社管理");
		setSize(600, 200);
		// JFrame可视化
		setVisible(true);
	}

	class TableModel extends AbstractTableModel {
		private ArrayList<Press> data = new PressServer().FindAll();

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
				return "编号";
			else if (column == 1)
				return "出版社名称";
			else if (column == 2)
				return "出版社地址";
			else if (column == 3)
				return "网址";
			else if (column == 4)
				return "电子邮箱";
			return null;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Press entity = data.get(rowIndex);
			if (columnIndex == 0)
				return entity.getId();
			else if (columnIndex == 1)
				return entity.getName();
			else if (columnIndex == 2)
				return entity.getAdress();
			else if (columnIndex == 3)
				return entity.getUrl();
			else if (columnIndex == 4)
				return entity.getMail();
			return null;
		}


		public void setData(ArrayList<Press> data) {
			if (data == null)
				throw new IllegalArgumentException("参数data不能为null。");

			this.data = data;

			fireTableDataChanged();
		}

	}

	class addBookActionListener implements ActionListener { // 添加关闭按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			fpa.setVisible(true);
		}
	}

	// add frame begin
	class FrmPressAdd extends JFrame {
		JTextField jTName, jTAddress, jTUrl, jTMail;

		public FrmPressAdd() {
			JPanel mainPanel = new JPanel();
			// 名称　面板　　
			JPanel jpName = new JPanel();
			JLabel jlName = new JLabel("出版社名称：");
			jTName = new JTextField(20);
			jpName.add(jlName);
			jpName.add(jTName);
			// 地址面板
			JPanel jpAddress = new JPanel();
			JLabel jlAddress = new JLabel("出版社地址：");
			jTAddress = new JTextField(20);
			jpAddress.add(jlAddress);
			jpAddress.add(jTAddress);
			// 地址面板
			JPanel jpUrl = new JPanel();
			JLabel jlUrl = new JLabel("出版社网址：");
			jTUrl = new JTextField(20);
			jpUrl.add(jlUrl);
			jpUrl.add(jTUrl);
			// 地址面板
			JPanel jpMail = new JPanel();
			JLabel jlMail = new JLabel("出版社邮箱：");
			jTMail = new JTextField(20);
			jpMail.add(jlMail);
			jpMail.add(jTMail);

			// 添加控件到主面板
			mainPanel.add(jpName);
			mainPanel.add(jpAddress);
			mainPanel.add(jpUrl);
			mainPanel.add(jpMail);
			JButton btnSave = new JButton("提交");
			// 提交按钮添加事件监听，内部类完成监听的功能
			btnSave.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// 生成对象
					Press p = new Press();
					// 填充对象
					p.setName(jTName.getText());
					p.setAdress(jTAddress.getText());
					p.setMail(jTMail.getText());
					p.setUrl(jTUrl.getText());
					// 添加对象，根据返回值给出提示
					if (psi.insert(p)) {
						JOptionPane.showMessageDialog(null, "添加成功！");
					} else {
						JOptionPane.showMessageDialog(null, "添加失败！");
					}
				}
			});
			mainPanel.add(btnSave);
			this.getContentPane().add(mainPanel);
			this.setSize(400, 200);
		}
	} // add ifram end

}// FrmPressManage