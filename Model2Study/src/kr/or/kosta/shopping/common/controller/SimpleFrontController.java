package kr.or.kosta.shopping.common.controller;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.shopping.hello.controller.HelloController;
import kr.or.kosta.shopping.hello.controller.TodayController;

/**
 * 
 * 모든 웹 클라이언트 단일(메인) 진입점 역할의 프론트 컨트롤러 서블릿
 * 메인 컨트롤러
 * @author  김기정
 */
public class SimpleFrontController extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException {
		process(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException {
		process(request, response);
	}
	
	public void process(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException {
		/** 모든 액션 객체들의 공통 기능 처리 */
		// 모든 요청데이터 한글 처리
		request.setCharacterEncoding("utf-8");
		
		// 요청(브라우저 명령) 분석
		String uri = request.getRequestURI();
		
		// 확장자 형식 매핑시..
		// /appName/hello.mall -> /hello
		// /appName/board/list.do -> /board/list
		String applicationName = request.getContextPath();
		uri = uri.substring(applicationName.length(), uri.lastIndexOf("."));
		System.out.println("[Debug] : 요청 URI: " + uri);
		
		// 요청에 따른 비즈니스 처리 및 응답
		Controller controller = null;
		ModelAndView mav = null;
		
		if(uri.equalsIgnoreCase("/hello")){
			//handleHello(request, response);
			controller = new HelloController();
		}else if(uri.equalsIgnoreCase("/some")){
			//controller = new SomeController();
		}else if(uri.equalsIgnoreCase("/today")){
			controller = new TodayController();
		}
		
		if(controller == null){
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		// 커맨드 패턴
		mav = controller.handleRequest(request, response);
		
		// request객체에 모델 저장
		Map<String, Object> map = mav.getMap();
		Set<String> keySet =  map.keySet();
		for (String key : keySet) {
			Object value = map.get(key);
			request.setAttribute(key, value);
		}
		
		request.getRequestDispatcher(mav.getView()).forward(request, response);
	}
	
	
	// 요청에 대한 처리 메소드
	/*
	private void handleHello(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException {
		//String message = xxxService.bizMethod();
		String message = "모델2 기반 웹애플리케이션 개발";
		request.setAttribute("message", message);
		request.getRequestDispatcher("/hello.jsp").forward(request, response);
	}
	*/
	
	
	
}










