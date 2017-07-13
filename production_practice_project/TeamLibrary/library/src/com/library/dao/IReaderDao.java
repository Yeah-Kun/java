package com.library.dao;

import java.util.ArrayList;

import com.library.model.Reader;

public interface IReaderDao {
	public Reader findByUserid(String userid);
	public Reader findByName(String name);
	public ArrayList<Reader> findAll();
	public int ReaderInsert(Reader reader);
	public int ReaderUpdate(Reader reader);
	public int ReaderDelete(Reader reader);

}
