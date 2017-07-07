/**日13月751
 * 2017年7:14:
 * 简单表格，用于测试窗口容器
 */
package library.view;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SimpleTableDemo {
	
	// 表格的列名
	String[] columnNames = { "first name", "last name", "sport", "# of Years",
			"Vegetarian" };
	// 表格的具体数据
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
