package kr.or.kosta.springframework.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

import kr.or.kosta.springframework.bin.SpringAOPApplication;

/**
 * 핵심 비즈니스 로직에 공통적으로 적용할 로깅 기능
 * @author 김기정
 */
public class ConsoleLogger{
	
	Logger logger = Logger.getLogger(ConsoleLogger.class);
	
	/**
	 * Around Advice를 위한 메소드는 반드시 ProceedingJoinPoint를 매개변수로 선언해야 한다.
	 */
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
		// 비즈니스 메서드 호출 전 로그 출력
		String methodName = joinPoint.getSignature().toShortString();
		//System.out.println(methodName + " 메서드 실행 시작됨 >>>");
		logger.debug(methodName + " 메서드 실행 시작됨 >>>>>");
		
		long begin = System.currentTimeMillis();
		try{
			// proceed() 메소드를 호출함으로써 비즈니스 객체의 실제 메서드 호출하게 됨
			Object result = joinPoint.proceed();
			logger.debug(methodName + "  -- 메서드가 반환한 객체 : " + result);
			return result;
		}finally{
			// 비즈니스 메서드 호출 후 로그 출력(예외 발생시에도 실행)
			long end = System.currentTimeMillis();
			logger.debug(methodName + " 메서드 실행 종료됨 <<<<<");
			logger.debug(methodName + " 메서드 실행 시간 : " + (end - begin) + "ms");
		}
	}
}