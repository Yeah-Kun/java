package com.library.test;

import com.library.dao.JieYueDaoImpl;

public class TeatJieYue {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		JieYueDaoImpl j = new JieYueDaoImpl();
		
		System.out.println(j.findByName("庄仕鹏").get(1).getJbook().getNumber());
	}

}
