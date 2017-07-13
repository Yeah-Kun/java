package com.library.model;

public class Reader {
	private int id;
	private String name;
	private String userid;
	private int phone;
	private String depart;
	private int amount;
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String Userid) {
		this.userid = Userid;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Reader [id=" + id + ", name=" + name + ", userid=" + userid
				+ ", phone=" + phone + ", depart=" + depart + ", amount="
				+ amount + ", password=" + password + "]";
	}

}
