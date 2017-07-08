/**
 * 2017��7��8��10:10:00
 * 
 */
package library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import library.model.Book;

public class GetBook implements BookInterface{
	
	Connection conn = ConnectMySQL.getConnect();// ����Connection����
	ResultSet result = null; // �����������ݿ�Ķ�ά����Ϣ
	PreparedStatement ps = null; // PreparedStatement�������ڴ洢Connection���󷵻ص�����
	Book book = null;
	
	public ArrayList<Book> FindAll(){ // ���ڲ��ҵ���ͼ����Ϣ���ܲ�ֹһ����������һ���б�洢
		ArrayList<Book> bookList = new ArrayList<>();
		Book book = null;
		GetCategory gc = null;
		GetPress gp = null;
		
		String sql = "select * from book";
		try {
			ps = conn.prepareStatement(sql);
			result = ps.executeQuery();
			while(result.next()){
				book = new Book();
				gp = new GetPress();
				gc = new GetCategory();
				book.setId(result.getInt("id"));
				book.setName(result.getString("name"));
				book.setISBN(result.getString("ISBN"));
				book.setPrice(result.getDouble("price"));
				book.setPress(gp.FindbyID(result.getInt("pressID")));
				book.setCategory(gc.FindbyID(result.getInt("categoryID")));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}
	@Override
	public Book FindbyID(int id) {

		return null;
	}

	@Override
	public int insert(Book entity) {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public int delete(Book enity) {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public int update(Book entity) {
		// TODO �Զ����ɵķ������
		return 0;
	}
	
}
