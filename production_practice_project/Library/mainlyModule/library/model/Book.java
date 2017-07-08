/**
 * 2017��7��3��16:19:20
 * ͼ�����¼ͼ�������Ϣ
 */
package library.model;

public class Book {
	private int id; // ͼ��ID
	private String name; // ͼ������
	private String ISBN; // ͼ�����
	private double price; // ͼ��۸�
	private Press press; // ������ID
	private Category category; // ����ID
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
