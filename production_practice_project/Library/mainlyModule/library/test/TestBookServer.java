/**
 * 2017��7��8��14:30:38
 * ����BookServer�����ɾ���
 */
package library.test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import library.model.Book;
import library.server.BookServer;
import library.server.CategoryServer;
import library.server.PressServer;


public class TestBookServer {
	BookServer bs = null;
	PressServer ps = null;
	CategoryServer cs = null;
	Book book = null;
	
	@Before
	public void init() {
		bs = new BookServer(); 
		ps = new PressServer();
		cs = new CategoryServer();
		book = new Book();
	}
	
	@Test
	// ����FindAll
	public void testFindAll() {
		ArrayList<Book> bookList = bs.FindAll();
		for(Book b : bookList){
			System.out.println(b.toString());
		}

		Assert.assertNotNull(bookList);
//		Assert.assertEquals("�������������", bs.FindbyID(1).getName());
	}
	
//	@Test
//	// ����FindbyID
//	public void testFindbyID() {
//		int id = 2;
//		Assert.assertNotNull(bs.FindbyID(id));
//		Assert.assertEquals("C++", bs.FindbyID(id).getName());
//	}
	
//	@Test
//	// ����insert
//	public void testinsert() {
//		int pid = 3;
//		int cid = 2;
//		book.setName("�����ʷ");
//		book.setISBN("876548");
//		book.setPrice(43);
//		book.setPress(ps.FindbyID(pid));
//		book.setCategory(cs.FindbyID(cid));
//		Assert.assertTrue(bs.insert(book));
//	}
	
//	@Test
//	//����delete
//	public void testdelete() {
//		int id =3;
//		boolean re = false;
//		book.setId(id);
//		re = bs.delete(book);
//		Assert.assertTrue(re);
//	}
	
//	@Test
//	//����update
//	public void testupdate() {
//		int id =4;
//		boolean re = false;
//		book = bs.FindbyID(id);
//		System.out.println(book.toString());
//		if(book == null){
//			System.out.println("��ID�����ڣ�");
//		}
//		else{
//			book.setName("C");
//			book.setISBN("2956545154");
//			book.setPrice(55);
//			re = bs.update(book);
//		}
//		Assert.assertTrue(re);
//	}
}
