package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.library.model.Book;

public class BookDaoImpl implements IBookDao {
	Connection conn = BUtil.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public Book findByISBN(int ISBN) {
		Book book = null;
		String sql = "select * from book where ISBN=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ISBN);
			rs = ps.executeQuery();
			if (rs.next()) {
				book = new Book();
				book.setISBN(rs.getInt("ISBN"));
				book.setName(rs.getString("name"));
				book.setPress(rs.getString("press"));
				book.setTime(rs.getDate("time"));
				book.setNumber(rs.getInt("number"));
			}
		} catch (SQLException e) {
			// TODO �Զ���ɵ� catch ��
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public Book findByName(String name) {
		Book book = null;
		String sql = "select * from book where name=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if (rs.next()) {
				book = new Book();
				book.setISBN(rs.getInt("ISBN"));
				book.setName(rs.getString("name"));
				book.setPress(rs.getString("press"));
				book.setTime(rs.getDate("time"));
				book.setNumber(rs.getInt("number"));
			} else {
				System.out.println("bdI:no book");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	public ArrayList<Book> findAll() {
		ArrayList<Book> bookList = new ArrayList<Book>();
		Book book = null;
		String sql = "select * from book ";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				book = new Book();
				book.setISBN(rs.getInt("ISBN"));
				book.setName(rs.getString("name"));
				book.setPress(rs.getString("press"));
				book.setTime(rs.getDate("time"));
				book.setNumber(rs.getInt("number"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			// TODO �Զ���ɵ� catch ��
			e.printStackTrace();
		}
		return bookList;
	}

	@Override
	public int BookInsert(Book book) {
		int values = 0;
		String sql = "insert into book(name,press,time,number) values(?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, book.getName());
			ps.setString(2, book.getPress());
			ps.setDate(3, book.getTime());
			ps.setInt(4, book.getNumber());
			values = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return values;
	}

	public int BookUpdate(Book book) {
		int values = 0;
		String sql = "update book set name=?,press=?,time=?,number=? where ISBN=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, book.getName());
			ps.setString(2, book.getPress());
			ps.setDate(3, book.getTime());
			ps.setInt(4, book.getNumber());
			ps.setInt(5, book.getISBN());
			values = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return values;
	}

	public int BookDelete(Book book) {
		int values = 0;
		String sql = "delete from book where ISBN=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, book.getISBN());
			values = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return values;
	}

}
