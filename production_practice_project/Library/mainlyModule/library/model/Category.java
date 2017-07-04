/*
 * 2017年7月3日16:21:18
 * 图书分类表，图书含有不同的类型，比如经济、人文、社科、军事
 */
package library.model;

public class Category {
	private int id; // 类型ID
	private String name; // 类型名称

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

}
