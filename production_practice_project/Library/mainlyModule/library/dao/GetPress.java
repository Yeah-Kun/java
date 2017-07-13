/*
 * 2017��7��4��11:04:33
 * �����ݿ���ȡ������Ļ�������
 * 1. ����
 */
package library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import library.model.Press;

public class GetPress implements PressInterface {
	// ��������
	Connection conn = ConnectMySQL.getConnect();
	ResultSet result = null; // �����������ݿ�Ķ�ά����Ϣ
	PreparedStatement ps = null;

	@Override
	public Press FindbyID(int id) {
		Press press = null;
		String sql = "select * from press where id=?";
		try {
			ps = conn.prepareStatement(sql); // �������ݿ�
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
			System.out.println("���ݿ��������");
		}

		return press;
	}

}
