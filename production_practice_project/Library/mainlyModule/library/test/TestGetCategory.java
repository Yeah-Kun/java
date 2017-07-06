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
	
	//@Test
	// ����FindbyID
	public void testFindbyID() {
		Assert.assertNotNull(cs.FindbyID(1));
		Assert.assertEquals("����", cs.FindbyID(1).getName());
	}
	
	@Test
	// ����insert
	public void testinsert() {
		Category cat = new Category();
		cat.setName("����");
		Assert.assertTrue(cs.insert(cat));
	}
	
////	@Test
//	//����delete
//	public void testdelete() {
//		int id =3;
//		boolean re = false;
//		Press press = new Press();
//		press.setId(id);
//		re = cs.delete(press);
//		Assert.assertTrue(re);
//	}
	
//	//@Test
//	//����update
//	public void testupdate() {
//		int id =3;
//		boolean re = false;
//		Press press = new Press();
//		PressServer getpress = new PressServer();
//		press = getpress.FindbyID(id);
//		if(press == null){
//			System.out.println("��ID�����ڣ�");
//		}
//		else{
//			press.setName("����������");
//			re = getpress.update(press);
//		}
//		Assert.assertTrue(re);
//	}
	
}
