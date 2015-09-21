package ko.or.kosta.user.common;

import java.sql.Connection;

/**
 * Connection 생성 규격을 정의한 인터페이스
 * @author Lee Gwangyong
 *
 */
public interface ConnectionFactory {
	public Connection getConnection() throws Exception;
}
