package com.library.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.library.model.Borrow;

public class BorrowDaoImpl implements IBorrowDao {

	Connection conn = BUtil.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public Borrow findByruserid_bISBN(String ruserid, int bISBN) {
		// TODO 自动生成的方法存根
		Borrow borrow = null;
		String sql = "select * from borrow where ruserid=? and bISBN=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, ruserid);
			ps.setInt(2, bISBN);
			rs = ps.executeQuery();
			if (rs.next()) {
				borrow = new Borrow();
				borrow.setId(rs.getInt("id"));
				borrow.setRuserid(rs.getString("ruserid"));
				borrow.setbISBN(rs.getInt("bISBN"));
				borrow.setIsborrow(rs.getInt("isborrow"));
				borrow.setBortime(rs.getDate("bortime"));
				borrow.setReptime(rs.getDate("reptime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return borrow;
	}

	@Override
	public ArrayList<Borrow> findByAllruserid(String ruserid) {
		// TODO 自动生成的方法存根
		ArrayList<Borrow> borrowList = new ArrayList<Borrow>();
		Borrow borrow = null;
		String sql = "select * from borrow where ruserid=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, ruserid);
			rs = ps.executeQuery();
			while (rs.next()) {
				borrow = new Borrow();
				borrow.setId(rs.getInt("id"));
				borrow.setRuserid(rs.getString("ruserid"));
				borrow.setbISBN(rs.getInt("bISBN"));
				borrow.setIsborrow(rs.getInt("isborrow"));
				borrow.setBortime(rs.getDate("bortime"));
				borrow.setReptime(rs.getDate("reptime"));
				borrowList.add(borrow);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return borrowList;
	}

	@Override
	public int BorrowUpdateByruserid_bISBN(String ruserid, int ISBN) {
		// TODO 自动生成的方法存根
		int values = 0;
		String sql = "update borrow set isborrow=? where ruserid=? and bISBN=?";
		Borrow borrow = new Borrow();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, borrow.getIsborrow());
			ps.setString(2, borrow.getRuserid());
			ps.setInt(3, borrow.getbISBN());
			values = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return values;
	}

	@Override
	public Date theLastDate(ArrayList<Borrow> borrowList) {
		// TODO 自动生成的方法存根
		Date theLastDate = Date.valueOf("1900-01-01");
		for (Borrow borrow : borrowList) {
			Date date = null;
			date = borrow.getBortime();
			if (theLastDate.compareTo(date) < 0 ? true : false) {
				theLastDate = date;
			}
		}
		return theLastDate;
	}

	@Override
	public long subDate(Borrow borrow) {
		// TODO 自动生成的方法存根
		long diff = borrow.getReptime().getTime()
				- borrow.getBortime().getTime();
		return diff / (1000 * 60 * 60 * 24);
	}

	@Override
	public ArrayList<Borrow> findAll() {
		// TODO 自动生成的方法存根
		ArrayList<Borrow> borrowList = new ArrayList<Borrow>();
		Borrow borrow = null;
		String sql = "select * from borrow ";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				borrow = new Borrow();
				borrow.setId(rs.getInt("id"));
				borrow.setRuserid(rs.getString("ruserid"));
				borrow.setbISBN(rs.getInt("bISBN"));
				borrow.setIsborrow(rs.getInt("isborrow"));
				borrow.setBortime(rs.getDate("bortime"));
				borrow.setReptime(rs.getDate("reptime"));
				borrowList.add(borrow);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return borrowList;
	}

}
