package kr.or.kosta.shopping.common.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class JdbcDaoFactory extends DaoFactory {
	
//	private static String DB_CONFIG = "I:/KOSTA100/workspace/ServletStudy/src/config/db.properties";
	
	private static String DRIVER_NAME = null;
	private static String DB_URL = null;
	private static String USER_ID = null;
	private static String USER_PW = null;
	private static int MAX_COUNT = 0;
	private static int IDLE_COUNT = 0;
	
	static {
		URL fileUrl = JdbcDaoFactory.class.getResource("/config/db.properties");
		Properties properties = new Properties();
		FileInputStream in = null;
		
		try {
			in = new FileInputStream(fileUrl.getFile());
			properties.load(in);
			DRIVER_NAME = properties.getProperty("DRIVER_NAME");
			DB_URL = properties.getProperty("DB_URL");
			USER_ID = properties.getProperty("USER_ID");
			USER_PW = properties.getProperty("USER_PW");
			MAX_COUNT = Integer.valueOf(properties.getProperty("MAX_COUNT"));
			IDLE_COUNT = Integer.valueOf(properties.getProperty("IDLE_COUNT"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}

	@Override
	public BasicDataSource createConnectionFactory() {

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DRIVER_NAME);
		dataSource.setUrl(DB_URL);
		dataSource.setUsername(USER_ID);
		dataSource.setPassword(USER_PW);
		dataSource.setInitialSize(Integer.valueOf(MAX_COUNT));
		dataSource.setInitialSize(Integer.valueOf(IDLE_COUNT));
		
		return dataSource;
	}

}
