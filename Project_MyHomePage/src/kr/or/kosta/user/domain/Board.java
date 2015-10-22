package kr.or.kosta.user.domain;

public class Board {
	String article_id;	// 게시글 식별번호
	String writer;		// 작성자
	String subject;		// 글제목
	String content;		// 글내용
	String regdate;		// 글작성일
	String hitcount;	// 조회수
	String ip;			// 작성자 IP
	String passwd;		// 비밀번호
	String file;		// 첨부파일
	String group_no;	// 부모글의 번호
	String step_no;		// 답글 단계 번호
	String order_no;	// 정렬번호
	
	public Board(){}

	public Board(String article_id, String writer, String subject, String content, String regdate, String hitcount,
			String ip, String passwd, String file, String group_no, String step_no, String order_no) {
		super();
		this.article_id = article_id;
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.regdate = regdate;
		this.hitcount = hitcount;
		this.ip = ip;
		this.passwd = passwd;
		this.file = file;
		this.group_no = group_no;
		this.step_no = step_no;
		this.order_no = order_no;
	}

	public String getArticle_id() {
		return article_id;
	}

	public void setArticle_id(String article_id) {
		this.article_id = article_id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getHitcount() {
		return hitcount;
	}

	public void setHitcount(String hitcount) {
		this.hitcount = hitcount;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getGroup_no() {
		return group_no;
	}

	public void setGroup_no(String group_no) {
		this.group_no = group_no;
	}

	public String getStep_no() {
		return step_no;
	}

	public void setStep_no(String step_no) {
		this.step_no = step_no;
	}

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Board [article_id=" + article_id + ", writer=" + writer + ", subject=" + subject + ", content="
				+ content + ", regdate=" + regdate + ", hitcount=" + hitcount + ", ip=" + ip + ", passwd=" + passwd
				+ ", file=" + file + ", group_no=" + group_no + ", step_no=" + step_no + ", order_no=" + order_no + "]";
	}

	
}
