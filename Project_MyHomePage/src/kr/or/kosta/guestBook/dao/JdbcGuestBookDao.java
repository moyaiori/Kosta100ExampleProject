package kr.or.kosta.guestBook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.kosta.user.domain.GuestBook;

public class JdbcGuestBookDao implements GuestBookDao{

	private DataSource dataSource;
	
	@Override
	public DataSource getDataSource() {
		return dataSource;
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void add(GuestBook guestBook) throws Exception {
		String sql = "INSERT INTO guestbook(guestbook_id, title, writer, content)" + 
					"VALUES (guestbook_seq.NEXTVAL, ?, ?, ?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, guestBook.getTitle());
			pstmt.setString(2, guestBook.getId());
			pstmt.setString(3, guestBook.getContent());
			pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			try {
				if (con != null) con.rollback();
			} catch (Exception e1) {
				throw new Exception("[Debug] : JdbcGuestBookDao.add()메소드 예외발생", e);
			}
		} finally {
			try {
				if (pstmt != null)pstmt.close();
				if (con != null)con.close();
			} catch (Exception e) {}
		}
	}
	

	@Override
	public List<GuestBook> getAll() throws Exception {
		GuestBook guestBook = null;
		List<GuestBook> resultList = new ArrayList<GuestBook>();
		String sql = "SELECT title, writer, content, TO_CHAR(regdate, 'YYYY.MM.DD HH24:MI') regdate " + 
				"FROM guestbook " + 
				"ORDER BY guestbook_id desc ";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				guestBook = new GuestBook();
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				String regdagte = rs.getString("regdate");
				
				guestBook.setTitle(title);
				guestBook.setId(writer);
				guestBook.setContent(content);
				guestBook.setDate(regdagte);
				resultList.add(guestBook);
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

}
