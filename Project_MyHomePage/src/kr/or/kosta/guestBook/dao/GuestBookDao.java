package kr.or.kosta.guestBook.dao;

import java.util.List;

import javax.sql.DataSource;

import kr.or.kosta.user.domain.GuestBook;

public interface GuestBookDao {
	
	public DataSource getDataSource();
	
	public void setDataSource(DataSource dataSource);
	
	// 게시판 등록
	public void add(GuestBook guestBook) throws Exception;
	
	// 모든 게시판 리스트 가져오기
	public List<GuestBook> getAll() throws Exception;

}
