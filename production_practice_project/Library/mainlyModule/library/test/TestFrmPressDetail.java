/*
 * 2017年7月4日16:34:55
 * 视窗层测试，先创建服务层，再将服务层信息映射到视窗层
 */
package library.test;

import library.server.PressServer;
import library.view.FrmPressDetail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestFrmPressDetail {
	FrmPressDetail Fpd = null;
	PressServer psi = null;
	
	// 测试PressServer对象，先创建这个对象
	@Before
	public void init(){
		psi = new PressServer();  // 服务层对象
		Fpd = new FrmPressDetail(); // 视窗层对象
		
	}
	
	@Test
	public void testFindbyID(){
		Fpd.setContent(psi.FindbyID(1).toString()); // 服务层获取信息，视窗层展示
		Assert.assertNotNull(Fpd);
	}
}
