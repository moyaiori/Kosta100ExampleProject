package kr.or.kosta.ems.common.dao;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Method;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.kosta.ems.employee.dao.MybatisEmployeeDao;

/**
 * Mybatis 기술을 사용하는 각각의 DAO를 생성하고 
 * 생성된 DAO에 SqlSessionFactory를 생성하여 설정
 * @author Lee Gwangyong
 *
 */
public class MybatisDaoFactory extends DaoFactory {
	
	// myBatis 환경설정파일 경로
	private static String resource = "resource/config/mybatis-config.xml";
	
	public SqlSessionFactory createSqlSessionFactory() throws IOException{
		Reader reader = null;
		reader = Resources.getResourceAsReader(resource);
		
		// SqlSessionFactoryBuilder를 이용한 SqlSessionFactory 생성
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		
		return sqlSessionFactory;
	}

	@Override
	public Object getDao(String className) throws Exception {
		Object dao = null;
		SqlSessionFactory sqlSessionFactory = createSqlSessionFactory();
		
		try {
			dao = Class.forName(className).newInstance();
			System.out.println("dao : " + dao.getClass());
			Method m = dao.getClass().getMethod("setSqlSessionFactory", SqlSessionFactory.class);
			m.invoke(dao, sqlSessionFactory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dao;
	}

	@Override
	public Object getDao(Class cls) throws Exception {
		// TODO Auto-generated method stub
		return getDao(cls.getName());
	}

}
