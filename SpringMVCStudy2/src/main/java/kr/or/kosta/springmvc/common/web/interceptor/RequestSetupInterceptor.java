package kr.or.kosta.springmvc.common.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/*
 * request에 JSP에서 필요로 하는 공통 속성을 추가해 놓는 인터셉터
 * @author 김기정
 */
public class RequestSetupInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// ContextPath(애플리케이션 이름)
		request.setAttribute("context", request.getContextPath());
		
		// 요청된 실제 URL
		request.setAttribute("url", request.getRequestURL());
			
		// 요청 페이지를 호출한 페이지 URL
		request.setAttribute("referer", request.getHeader("referer"));
		
		return true;
	}
}
