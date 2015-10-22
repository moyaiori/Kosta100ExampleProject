package kr.or.kosta.example;

import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * Log4J 사용하기
 * log4j-1.2.17.jar 클래스패스 설정
 * Log4J 설정파일 위치: src/log4j.xml
 * @author 김기정(金基正)
 *
 */
public class Log4JExample {
	public static void main(String[] args) throws IOException {
		// LoggerFactory로부터 Logger 생성
		Logger logger = Logger.getLogger(Log4JExample.class);
		
		logger.trace("DEBUG 보다 더 상세한 정보를 출력");
		logger.debug("애플리케이션의 내부 실행 상황을 추적하기 위해 상세 정보 출력");
		logger.info("애플리케이션의 주요 실행 정보 출력");
		logger.warn("잠재적인 위험(에러)를 안고 있는 상태일 때 출력(경고)");
		logger.error("오류가 발생했지만, 애플리케이션은 계속 실행할 수 있을 때 출력");
		logger.fatal("애플리케이션을 중지해야 할 가장 심각한 에러가 발생 했을 때 출력");
	}
}
