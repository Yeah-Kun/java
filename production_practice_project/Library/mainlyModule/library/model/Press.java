/*
 * 2017��7��3��16:17:43
 * �������
 */
package library.model;

public class Press {
	private int id; // ������ID
	private String name = null; // ����������
	private String adress = null; // �������ַ
	private String url = null; // ��������ַ
	private String mail = null; // ����������

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
