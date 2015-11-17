package kr.or.kosta.springmvc.common.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/*
 * 로그를 기록하는 인터셉터
 * @author 김기정
 */
public class LoggerInterceptor extends HandlerInterceptorAdapter {
	
	Logger logger = Logger.getLogger(LoggerInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.debug(handler.toString() + " 실행됨 >>>");		
		return true;
	}
}
