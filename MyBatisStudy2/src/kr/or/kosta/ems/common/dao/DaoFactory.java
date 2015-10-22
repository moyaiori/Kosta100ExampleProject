package kr.or.kosta.ems.common.dao;

import java.lang.reflect.Method;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
/**
 * Dao와 DataSource를 관리하는 공장
 * @author Lee Gwangyong
 *
 */
public abstract class DaoFactory {
	
	private static DaoFactory instatce;
	
	public enum DaoFactoryType{
		JDBC, MYBATIS, HIBERNATE
	}
	
	public static DaoFactory getInstance(DaoFactoryType type){
		switch (type) {
		case JDBC:
			if (instatce == null) {	// 싱글톤 방식으로 1개만 객체가 생성되도록 체크
				synchronized (JdbcDaoFactory.class) { // 동기화 처리
					instatce = new JdbcDaoFactory();
				}
			}
			return instatce;
			
		case MYBATIS:
			if (instatce == null) {	// 싱글톤 방식으로 1개만 객체가 생성되도록 체크
				synchronized (JdbcDaoFactory.class) { // 동기화 처리
					instatce = new MybatisDaoFactory();
				}
			}
			return instatce;
			
		case HIBERNATE:
//			factory = new HibernateDaoFactory();
			break;
		}
		return null;
	}
	
	/** 요청한 클래스 이름에 해당되는 DAO 반환 */
	public abstract Object getDao(String className) throws Exception; 
	public abstract Object getDao(Class cls) throws Exception;
	
}
