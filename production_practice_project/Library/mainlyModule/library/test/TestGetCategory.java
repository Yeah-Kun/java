/**
 * 2017��7��6��15:32:42
 * ����ͼ����ķ�������Ϣ
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
//	// ����FindbyID
//	public void testFindbyID() {
//		int id = 3;
//		Assert.assertNotNull(cs.FindbyID(id));
//		Assert.assertEquals("��ʷ", cs.FindbyID(id).getName());
//	}
	
//	@Test
//	// ����FindbyID
//	public void testFindbyName() {
//		Category name = new Category();
//		String newname = "����";
//		name.setName(newname);
//		Assert.assertNotNull(cs.FindbyName(name));
//	}
	
	@Test
	// ����insert
	public void testinsert() {
		Category cat = new Category();
		cat.setName("����");
		Assert.assertTrue(cs.insert(cat));
	}
	
//	@Test
//	//����delete
//	public void testdelete() {
//		int id =3;
//		boolean re = false;
//		Category cat = new Category();
//		cat.setId(id);
//		re = cs.delete(cat);
//		Assert.assertTrue(re);
//	}
	
//	@Test
//	// ����update
//	public void testupdate() {
//		int id = 2;
//		boolean re = false;
//		Category cat = new Category();
//		cat = cs.FindbyID(id);
//		if (cat == null) {
//			System.out.println("��ID�����ڣ�");
//		} else {
//			cat.setName("����");
//			re = cs.update(cat);
//		}
//		Assert.assertTrue(re);
//	}

}
