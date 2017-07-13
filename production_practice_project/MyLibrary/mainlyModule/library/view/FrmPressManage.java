/**
 * 2017年7月8日15:48:30
 * 老师的代码
 */
package library.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

public class FrmPressManage extends JFrame {
	FrmPressAdd fpa = null;

	public FrmPressManage() {
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

		// 增加按钮
		buttonadd = new JButton();
		buttonadd.addActionListener(new addBookActionListener());
		buttonadd.setText("添加");
		panel_1.add(buttonadd);
		// 关闭按钮
		buttonclose = new JButton();
		// buttonclose.addActionListener(new CloseActionListener());
		buttonclose.setText("关闭");
		panel_1.add(buttonclose);
		
		// 内部类，表模型
		TableModel btm = new TableModel();
		// 生成表控件　
		JTable table = new JTable(btm);
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
		private List<Press> data = new PressServer().FindAll();

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

		// 给单元格填充信息
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


		public void setData(List<Press> data) {
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
		public FrmPressAdd() {
			JPanel mainPanel = new JPanel();
			// 名称　面板　　
			JPanel jpName = new JPanel();
			JLabel jlName = new JLabel("出版社名称：");
			JTextField jTName = new JTextField(20);
			jpName.add(jlName);
			jpName.add(jTName);
			// 地址面板
			JPanel jpAddress = new JPanel();
			JLabel jlAddress = new JLabel("出版社地址：");
			JTextField jTAddress = new JTextField(20);
			jpAddress.add(jlAddress);
			jpAddress.add(jTAddress);
			// 地址面板
			JPanel jpUrl = new JPanel();
			JLabel jlUrl = new JLabel("出版社网址：");
			JTextField jTUrl = new JTextField(20);
			jpUrl.add(jlUrl);
			jpUrl.add(jTUrl);
			// 地址面板
			JPanel jpMail = new JPanel();
			JLabel jlMail = new JLabel("出版社邮箱：");
			JTextField jTMail = new JTextField(20);
			jpMail.add(jlMail);
			jpMail.add(jTMail);

			// 添加控件到主面板
			mainPanel.add(jpName);
			mainPanel.add(jpAddress);
			mainPanel.add(jpUrl);
			mainPanel.add(jpMail);
			JButton btnSave = new JButton("提交");
			btnSave.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "添加成功！");

				}
			});
			mainPanel.add(btnSave);

			this.getContentPane().add(mainPanel);
			this.setSize(400, 200);
		}
	} // add ifram end

}// FrmPressManage