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
	private Press press; // 出版社ID
	private Category category; // 分类ID
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
		this.ISBN = iSBN;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Press getPress() {
		return press;
	}
	public void setPress(Press press) {
		this.press = press;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", ISBN=" + ISBN
				+ ", price=" + price + ", press=" + press + ", category="
				+ category + "]";
	}

	
}
