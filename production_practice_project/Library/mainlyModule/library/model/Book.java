/*
 * 2017��7��3��16:19:20
 * ͼ�����¼ͼ�������Ϣ
 */
package library.model;

public class Book {
	private int id; // ͼ��ID
	private String name; // ͼ������
	private String ISBN; // ͼ�����
	private double price; // ͼ��۸�
	private int pressID; // ������ID
	private int categoryID; // ����ID

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

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPressID() {
		return pressID;
	}

	public void setPressID(int pressID) {
		this.pressID = pressID;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

}
