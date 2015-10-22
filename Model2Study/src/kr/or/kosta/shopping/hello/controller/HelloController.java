package kr.or.kosta.shopping.hello.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.shopping.common.controller.Controller;
import kr.or.kosta.shopping.common.controller.ModelAndView;

public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		//Model을 이용한 데이터 가공
//		String Message = xxxService.bizmethod();
		
		String message = "Model2 웹 애플리케이션 개발입니다.";
		List<String> list = new ArrayList<String>();
		list.add("박찬호");
		list.add("박지성");
		list.add("박세리");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", message);
		mav.addObject("list", list);

		mav.addObject("contentFile", "/hello.jsp");
		
		return mav;
	}

}
