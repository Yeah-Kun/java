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
	GetCategory gc = null;
	GetPress gp = null;
	
	public ArrayList<Book> FindAll(){ // ���ڲ��ҵ���ͼ����Ϣ���ܲ�ֹһ����������һ���б�洢
		ArrayList<Book> bookList = new ArrayList<>();

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
		Book book = null;
		String sql = "select * from book where id=?"; // ʹ��sql����ѯ���ݿ�
		try {
			// �������ݿ� ͨ��ID����ȡһ������
			ps = conn.prepareStatement(sql); 
			ps.setInt(1, id);
			
			result = ps.executeQuery(); // �õ����ݿ���Ϣ�������浽result
			
			// ִ��������䣬˵��id����
			// ��result����Ϣ�洢��book��������
			if (result.next()) {
				book = new Book();
				gp = new GetPress();
				gc = new GetCategory();
				// ��result�Ķ�ά�����ݷŵ�press��������
				book.setId(result.getInt("id")); // ��result�л�ȡid
				book.setISBN(result.getString("ISBN"));
				book.setName(result.getString("name"));
				book.setPrice(result.getDouble("price"));
				book.setPress(gp.FindbyID(result.getInt("pressID")));
				book.setCategory(gc.FindbyID(result.getInt("categoryID")));
			}
		} catch (SQLException e) {
			//System.out.println("���ݿ���ȡ��Ϣ����");
			e.printStackTrace();
		}

		return book; // �����ȡʧ����Ϊnull

	}

	@Override
	public int insert(Book entity) {
		int re=0;
		String sql = "INSERT INTO book(name,ISBN,price,pressID,categoryID) VALUES(?,?,?,?,?)"; // ʹ��SQL����ѯ���ݿ�
		try {
			// �������ݿ⣬����һ����������Ϣ
			ps = conn.prepareStatement(sql); // ��mysql��������
			ps.setString(1, entity.getName());
			ps.setString(2, entity.getISBN());
			ps.setDouble(3, entity.getPrice());
			ps.setInt(4, entity.getPress().getId());
			ps.setInt(5, entity.getCategory().getId());
			re = ps.executeUpdate(); // ִ�У����������

		} catch (SQLException e) {
			// System.out.println("���ݿ������Ϣ����");
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public int delete(Book entity) {
		int re=0;
		String sql = "delete from book where id=?"; // ʹ��SQL����ѯ���ݿ�
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, entity.getId()); // Ԥ����
				re = ps.executeUpdate(); // ִ��ɾ����䣬���ؽ��
				if(re == 0){
					System.out.println("��ID�����ڣ�������������Ҫɾ������Ϣ");
				}
			} catch (SQLException e) {
				// System.out.println("���ݿ�ɾ��ʧ�ܣ�����ԭ��");
				e.printStackTrace();
			} 
		return re;
	}

	@Override
	public int update(Book entity) {
		int re=0;
		String sql = "update book set name = ?,ISBN = ?, price = ?, pressID = ? , CategoryID = ? where id = ? "; // ʹ��SQL����ѯ���ݿ�
		try {
			// �������ݿ⣬����һ����������Ϣ
			if(entity == null){
				System.out.println("��ID��Ϣ�����ڣ�");
			}
			else{
				ps = conn.prepareStatement(sql); // ��mysql��������
				// index = ռλ��λ�ã�x = ��������
				ps.setString(1, entity.getName());
				ps.setString(2, entity.getISBN());
				ps.setDouble(3, entity.getPrice());
				ps.setInt(4, entity.getPress().getId());
				ps.setInt(5, entity.getCategory().getId());
				ps.setInt(6, entity.getId());
				re = ps.executeUpdate(); // ִ�У������������

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return re;	
	}
	
}
