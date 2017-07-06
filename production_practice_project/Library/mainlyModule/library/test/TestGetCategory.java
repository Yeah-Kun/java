/**
 * 2017年7月6日15:32:42
 * 测试图书类的服务层的信息
 */
package library.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import library.model.Category;
import library.server.CategoryServer;

public class TestGetCategory {
	CategoryServer cs =null;
	
	@Before
	public void init(){
		cs = new CategoryServer();
	}
	
	//@Test
	// 测试FindbyID
	public void testFindbyID() {
		Assert.assertNotNull(cs.FindbyID(1));
		Assert.assertEquals("人文", cs.FindbyID(1).getName());
	}
	
	@Test
	// 测试insert
	public void testinsert() {
		Category cat = new Category();
		cat.setName("人文");
		Assert.assertTrue(cs.insert(cat));
	}
	
////	@Test
//	//测试delete
//	public void testdelete() {
//		int id =3;
//		boolean re = false;
//		Press press = new Press();
//		press.setId(id);
//		re = cs.delete(press);
//		Assert.assertTrue(re);
//	}
	
//	//@Test
//	//测试update
//	public void testupdate() {
//		int id =3;
//		boolean re = false;
//		Press press = new Press();
//		PressServer getpress = new PressServer();
//		press = getpress.FindbyID(id);
//		if(press == null){
//			System.out.println("该ID不存在！");
//		}
//		else{
//			press.setName("北京出版社");
//			re = getpress.update(press);
//		}
//		Assert.assertTrue(re);
//	}
	
}
