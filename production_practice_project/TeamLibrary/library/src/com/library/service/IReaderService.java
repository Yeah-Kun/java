/**
 * 2017年7月10日22:01:21
 * 读者类信息接口
 */
package com.library.service;

import java.sql.Date;

import com.library.model.Reader;

public interface IReaderService {
	public int readerSum();
	public Date theLastBorrow();
	public Reader findByReader_userid(String  userid);// 通过用户名找读者信息
	public Reader findByReader_name(String name); // 通过姓名
}
