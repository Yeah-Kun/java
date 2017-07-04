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

}
