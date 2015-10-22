package kr.or.kosta.shopping.common.dao;

import java.lang.reflect.Method;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
/**
 * Dao와 DataSource를 관리하는 공장
 * @author Lee Gwangyong
 *
 */
public abstract class DaoFactory {
	
	private static JdbcDaoFactory instatce;
	
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
//			factory = new MyBatisDaoFactory();
			// 차후 인스턴스 변수 추가해서 위와같은 형태로 바꾸어주어야함
			break;
			
		case HIBERNATE:
//			factory = new HibernateDaoFactory();
			break;
		}
		return null;
	}
	
	public Object getDao(String className){
		Object dao = null;
		//전달된 클래스 이름에 해당하는 객체 생성
		DataSource dataSource = createConnectionFactory();
		
		try {
			dao = Class.forName(className).newInstance();
			System.out.println("dao : " + dao.getClass());
			Method m = dao.getClass().getMethod("setDataSource", DataSource.class);
			m.invoke(dao, dataSource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}
	
	// 클래스명 반환하기
	public Object getDao(Class cls) throws Exception{
		return getDao(cls.getName());
	}
	
	/**
	 * Connectionpool을 지원하는 DataSource 생성
	 */
	public abstract BasicDataSource createConnectionFactory();
	
}
