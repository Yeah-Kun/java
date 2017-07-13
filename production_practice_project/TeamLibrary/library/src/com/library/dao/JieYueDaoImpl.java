package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.library.model.JieYue;

public class JieYueDaoImpl implements IJieYueDao{
	Connection conn = BUtil.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	ReaderDaoImpl rdi = new ReaderDaoImpl();
	BorrowDaoImpl bdi = new BorrowDaoImpl();
	BookDaoImpl bookdi = new BookDaoImpl();
	@Override
	public ArrayList<JieYue> findByName(String sname) {
		ArrayList<JieYue> jy = new ArrayList<JieYue>();
		JieYue j = null;
		String sql = "select * from jieyue where rname=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,sname);
			rs = ps.executeQuery();
			while(rs.next()) {
				j = new JieYue();
				j.setJreader(rdi.findByName(rs.getString("rname")));
				j.setJborrow(bdi.findByruserid_bISBN(rdi.findByName(rs.getString("rname")).getUserid(), rs.getInt("ISBN")));
				j.setJbook(bookdi.findByName(rs.getNString("bname")));
				jy.add(j);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jy;
	}
	@Override
	public JieYue findByBookISBN(int id) {
		JieYue reader = null;
		String sql = "select * from jieyue where ISBN=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				reader = new JieYue();
				reader.setJbook(bookdi.findByISBN(rs.getInt("id")));
				reader.setJborrow(bdi.findByruserid_bISBN(rdi.findByName(rs.getString("rname")).getUserid(), rs.getInt("ISBN")));
				reader.setJreader(rdi.findByName(rs.getString("rname")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reader;
	}

}
