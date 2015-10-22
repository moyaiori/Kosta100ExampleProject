package ko.or.kosta.user.common;

import java.lang.reflect.Method;

import javax.sql.DataSource;

/**
 * 다양한 종류의 Dao 생성 및 생성된 Dao에 DataSource 설정 및
 * 생성된 Dao 제공해주는 추상 Factory
 * @author 김기정
 *
 */
public abstract class DaoFactory {

	/** 요청한 클래스이름에 해당하는 Dao 생성 반환 */
	public Object getDao(String className) throws Exception{
		Object dao = null;
		try{
			// 전달된 클래스이름에 해당하는 객체 동적 생성
			dao = Class.forName(className).newInstance();
			// DataSource 생성
			DataSource dataSource = createDataSource();
			// 객체간 의존관계 설정
			//dao.setDataSource(dataSource);
			// 리플렉션의 메소드 동적 호출 사용...
			Method method = dao.getClass().getMethod("setDataSource", DataSource.class);
			method.invoke(dao, dataSource);
		}catch(ClassNotFoundException ex){
			throw new Exception("생성하고자 하는 클래스가 존재하지 않습니다.", ex);
		}
		return dao;
	}
	
	public Object getDao(Class cls) throws Exception{
		return getDao(cls.getName());
	}
	
	
	/** ConnectionPool을 지원하는 DataSource 생성 */
	public abstract DataSource createDataSource();
	
}
