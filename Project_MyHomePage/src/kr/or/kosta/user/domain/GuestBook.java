package kr.or.kosta.user.domain;

public class GuestBook {
	private String content;
	private String id;
	private String title;
	private String date;

	public GuestBook(){}
	
	public GuestBook(String content, String id, String title, String date) {
		super();
		this.content = content;
		this.id = id;
		this.title = title;
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "GuestBook [content=" + content + ", id=" + id + ", title=" + title + ", date=" + date + "]";
	}
	
	
}
