/**
 * 2017��7��7��23:45:16
 * �򵥱�����ڲ��Դ�������
 */
package library.view;

import javax.persistence.Table;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class SimpleTableDemo {
	
	// ����һ���򵥵ı��,�����Ǳ�������
	String[] columnNames = { "first name", "last name", "sport", "# of Years",
			"Vegetarian" };
	// ���ľ�������
	Object[][] data = {
			{ "Katly", "Smith", "Snowcoarding", new Integer(5),
					new Boolean(false) },
			{ "john", "Doe", "Rowing", new Integer(3), new Boolean(true) },
			{ "Sue", "Blark", "Knitting", new Integer(2), new Boolean(false) },
			{ "john", "Doe", "Rowing", new Integer(3), new Boolean(true) },
			{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) } };

	// ��������ӱ��
	JTable table = new JTable(data, columnNames);  // ��������
	JScrollPane scrollPane = new JScrollPane(table); // ����һ������table������
//	table.setFillsViewportHeight(true);  // ռ�����������߶�
	
	//����ÿһ�еĿ��
	TableColumn column = new TableColumn();{
		for (int i = 0; i < 5; i++) {  
			column = table.getColumnModel().getColumn(i);  
		    if (i == 2) {  
		        column.setPreferredWidth(100); //third column is bigger  
		    } else {  
		        column.setPreferredWidth(50);  
		    }  
		} 
	} 
	
	
}
