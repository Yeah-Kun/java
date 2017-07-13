package com.library.dao;

import java.sql.Date;
import java.util.ArrayList;

import com.library.model.Borrow;

public interface IBorrowDao {
	public Borrow findByruserid_bISBN(String ruserid, int bISBN);

	public ArrayList<Borrow> findByAllruserid(String ruserid);

	public int BorrowUpdateByruserid_bISBN(String ruserid, int bISBN);

	public Date theLastDate(ArrayList<Borrow> borrowList);

	public long subDate(Borrow borrow);

	public ArrayList<Borrow> findAll();

}
