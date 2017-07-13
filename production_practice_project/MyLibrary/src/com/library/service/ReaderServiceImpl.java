package com.library.service;

import java.sql.Date;
import java.util.ArrayList;

import com.library.dao.BorrowDaoImpl;
import com.library.dao.ReaderDaoImpl;
import com.library.model.Borrow;
import com.library.model.Reader;

public class ReaderServiceImpl implements IReaderService {
	ReaderDaoImpl rdi = new ReaderDaoImpl();
	BorrowDaoImpl bwdi = new BorrowDaoImpl();

	@Override
	public int readerSum() {
		// TODO 自动生成的方法存根
		int sum = 0;
		ArrayList<Reader> readerList = new ArrayList<Reader>();
		readerList = rdi.findAll();
		for (Reader reader : readerList) {
			sum++;
		}
		return sum;
	}

	@Override
	public Date theLastBorrow() {
		// TODO 自动生成的方法存根
		Date theLastDate = null;
		ArrayList<Borrow> borrowList = new ArrayList<Borrow>();
		borrowList = bwdi.findAll();
		theLastDate = bwdi.theLastDate(borrowList);
		return theLastDate;
	}

	@Override
	public Reader findByReader_userid(String userid) {
		// TODO 自动生成的方法存根
		return rdi.findByUserid(userid);
	}

	@Override
	public Reader findByReader_name(String name) {
		// TODO 自动生成的方法存根
		return rdi.findByName(name);
	}

}
