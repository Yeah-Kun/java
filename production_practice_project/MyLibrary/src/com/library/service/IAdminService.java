/**
 * 2017年7月10日22:04:14
 * 管理员调用增删查改接口
 */
package com.library.service;

import com.library.model.Book;
import com.library.model.Reader;

public interface IAdminService {
	public boolean BookInsert(Book book);
	public boolean BookUpdate(Book book);
	public boolean BookDelete(Book book);
	public boolean ReaderInsert(Reader reader);
	public boolean ReaderUpdate(Reader reader);
	public boolean ReaderDelete(Reader reader);

}
