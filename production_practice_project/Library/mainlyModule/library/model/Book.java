/**
 * 2017年7月3日16:19:20
 * 图书表，记录图书基本信息
 */
package library.model;

public class Book {
	private int id; // 图书ID
	private String name; // 图书名称
	private String ISBN; // 图书编码
	private double price; // 图书价格
	private int pressID; // 出版社ID
	private int categoryID; // 分类ID

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

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", ISBN=" + ISBN
				+ ", price=" + price + ", pressID=" + pressID + ", categoryID="
				+ categoryID + "]";
	}

	
}
