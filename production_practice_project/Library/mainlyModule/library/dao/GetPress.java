/*
 * 2017��7��4��11:04:33
 * �����ݿ���ȡ������Ļ�������
 * 1. ʹ��Connection��������mysql
 * 2. Connection����ͨ��sql���������ݿ⣬��ȡ���ݣ�����PreparedStatement����
 * 3. ʹ��executeQuery��������PreparedStatement���󣬽��õ��Ķ�ά�����ݴ洢��result
 * 4. ��result�Ķ�ά������ת�浽press���󣨵���press��set������
 */
package library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import library.model.Press;

public class GetPress implements PressInterface {
	
	Connection conn = ConnectMySQL.getConnect();// ����Connection����
	ResultSet result = null; // �����������ݿ�Ķ�ά����Ϣ
	PreparedStatement ps = null; // PreparedStatement�������ڴ洢Connection���󷵻ص�����

	@Override
	public Press FindbyID(int id) {
		Press press = null;
		String sql = "select * from press where id=?"; // ʹ��sql����ѯ���ݿ�
		try {
			// �������ݿ� ͨ��ID����ȡһ������
			ps = conn.prepareStatement(sql); 
			ps.setInt(1, id);
			
			result = ps.executeQuery(); // �õ����ݿ���Ϣ�������浽result
			if (result.next()) {
				press = new Press();// ����press�������ڱ����ȡ�������ݿ�����

				// ��result�Ķ�ά�����ݷŵ�press��������
				press.setId(result.getInt("id")); // ��result�л�ȡid
				press.setAdress(result.getString("adress"));
				press.setMail(result.getString("mail"));
				press.setName(result.getString("name"));
				press.setUrl(result.getString("url"));
			}
		} catch (SQLException e) {
			System.out.println("���ݿ���ȡ��Ϣ����");
		}

		return press;
	}

	@Override
	public int insert(Press eneity) {
		int re=0;
		String sql = "INSERT INTO Press(name,adress,url,mail) VALUES(?,?,?,?)"; // ʹ��SQL����ѯ���ݿ�
		try {
			// �������ݿ⣬����һ����������Ϣ
			ps = conn.prepareStatement(sql); // ��mysql��������
			ps.setString(1, eneity.getName());
			ps.setString(2, eneity.getAdress());
			ps.setString(3, eneity.getUrl());
			ps.setString(4, eneity.getMail());
			re = ps.executeUpdate(); // ���������

		} catch (SQLException e) {
			System.out.println("���ݿ������Ϣ����");
		}
		return re;
	}

	public int delete(Press entity) {
		int re=0;
		String sql = "delete from press where id=?"; // ʹ��SQL����ѯ���ݿ�
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, entity.getId()); // Ԥ����
				re = ps.executeUpdate(); // ִ��ɾ����䣬���ؽ��
				if(re == 0){
					System.out.println("��ID�����ڣ�������������Ҫɾ������Ϣ");
				}
			} catch (SQLException e) {
				System.out.println("���ݿ�ɾ��ʧ�ܣ�����ԭ��");
			} 
		return re;
	}

	public int update(Press entity) {
		int re=0;
		String sql = "update press set name = ?,adress = ?, url = ?, mail = ? where id = ? "; // ʹ��SQL����ѯ���ݿ�
		try {
			// �������ݿ⣬����һ����������Ϣ
			if(entity == null){
				System.out.println("��ID��Ϣ�����ڣ�");
			}
			else{
				ps = conn.prepareStatement(sql); // ��mysql��������
				ps.setString(1, entity.getName());
				ps.setString(2, entity.getAdress());
				ps.setString(3, entity.getUrl());
				ps.setString(4, entity.getMail());
				ps.setInt(5, entity.getId());
				re = ps.executeUpdate(); // ִ�У������������

			}
		} catch (SQLException e) {
			System.out.println("���ݿ������Ϣ����");
		}
		return re;	
	}

}
