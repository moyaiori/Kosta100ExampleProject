package kr.or.kosta.shopping.common.controller;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 모든 웹 클라이언트 단일(메인) 진입점 역할의 프론트 컨트롤러 서블릿 메인 컨트롤러
 * 
 * @author 김기정
 */
public class FrontControllerServlet extends HttpServlet {

	private ControllerFactory controllerFactory;

	public void init() throws ServletException {
		// 컨트롤러 설정 파일 패스
//		String configPath = "I:/KOSTA100/workspace/Model2Study/WebContent/WEB-INF/controllerMapping.properties";
		String configPath = getInitParameter("controllerMapping");
		controllerFactory = ControllerFactory.getInstance(configPath);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		process(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		process(request, response);
	}

	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		/** 모든 액션 객체들의 공통 기능 처리 */
		// 모든 요청데이터 한글 처리
		request.setCharacterEncoding("utf-8");

		// 요청(브라우저 명령) 분석
		String uri = request.getRequestURI();

		// 확장자 형식 매핑시..
		// /appName/hello.do -> /hello
		// /appName/board/list.do -> /board/list
		String applicationName = request.getContextPath();
		uri = uri.substring(applicationName.length(), uri.lastIndexOf("."));
		System.out.println("[Debug] : 요청 URI: " + uri);

		Controller controller = null;
		ModelAndView mav = null;

		// 팩토리로부터 필요한 컨트롤러 오브젝트 검색
		controller = controllerFactory.getController(uri);
		
		ViewResolver viewResolver = new JSPViewResolver();
		// ViewResolver viewResolver = new XXXViewResolver();
		
		if (controller == null) {
			//response.sendError(HttpServletResponse.SC_NOT_FOUND);
			//return;
			viewResolver.execute(request, response, uri+".jsp");
			return;
		}

		mav = controller.handleRequest(request, response);
		Map<String, Object> map = mav.getMap();
		Set<String> keys = map.keySet();
		for (String key : keys) {
			Object value = map.get(key);
			// JSP(View)가 데이터를 사용할 수 있도록 request에 저장
			request.setAttribute(key, value);
		}
		
		String viewPath = mav.getView();
		if (viewPath == null) {
			//response.sendError(HttpServletResponse.SC_NOT_FOUND);
			//return;
			viewResolver.execute(request, response, "/template/template01.jsp");
		}else{
			if(viewPath.startsWith("redirect")){// redirect
			String[] tokens = viewPath.split(":");
			response.sendRedirect(tokens[1]);
			}else{//forward
				viewResolver.execute(request, response, viewPath);
			}
		}

		
	}
}
