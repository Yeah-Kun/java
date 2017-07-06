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
	
//	@Test
//	// 测试FindbyID
//	public void testFindbyID() {
//		int id = 3;
//		Assert.assertNotNull(cs.FindbyID(id));
//		Assert.assertEquals("历史", cs.FindbyID(id).getName());
//	}
	
//	@Test
//	// 测试FindbyID
//	public void testFindbyName() {
//		Category name = new Category();
//		String newname = "政治";
//		name.setName(newname);
//		Assert.assertNotNull(cs.FindbyName(name));
//	}
	
	@Test
	// 测试insert
	public void testinsert() {
		Category cat = new Category();
		cat.setName("军事");
		Assert.assertTrue(cs.insert(cat));
	}
	
//	@Test
//	//测试delete
//	public void testdelete() {
//		int id =3;
//		boolean re = false;
//		Category cat = new Category();
//		cat.setId(id);
//		re = cs.delete(cat);
//		Assert.assertTrue(re);
//	}
	
//	@Test
//	// 测试update
//	public void testupdate() {
//		int id = 2;
//		boolean re = false;
//		Category cat = new Category();
//		cat = cs.FindbyID(id);
//		if (cat == null) {
//			System.out.println("该ID不存在！");
//		} else {
//			cat.setName("政治");
//			re = cs.update(cat);
//		}
//		Assert.assertTrue(re);
//	}

}
