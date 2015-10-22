package kr.or.kosta.reply.dao;

import java.util.List;

import javax.sql.DataSource;

import kr.or.kosta.user.domain.Board;
import kr.or.kosta.user.domain.User;

/**
 * 영속성 처리 기술에 상관없이 일관된 방법으로
 * 데이터 처리가 가능하게 하기 위한 규격
 * @author Lee Gwangyong
 *
 */
public interface ReplyDao {
	
	public DataSource getDataSource();

	public void setDataSource(DataSource dataSource);

	/** 답글쓰기 */
	public void reply(Board board) throws Exception;
	
}