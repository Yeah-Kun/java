/**��13��751
 * 2017��7:14:
 * �򵥱�����ڲ��Դ�������
 */
package library.view;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SimpleTableDemo {
	
	// ��������
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

	JTable table = new JTable(data, columnNames);  
	JScroll
	Pane scrollPane = new JScrollPane(table);  
}
