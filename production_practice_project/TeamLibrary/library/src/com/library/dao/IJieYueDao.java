package com.library.dao;

import java.util.ArrayList;

import com.library.model.JieYue;

public interface IJieYueDao {
	public ArrayList<JieYue> findByName(String sname);
	
	public JieYue findByBookISBN(int id);
}
