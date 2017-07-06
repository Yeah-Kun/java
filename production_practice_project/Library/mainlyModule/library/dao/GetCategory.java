/**
 * 2017��7��6��15:13:05
 * ͼ��������ɾ���ʵ��
 * ����������ʵ�ַ���һ��
 */
package library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import library.model.Category;

public class GetCategory implements CategoryInterface{

	Connection conn = ConnectMySQL.getConnect();// ����Connection����
	ResultSet result = null; // �����������ݿ�Ķ�ά����Ϣ
	PreparedStatement ps = null; // PreparedStatement�������ڴ洢Connection���󷵻ص�����
	
	// ͨ��ID��������
	public Category FindbyID(int id) {
		Category cat= null; // ��Ϊ��֪��id�治���ڣ����Բ�new
		String sql = "select * from Category where id=?"; // ʹ��sql����ѯ���ݿ�
		
		try {
			// �������ݿ� ͨ��ID����ȡһ������
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			result = ps.executeQuery(); // �õ����ݿ���Ϣ�������浽result
			
			// ִ��������䣬˵��id����
			// ��result����Ϣ�洢��Category��������
			if (result.next()){
				cat = new Category(); 
				
				// ��result�Ķ�ά�����ݷŵ�Category��������
				cat.setId(result.getInt("id"));
				cat.setName(result.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return cat;
	}

	
	// ͨ��name��������
	public Category FindbyName(Category entity) {
		Category cat= null;
		String sql = "select * from Category where name=?";
		
		try {
			// �������ݿ⣬ͨ��name�������ݿ���Ϣ
			ps = conn.prepareStatement(sql);
			ps.setString(1, entity.getName());// Ԥ����
			result = ps.executeQuery(); // ִ�У����������
			
			if(result.next()){
				cat = new Category(); 
				
				// ��result�Ķ�ά�����ݷŵ�Category��������
				cat.setId(result.getInt("id"));
				cat.setName(result.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return cat;
	}


	// ��������
	public int insert(Category entity) {
		int re=0;
		String sql = "INSERT INTO Category(name) VALUES(?)"; // ʹ��SQL����ѯ���ݿ�
		try {
			// �������ݿ⣬����һ����������Ϣ
			ps = conn.prepareStatement(sql); // ��mysql��������
			
			ps.setString(1, entity.getName());// Ԥ����
			re = ps.executeUpdate(); // ִ�У����������

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return re;
	
	}

	// ɾ������
	public int delete(Category entity) {
		int re=0;
		String sql = "delete from Category where id=?"; // ʹ��SQL����ѯ���ݿ�
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, entity.getId()); // Ԥ����
				re = ps.executeUpdate(); // ִ��ɾ����䣬���ؽ��
				if(re == 0){
					System.out.println("��ID�����ڣ�������������Ҫɾ������Ϣ");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		return re;
	}

	// �޸�����
	public int update(Category entity) {
		int re=0;
		String sql = "update Category set name = ? where id = ? "; // ʹ��SQL����ѯ���ݿ�
		try {
			// �������ݿ⣬����һ����������Ϣ
			if(entity == null){
				System.out.println("��ID��Ϣ�����ڣ�");
			}
			else{
				ps = conn.prepareStatement(sql); // ��mysql��������
				
				// index = ռλ��λ�ã�x = ��������
				ps.setString(1, entity.getName());
				ps.setInt(2, entity.getId());
				re = ps.executeUpdate(); // ִ�У������������
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return re;	
	}
	
}
