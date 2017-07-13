/**
 * 2017年7月7日23:45:16
 * 简单表格，用于测试窗口容器
 */
package library.view;

import javax.persistence.Table;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class SimpleTableDemo {
	
	// 创建一个简单的表格,以下是表格的列名
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

	// 向容器添加表格
	JTable table = new JTable(data, columnNames);  // 接收数据
	JScrollPane scrollPane = new JScrollPane(table); // 创建一个容纳table的容器
//	table.setFillsViewportHeight(true);  // 占据容器整个高度
	
	//设置每一列的宽度
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
