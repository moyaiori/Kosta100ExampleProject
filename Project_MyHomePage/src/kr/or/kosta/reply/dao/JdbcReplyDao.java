package kr.or.kosta.reply.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import javafx.scene.layout.Border;
import kr.or.kosta.user.domain.Board;

/**
 * jdbc 기술을 이용하여 UserDao 규격을 구현한 Dao
 * @author Lee Gwangyong
 *
 */
public class JdbcReplyDao implements ReplyDao{
	
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/** 답글 쓰기 */
	@Override
	// 여기서 보드는 자신이 달고자하는 답글의 부모글의 article_id 와 답글의 내용
	public void reply(Board board) throws Exception {
		String sql = "INSERT INTO article(article_id, board_id, writer, subject, content, ip, passwd, group_no, step_no, order_no) " + 
						"VALUES(article_id_seq.NEXTVAL, 1, ?, ?, ?, ?, ?, ?, ?, ?) ";

		Connection con = null;
		PreparedStatement pstmt = null;
		
		Board parentBoard = getParentsNum(board.getArticle_id());		// 부모의 그룹, 스탭, 오더, 고유번호를 가져온다
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getSubject());
			pstmt.setString(3, board.getContent());
			pstmt.setString(4, board.getIp());
			pstmt.setString(5, board.getPasswd());
			pstmt.setString(6, parentBoard.getGroup_no());	// 현재 부모글의 글 고유번호를 그룹번호로 준다.
			parentBoard.setSubject(board.getSubject());
			pstmt.setInt(7, getStepNum(parentBoard.getArticle_id()));		// 현재 글의 스탭을 가져온다. 무조건 부모글의 스탭번호 + 1 이다
			
			
			
			pstmt.setInt(8, getChildOrderNum(parentBoard));		// 현재 부모의 자신외에 자식들이 있다면 그중에 가장 낮은 오더넘버를 가져온 아이를 찾는다
			//updateOrderReply(parentBoard.getGroup_no(), getChildOrderNum(parentBoard));
			
			pstmt.executeUpdate();
			con.commit();
			
		} catch (Exception e) {
			try {
				if (con != null) con.rollback();
			} catch (Exception e1) {
				e.printStackTrace();
				throw new Exception("[Debug] : JdbcReplyDao.reply()메소드 예외발생", e);
			}
		} finally {
			try {
				if (pstmt != null)pstmt.close();
				if (con != null)con.close();
			} catch (Exception e) {}
		}
	}
	
	// 부모의 3가지 정렬정보 가져오기
	public Board getParentsNum(String article_id) throws Exception{
		Board resultBoard = null;
		String sql = "SELECT group_no, step_no, order_no "
					+ "FROM article "
					+ "WHERE article_id = ? ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article_id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				resultBoard = new Board();
				resultBoard.setGroup_no(rs.getString("group_no"));
				resultBoard.setStep_no(rs.getString("step_no"));
				resultBoard.setOrder_no(rs.getString("order_no"));
				resultBoard.setArticle_id(article_id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("[Debug] : JdbcGuestBookDao.getParentsNum() 메소드 예외발생", e);
		}finally {
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e){}
		}
		return resultBoard;
	}
	
	// 현재 달고자하는 글의 자식들중 가장작은 오더번호 가져오기
	// 여기서 메게변수는 현재 답글을 달고자하는 부모의 정렬 정보
	// getParentsNum() 을 통해서 가져온다.
	public int getChildOrderNum(Board board) throws Exception{
		int resultOrderNum = 0;
		String sql = "SELECT MAX(order_no) "
					+ "FROM article "
					+ "WHERE ? >= ? AND group_no = ?";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, board.getStep_no());
			pstmt.setString(2, board.getStep_no());
			pstmt.setString(3, board.getGroup_no());
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				resultOrderNum = rs.getInt("MAX(order_no)");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("[Debug] : JdbcReplyDao.getChildOrderNum() 메소드 예외발생", e);
		}finally {
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e){}
		}
		
		if(Integer.parseInt(board.getOrder_no()) == resultOrderNum){
			resultOrderNum++;
		}
		return resultOrderNum;
	}
	
	/** 현재 추가되는 답글 자식들의 order_no + 1 해주기*/
	// 현재 부모의 그룹번호
	// 자신의 밑에 애들중 가장 높은 오더 번호
	public void updateOrderReply(String group_no, int order_no) throws Exception{
		//		updateOrderReply(parentBoard.getGroup_no(), getChildOrderNum(parentBoard));
		String sql = "UPDATE ("
						+ " SELECT order_no "
						+ "	FROM article "
						+ " WHERE group_no = ? AND order_no >= ? "
						+ ") "
						+ "SET order_no = order_no + 1 ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, group_no);
			pstmt.setInt(2, order_no);
			
			pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			try {
				if (con != null) con.rollback();
			} catch (Exception e1) {
				throw new Exception("[Debug] : JdbcReplyDao.updateOrderReply()메소드 예외발생", e);
			}
		} finally {
			try {
				if (pstmt != null)pstmt.close();
				if (con != null)con.close();
			} catch (Exception e) {}
		}
		
	}
	
	/** 현재글의 스탭 + 1 가져오기 */
	public int getStepNum(String article_id) throws Exception{
		int stepNum = 0;
		String sql = "SELECT step_no "
					+"FROM article "
					+"WHERE article_id = ? ";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, article_id);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				stepNum = rs.getInt("step_no");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("[Debug] : JdbcGuestBookDao.getAll() 메소드 예외발생", e);
		}finally {
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e){}
		}
		return stepNum + 1;
	}
	
}


