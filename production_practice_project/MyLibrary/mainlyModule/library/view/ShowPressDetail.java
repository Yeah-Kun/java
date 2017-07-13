/**
 * 2017年7月6日14:17:11
 * 输入编号，展现所有信息
 * 1. 按照ID访问服务层，提取数据
 * 2. 使用战线层展示信息
 */
package library.view;

import java.util.Scanner;

import library.server.PressServer;

public class ShowPressDetail {
	
	public static void main(String[] args) {
		PressServer psi = new PressServer(); // 做一个服务层对象，用来调数据库数据
		FrmPressDetail fd = new FrmPressDetail(); // 展示层对象，用来展示 
		System.out.print("请输入出版社编号：");
		Scanner in = new Scanner(System.in);
		int id = in.nextInt();
		fd.setContent(psi.FindbyID(id).toString());
	}
}
