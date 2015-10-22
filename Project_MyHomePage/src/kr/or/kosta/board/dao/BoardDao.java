package kr.or.kosta.board.dao;

import java.util.List;

import javax.sql.DataSource;

import kr.or.kosta.user.domain.Board;

public interface BoardDao {
	
	public DataSource getDataSource();

	public void setDataSource(DataSource dataSource);
	
	/** 게시판 글쓰기 */
	public void wirte(Board board) throws Exception;
	
	/** 게시판 리스트 가져오기 */
	public List<Board> getList(int page) throws Exception;
	
	/** 게시판 페이지수 가져오기 */
	public int getPageNum() throws Exception;
	
	/** 게시판 내용 가져오기 */
	public Board getArticle(String articleId) throws Exception;

	/** 검색된 페이지 숫자 반환  */
	public int searchArticlePage(String keyWord, String type) throws Exception;
		
	/** 검색 페이지 반환 */
	public List<Board> searchArticle(String keyWord, String type ,int pageNum) throws Exception;
}
