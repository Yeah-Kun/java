/*
 * 2017年7月6日9:33:22
 * 测试，往Press表进行增删查改
 */
package library.test;

import library.dao.GetPress;
import library.model.Press;

public class TestGetPress2 {
	 //测试添加，以下代码可以使用
	 public static void main(String[] args) {
	 int re;
	 Press press = new Press();
	 GetPress getpress = new GetPress();
	 press.setAdress("广州");
	 press.setMail("68465@qq.com");
	 press.setName("SBH48");
	 press.setUrl("www.wyu.com");
	 re = getpress.insert(press);
	 System.out.println(re);
	 }
	
//	// 测试删除，以下代码可以使用
//	public static void main(String[] args) {
//		int id = 4, re = 0;
//		Press press = new Press();
//		GetPress getpress = new GetPress();
//		press.setId(id);
//		re = getpress.delete(press);
//		System.out.println(re);
//	}
}
