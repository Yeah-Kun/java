/*
 * 2017年7月5日11:13:11
 * 1. 
 */
package library.test;

import library.server.PressServer;
import library.view.FrmPressDetail;

public class TestFrmPressDetail2 {
	public static void main(String[] args) {
		FrmPressDetail Fpd = null;
		PressServer psi = null;
		psi = new PressServer();  // 服务层对象
		Fpd = new FrmPressDetail(); // 视窗层对象
		Fpd.setContent(psi.FindbyID(1).toString()); // 服务层获取信息，视窗层展示
	}
}
