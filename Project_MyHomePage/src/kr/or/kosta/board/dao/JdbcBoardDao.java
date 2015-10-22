package kr.or.kosta.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.kosta.user.domain.Board;
import kr.or.kosta.user.domain.GuestBook;
import kr.or.kosta.user.domain.User;
import oracle.net.aso.b;

public class JdbcBoardDao implements BoardDao {

	private DataSource dataSource;
	
	@Override
	public DataSource getDataSource() {
		return dataSource;
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/** 글 쓰기 */
	public void wirte(Board board) throws Exception {
		String sql = "INSERT INTO article(article_id, board_id, writer, subject, content, ip, passwd, group_no, step_no, order_no) " + 
					"VALUES(article_id_seq.NEXTVAL, 1, ?, ?, ?, ?, ?, article_id_seq.CURRVAL, 0, 0) ";

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getSubject());
			pstmt.setString(3, board.getContent());
			pstmt.setString(4, board.getIp());
			pstmt.setString(5, board.getPasswd());
			pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			try {
				if (con != null) con.rollback();
			} catch (Exception e1) {
				throw new Exception("[Debug] : JdbcBoardDao.wirte()메소드 예외발생", e);
			}
		} finally {
			try {
				if (pstmt != null)pstmt.close();
				if (con != null)con.close();
			} catch (Exception e) {}
		}
	}

	/** 게시판 글목록 가져오기 */
	public List<Board> getList(int page) throws Exception {
		Board board = null;
		List<Board> resultList = new ArrayList<Board>();

		String sql = "SELECT " + page + ", article_id, subject, writer, regdate, ip, hitcount, group_no, step_no, order_no " + 
					"FROM ( "+
					"    SELECT CEIL(rownum / 5) request_page, article_id, subject, writer, TO_CHAR(regdate, 'YYYY-MM-DD') regdate, ip, hitcount, group_no, step_no, order_no "+
					"    FROM ( " +
					"       SELECT article_id, subject, writer, regdate, ip, hitcount, group_no, step_no, order_no " +
					"       FROM article " + 
					"       WHERE board_id = 1" + 
					"       ORDER BY group_no DESC, order_no ASC" + 
					"   ) " + 
					") " +
					"WHERE request_page = " + page + " ";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				board = new Board();
				
				board.setArticle_id(rs.getString("article_id"));
				board.setSubject(rs.getString("subject"));
				board.setWriter(rs.getString("writer"));
				board.setRegdate(rs.getString("regdate"));
				board.setIp(rs.getString("ip"));
				board.setHitcount(rs.getString("hitcount"));
				board.setGroup_no(rs.getString("group_no"));
				board.setStep_no(rs.getString("step_no"));
				board.setOrder_no(rs.getString("order_no"));
				
				resultList.add(board);
			}
		} catch (Exception e) {
			throw new Exception("[Debug] : JdbcGuestBookDao.getAll() 메소드 예외발생", e);
		}finally {
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e){}
		}
		return resultList;
	}
	
	/* 게시판 글 페이지수 가져오기 */
	public int getPageNum() throws Exception{
		int page = 0;
		String sql = "Select  COUNT(rowNum) " + 
					 "from article " + 
					 "WHERE  board_id = 1 ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()){
				page = Integer.parseInt(rs.getString("COUNT(rowNum)"));
			}
			
		} catch (Exception e) {
			throw new Exception("[Debug] : JdbcBoardDao.getPageNum() 메소드 예외발생", e);
		}finally {
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e){}
		}
		
		return page;
	}
	

	/** 글 읽기 */
	@Override
	public Board getArticle(String articleId) throws Exception {
		//System.out.println("articleId : " + articleId);
		Board board = null;
		String sql = "SELECT writer, subject, content, ip, passwd, regdate, hitcount " + 
					"FROM article " + 
					"WHERE article_id = ? AND board_id = 1";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, articleId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				board = new Board();
				
				board.setWriter(rs.getString("writer"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setIp(rs.getString("ip"));
				board.setPasswd(rs.getString("passwd"));
				board.setRegdate(rs.getString("regdate"));
				board.setHitcount(rs.getString("hitcount"));
				
			}} catch (Exception e) {
				e.printStackTrace();
			throw new Exception("[Debug] : JdbcBoardDao.getArticle() 메소드 예외발생", e);
		}finally {
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e){}
		}
		return board;
	}
	
	/** 조회수 증가 */
	public void updateHitCount(String article_id) throws Exception{
		String sql = "UPDATE article " + 
					 "SET hitcount = hitcount + 1 " +
					 "WHERE board_id = 1 AND article_id = " + article_id + " ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			try {
				if (con != null) con.rollback();
			} catch (Exception e1) {
				throw new Exception("[Debug] : JdbcBoardDao.updateHitCount()메소드 예외발생", e);
			}
		} finally {
			try {
				if (pstmt != null)pstmt.close();
				if (con != null)con.close();
			} catch (Exception e) {}
		}
	}
	
	/** 검색 */
	public List<Board> searchArticle(String keyWord, String type ,int pageNum) throws Exception{
		Board board = null;
		List<Board> reultList = new ArrayList<Board>();
		
		String sqlHeader = "SELECT request_page, article_id, subject, writer, regdate, ip, hitcount, step_no " + 
				 "FROM ( " + 
				 "SELECT CEIL(rownum / 5) request_page, article_id, subject, writer, TO_CHAR(regdate, 'YYYY-MM-DD') regdate, ip, hitcount, step_no " + 
					 "FROM ( " + 
					 "SELECT rownum, article_id, subject, writer, regdate, ip, hitcount, step_no " +
					 "FROM article " +
					 "WHERE board_id = 1 AND ";
		
		String sqlBoady = null;
		if (type.equals("title")) {
			sqlBoady = "subject LIKE '%" + keyWord + "%' ";
		}else if(type.equals("content")){
			sqlBoady = "content LIKE '%" + keyWord + "%' ";
		}else if(type.equals("id")){
			sqlBoady = "writer = " + keyWord;
		}
		
		String sqlFooter = "ORDER BY group_no DESC, order_no ASC " + 
				 "   ) " + 
			 ") " +         
			 "WHERE request_page = " + pageNum + " ";
		
		String sql = sqlHeader + sqlBoady + sqlFooter;
		
		/*
		StringBuilder sql = new StringBuilder();
		sql.append(sqlHeader);
		sql.append(sqlBoady);
		sql.append(sqlFooter);
		*/
		System.out.println("sql : " + sql);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				board = new Board();
				
				board.setArticle_id("article_id");
				board.setWriter(rs.getString("writer"));
				board.setSubject(rs.getString("subject"));
				board.setIp(rs.getString("ip"));
				board.setRegdate(rs.getString("regdate"));
				board.setHitcount(rs.getString("hitcount"));
				board.setStep_no(rs.getString("step_no"));
				
				reultList.add(board);
			}} catch (Exception e) {
				e.printStackTrace();
			throw new Exception("[Debug] : JdbcBoardDao.searchArticleTitle() 메소드 예외발생", e);
		}finally {
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e){}
		}
		
		System.out.println("searchArticleTitle.reultList : " + reultList);
		
		return reultList;
		
	}
	
	
	/** 검색된 페이지 숫자 반환  */
	public int searchArticlePage(String keyWord, String type) throws Exception{
		int page = 0;
		String whereWord = null;

		if (type.equals("title")) {
			whereWord = "WHERE subject LIKE '%" + keyWord + "%' ";
		}else if(type.equals("content")){
			whereWord = "WHERE content LIKE '%" + keyWord + "%' ";
		}else if(type.equals("id")){
			whereWord = "WHERE writer = " + keyWord;
		}
		
		String sql = "SELECT COUNT(rowNum)  " + 
					 "FROM ( " + 
						 "SELECT rownum, article_id, subject, writer " +
						 "FROM article " +
						 whereWord + 
						 "ORDER BY group_no DESC, order_no ASC " + 
					 "   ) ";
		
//		System.out.println("sql : " + sql);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				page = Integer.parseInt(rs.getString("COUNT(rowNum)"));
			}} catch (Exception e) {
				e.printStackTrace();
			throw new Exception("[Debug] : JdbcBoardDao.searchArticle() 메소드 예외발생", e);
		}finally {
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e){}
		}
		System.out.println("searchArticlePage.page : " + page);
		return page;
	}
	
}
















