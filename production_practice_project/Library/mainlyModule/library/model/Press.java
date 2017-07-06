/*
 * 2017年7月3日16:17:43
 * 出版社表
 */
package library.model;

public class Press {
	private int id; // 出版社ID
	private String name = null; // 出版社名称
	private String adress = null; // 出版社地址
	private String url = null; // 出版社网址
	private String mail = null; // 出版社邮箱

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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Press [id=" + id + ", name=" + name + ", adress=" + adress
				+ ", url=" + url + ", mail=" + mail + "]";
	}

}
