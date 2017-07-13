package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.library.model.Reader;

public class ReaderDaoImpl implements IReaderDao {
	Connection conn = BUtil.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public Reader findByUserid(String userid) {
		// TODO 自动生成的方法存根
		Reader reader = null;
		String sql = "select * from reader where userid=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			if (rs.next()) {
				reader = new Reader();
				reader.setId(rs.getInt("id"));
				reader.setName(rs.getString("name"));
				reader.setUserid(rs.getString("userid"));
				reader.setPhone(rs.getInt("phone"));
				reader.setDepart(rs.getString("depart"));
				reader.setAmount(rs.getInt("amount"));
				reader.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reader;
	}

	@Override
	public Reader findByName(String name) {
		// TODO 自动生成的方法存根
		Reader reader = null;
		String sql = "select * from reader where name=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if (rs.next()) {
				reader = new Reader();
				reader.setId(rs.getInt("id"));
				reader.setName(rs.getString("name"));
				reader.setUserid(rs.getString("userid"));
				reader.setPhone(rs.getInt("phone"));
				reader.setDepart(rs.getString("depart"));
				reader.setAmount(rs.getInt("amount"));
				reader.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reader;
	}

	@Override
	public ArrayList<Reader> findAll() {
		// TODO 自动生成的方法存根
		ArrayList<Reader> readerList = new ArrayList<Reader>();
		Reader reader = null;
		String sql = "select * from reader ";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				reader = new Reader();
				reader.setId(rs.getInt("id"));
				reader.setName(rs.getString("name"));
				reader.setUserid(rs.getString("userid"));
				reader.setPhone(rs.getInt("phone"));
				reader.setDepart(rs.getString("depart"));
				reader.setAmount(rs.getInt("amount"));
				reader.setPassword(rs.getString("password"));
				readerList.add(reader);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return readerList;
	}

	@Override
	public int ReaderInsert(Reader reader) {
		// TODO 自动生成的方法存根
		int values = 0;
		String sql = "insert into reader(name,userid,phone,depart,amount,password) values(?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, reader.getName());
			ps.setString(2, reader.getUserid());
			ps.setInt(3, reader.getPhone());
			ps.setString(4, reader.getDepart());
			ps.setInt(5, reader.getAmount());
			ps.setString(6, reader.getPassword());
			values = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return values;
	}

	@Override
	public int ReaderUpdate(Reader reader) {
		// TODO 自动生成的方法存根
		int values = 0;
		String sql = "update reader set name=?,phone=?,depart=?,amount=?,password=? where userid=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, reader.getName());
			ps.setInt(2, reader.getPhone());
			ps.setString(3, reader.getDepart());
			ps.setInt(4, reader.getAmount());
			ps.setString(5, reader.getPassword());
			ps.setString(6, reader.getUserid());
			values = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return values;
	}

	@Override
	public int ReaderDelete(Reader reader) {
		// TODO 自动生成的方法存根
		int values = 0;
		String sql = "delete from reader where userid=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, reader.getUserid());
			values = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return values;
	}

}
