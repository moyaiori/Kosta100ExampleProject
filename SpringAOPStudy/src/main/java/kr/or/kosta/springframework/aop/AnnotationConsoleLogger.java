package kr.or.kosta.springframework.aop;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Annotation 기반 Aspect 정의
 */
@Component
@Aspect
public class AnnotationConsoleLogger {
	
	Logger logger = Logger.getLogger(AnnotationConsoleLogger.class);

	/** 공통적으로 사용할 Pointcut 설정 */
	@Pointcut("execution(* kr.or.kosta.springframework.service..*.*(..))")
	public void consoleLogPointcut(){}
	
	/**
	 *  애노테이션을 이용한 Advice(공통기능+시점) 설정
	 *  @Around()
	 *  @Before()
	 *  @After()
	 *  @AfterReturnning()
	 *  @AfterThrowing()
	 */
	
	@Before("consoleLogPointcut()")	
	public void startLog(JoinPoint joinPoint){
		logger.debug("메소드 Start >>");
		// JoinPoint(메소드실행지점) 정보를 제공
		logger.debug("콜백객체 유형: " + joinPoint.getClass());
		logger.debug("타겟객체: " + joinPoint.getTarget());
		logger.debug("타겟객체의 호출 메소드: " + joinPoint.getSignature().toShortString());
		logger.debug("타겟객체의 호출 메소드 전달인자: " +joinPoint.getArgs());
		long start = System.currentTimeMillis();
	}
	
	
	@After("consoleLogPointcut()")	
	public void endLog(){
		long end = System.currentTimeMillis();
		logger.debug("메소드 End >>");
	}
	
	/** 메서드에 Pointcut 직접 설정 */
	@AfterReturning(pointcut="execution(public * org.kosta.myapp.aspect..*(..))", returning="returnValue")
	public void afterReturningLog(JoinPoint joinPoint, Object returnValue) {
		logger.debug("반환값: " + returnValue);
	}

	@AfterThrowing(pointcut="consoleLogPointcut()", throwing="exception")
	public void afterThrowingLog(JoinPoint joinPoint, Throwable exception){
		logger.warn("예외발생 : " + exception);
	}
	
	@Around("consoleLogPointcut()")
	public Object serviceAccessLog(ProceedingJoinPoint joinPoint) throws Throwable{
		// 호출 전후로 필요한 부가기능 추가
		String methodName = joinPoint.getSignature().toShortString();
		logger.debug(methodName + " 메서드 실행 시작됨 >>>");
		long begin = System.currentTimeMillis();
		try{
			Object result = joinPoint.proceed();
			logger.debug(methodName + "  -- 메서드가 반환한 객체 : " + result);
			return result;
		}finally{
			long end = System.currentTimeMillis();
			logger.debug(methodName + " 메서드 실행 종료됨 <<<");
			logger.debug(methodName + " 메서드 실행 시간 : " + (end - begin) + "ms");
		}
	}
}