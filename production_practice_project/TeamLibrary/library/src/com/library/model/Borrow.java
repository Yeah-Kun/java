package com.library.model;

import java.sql.Date;

public class Borrow {
	private int id;
	private String ruserid;
	private int bISBN;
	private int isborrow;
	private Date bortime;
	private Date reptime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRuserid() {
		return ruserid;
	}

	public void setRuserid(String ruserid) {
		this.ruserid = ruserid;
	}

	public int getbISBN() {
		return bISBN;
	}

	public void setbISBN(int bISBN) {
		this.bISBN = bISBN;
	}

	public int getIsborrow() {
		return isborrow;
	}

	public void setIsborrow(int isborrow) {
		this.isborrow = isborrow;
	}

	public Date getBortime() {
		return bortime;
	}

	public void setBortime(Date bortime) {
		this.bortime = bortime;
	}

	public Date getReptime() {
		return reptime;
	}

	public void setReptime(Date reptime) {
		this.reptime = reptime;
	}

	@Override
	public String toString() {
		return "Borrow [id=" + id + ", ruserid=" + ruserid + ", bISBN=" + bISBN
				+ ", isborrow=" + isborrow + ", bortime=" + bortime
				+ ", reptime=" + reptime + "]";
	}

}
