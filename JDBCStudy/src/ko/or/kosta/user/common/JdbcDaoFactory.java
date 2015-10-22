package ko.or.kosta.user.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class JdbcDaoFactory extends DaoFactory {
	
	// DB 연결정보 환경설정파일 경로
	private static final String CONFIG_PATH = "classes/config/db.properties";
	
	private static String DRIVER_NAME = null;
	private static String DB_URL = null;
	private static String USER_ID = null;
	private static String USER_PW = null;
	private static int INITIAL_SIZE = 0;
	private static int MAX_IDLE_SIZE = 0;
	
	static {
		Properties prop = new Properties();
		InputStream in = null;
		try {
			in = new FileInputStream(CONFIG_PATH);
			prop.load(in);
			DRIVER_NAME = prop.getProperty("DRIVER_NAME");
			DB_URL = prop.getProperty("DB_URL");
			USER_ID = prop.getProperty("USER_ID");
			USER_PW = prop.getProperty("USER_PW");
			INITIAL_SIZE = Integer.parseInt(prop.getProperty("INITIAL_SIZE"));
			MAX_IDLE_SIZE = Integer.parseInt(prop.getProperty("MAX_IDLE_SIZE"));
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) in.close();
			} catch (IOException e) {}
		}
	}
	
	@Override
	public DataSource createDataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DRIVER_NAME);
		dataSource.setUrl(DB_URL);
		dataSource.setUsername(USER_ID);
		dataSource.setPassword(USER_PW);
		dataSource.setInitialSize(INITIAL_SIZE);
		dataSource.setMaxIdle(MAX_IDLE_SIZE);
		return dataSource;
	}
}
