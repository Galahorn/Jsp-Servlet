package Model;

public class messegeVO {

	private int bnum;	
	private String send_name;	
	private String recive_email;;	
	private String content;
	private String dates;

	public messegeVO(int bnum, String send_name, String recive_email, String content, String dates) {
		this.bnum = bnum;
		this.send_name = send_name;
		this.recive_email = recive_email;
		this.content = content;
		this.dates = dates;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getSend_name() {
		return send_name;
	}

	public void setSend_name(String send_name) {
		this.send_name = send_name;
	}

	public String getRecive_email() {
		return recive_email;
	}

	public void setRecive_email(String recive_email) {
		this.recive_email = recive_email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}
	
}
