package kr.or.kosta.springmvc.user.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.kosta.springmvc.user.domain.User;
import kr.or.kosta.springmvc.user.service.UserService;

/** 사용자 관련 요청 처리 세부 컨트롤러 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public String form(){
		return "user/form";		
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("user") User user){
		//System.out.println("사용자: " + user);
		logger.debug("사용자: " + user);
		return "user/result";
	}
	
	@RequestMapping("/list")
	public String list(Model model){
		List<User> list = userService.list();
		model.addAttribute("list", list);
		return "user/list";
	}
	
	@RequestMapping("/get/{id}")
	public String get(Model model, @PathVariable("id") String id){
		//System.out.println("전달받은 사용자 아이디: " + id);
		logger.debug("전달받은 사용자 아이디: " + id);
		User user = userService.get(id);
		logger.debug("검색된 사용자: " + user);
		
		return "user/list";
	}
	
	/** 요청헤더 읽기 */
	@RequestMapping("/header")
	public String getHeader(Model model, @RequestHeader("user-agent") String userAgent){
		logger.debug("요청헤더의 user-agent: " + userAgent);
		return "user/list";
	}
	
	/** 로그인 - 서블릿 API를 이용하여 쿠키 생성 및 응답헤더에 밀어넣기 */
	@RequestMapping("/login")
	public String login(Model model, HttpServletResponse response, String id, String passwd){
		// 무조건 회원이라 가정
		Cookie loginCookie = new Cookie("loginId", id);
		loginCookie.setPath("/");
		response.addCookie(loginCookie);
		return "redirect:/user/readcookie";
	}
	@RequestMapping("/loginForm")
	public String loginForm(){
		return "user/loginForm";
	}
	
	/** 로그인 - 서블릿 API를 이용하여 쿠키 읽기 */
	/*
	@RequestMapping("/readcookie")
	public String userHome(Model model, HttpServletRequest request){
		String cookieValue = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for (Cookie cookie : cookies) {
				String cookieName = cookie.getName();
				if(cookieName.equalsIgnoreCase("loginId")){
					cookieValue = cookie.getValue();
				}
			}
		}
		logger.debug("로그인 아이디: " + cookieValue);
		
		return "user/list";
	}
	*/
	
	@RequestMapping("/readcookie")
	public String userHome(Model model, @CookieValue(value="loginId", required=false, defaultValue="Guest") String loginId){
		logger.debug("로그인 아이디: " + loginId);
		return "user/list";
	}
	
	
	/** JSON 응답 처리 샘플1 - 비권장 */
	@RequestMapping("/json1")
	public String json1(Model model, PrintWriter out){
		// JSON 전송
		String sampleJson = "{\"id\": \"bangry\", \"passwd\" : \"1234\", \"name\" : \"김기정\"}";
		out.println(sampleJson);
		return null;
	}
	
	/** JSON 응답 처리 샘플2 - 권장 */
	/**
	 * @ResponseBody를 사용하면 해당 콘트롤러 메소드에서 리턴하는 값이 바로 응답 바디가 되므로
	 * 다른 뷰로 사용하지 않고도 간단한 응답을 클라이언트에게 직접 전송할 수 있다
	 * 주로 AJAX 요청에 대한 XML, JSON 응답 처리 시 사용
	 * pom.xml에 jackson json 라이브러리 추가 필요
	 */
	@RequestMapping(value = "/json2", produces="text/plain; charset=utf8")
	public  @ResponseBody String json2(Model model){
		String sampleJson = "{\"id\": \"bangry\", \"passwd\" : \"1234\", \"name\" : \"김기정\"}";
		return sampleJson;
	}
	
	/** JSON 응답 처리 샘플3 - 권장 */
	@RequestMapping(value = "/json3")
	public  @ResponseBody User json3(Model model){
		User user = new User("bangry", "김기정", "1234");
		return user;
	}
	
	/** JSON 응답 처리 샘플4 - 권장 */
	@RequestMapping(value = "/json4")
	public  @ResponseBody Map<String, Object> json4(Model model){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "bangry");
		map.put("name", "김기정");
		map.put("passwd", "1234");
		map.put("address", "admin");
		return map;
	}
	
	@RequestMapping("/json5")
	public  String json5(){
		return "user/jsonSample";
	}
	
	@RequestMapping(value="/json6", method=RequestMethod.POST)
	public @ResponseBody User json6(@RequestBody User user) {
		logger.debug("수신데이터: " + user);
		// 에코
		return  user;
	}
}
