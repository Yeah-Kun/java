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

	
	// ������ӽ���
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
		// TODO �Զ����ɵķ������

	}

	public void mouseReleased(MouseEvent e) {
		// TODO �Զ����ɵķ������

	}

	public void mouseEntered(MouseEvent e) {
		// TODO �Զ����ɵķ������

	}

	public void mouseExited(MouseEvent e) {
		// TODO �Զ����ɵķ������

	}

	public void FrmPressManage() {
		// ���ҳ��ʵ����
		fpa = new FrmPressAdd();

		JButton buttonadd, buttonclose;
		// ���ɾ�����
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
		buttonadd.setText("���");
		panel_1.add(buttonadd);

		buttonclose = new JButton();
		// buttonclose.addActionListener(new CloseActionListener());
		buttonclose.setText("�ر�");
		panel_1.add(buttonclose);
		// �ڲ��࣬��ģ��
		TableModel btm = new TableModel();
		// ���ɱ�ؼ���
		table = new JTable(btm);
		// �ڱ������������
		table.addMouseListener(this);
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(WIDTH);
		// �ñ�ؼ������������
		JScrollPane scrollPane = new JScrollPane(table);
		// ��ȡJFrame�����ؼ�
		JPanel jp = (JPanel) getContentPane();

		// �����ؼ�����ӹ������ؼ�
		jp.add(scrollPane, BorderLayout.CENTER);

		jp.add(panel_1, BorderLayout.NORTH);
		// JFrame�������
		setTitle("���������");
		setSize(600, 200);
		// JFrame���ӻ�
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
			// ����ʵ�������������
			return 5;
		}

		@Override
		public String getColumnName(int column) {
			// ����ʵ�������������
			if (column == 0)
				return "���";
			else if (column == 1)
				return "����������";
			else if (column == 2)
				return "�������ַ";
			else if (column == 3)
				return "��ַ";
			else if (column == 4)
				return "��������";
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
				throw new IllegalArgumentException("����data����Ϊnull��");

			this.data = data;

			fireTableDataChanged();
		}

	}

	class addBookActionListener implements ActionListener { // ��ӹرհ�ť���¼�������
		public void actionPerformed(final ActionEvent e) {
			fpa.setVisible(true);
		}
	}

	// add frame begin
	class FrmPressAdd extends JFrame {
		JTextField jTName, jTAddress, jTUrl, jTMail;

		public FrmPressAdd() {
			JPanel mainPanel = new JPanel();
			// ���ơ���塡��
			JPanel jpName = new JPanel();
			JLabel jlName = new JLabel("���������ƣ�");
			jTName = new JTextField(20);
			jpName.add(jlName);
			jpName.add(jTName);
			// ��ַ���
			JPanel jpAddress = new JPanel();
			JLabel jlAddress = new JLabel("�������ַ��");
			jTAddress = new JTextField(20);
			jpAddress.add(jlAddress);
			jpAddress.add(jTAddress);
			// ��ַ���
			JPanel jpUrl = new JPanel();
			JLabel jlUrl = new JLabel("��������ַ��");
			jTUrl = new JTextField(20);
			jpUrl.add(jlUrl);
			jpUrl.add(jTUrl);
			// ��ַ���
			JPanel jpMail = new JPanel();
			JLabel jlMail = new JLabel("���������䣺");
			jTMail = new JTextField(20);
			jpMail.add(jlMail);
			jpMail.add(jTMail);

			// ��ӿؼ��������
			mainPanel.add(jpName);
			mainPanel.add(jpAddress);
			mainPanel.add(jpUrl);
			mainPanel.add(jpMail);
			JButton btnSave = new JButton("�ύ");
			// �ύ��ť����¼��������ڲ�����ɼ����Ĺ���
			btnSave.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// ���ɶ���
					Press p = new Press();
					// ������
					p.setName(jTName.getText());
					p.setAdress(jTAddress.getText());
					p.setMail(jTMail.getText());
					p.setUrl(jTUrl.getText());
					// ��Ӷ��󣬸��ݷ���ֵ������ʾ
					if (psi.insert(p)) {
						JOptionPane.showMessageDialog(null, "��ӳɹ���");
					} else {
						JOptionPane.showMessageDialog(null, "���ʧ�ܣ�");
					}
				}
			});
			mainPanel.add(btnSave);
			this.getContentPane().add(mainPanel);
			this.setSize(400, 200);
		}
	} // add ifram end

}// FrmPressManage