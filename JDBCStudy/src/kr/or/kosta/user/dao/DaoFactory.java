package kr.or.kosta.user.dao;

import java.lang.reflect.Method;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
/**
 * Dao와 DataSource를 관리하는 공장
 * @author Lee Gwangyong
 *
 */
public abstract class DaoFactory {
	
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
