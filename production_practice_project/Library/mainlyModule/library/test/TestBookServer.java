package library.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import library.server.BookServer;


public class TestBookServer {
	BookServer bs = new BookServer();
	
	@Before
	public void init() {
		bs = new BookServer(); 
	}
	
	@Test
	// ����FindAll
	public void testFindAll() {
		System.out.println(bs.FindAll());
		Assert.assertNotNull(bs.FindAll());
//		Assert.assertEquals("�������������", bs.FindbyID(1).getName());
	}
}
