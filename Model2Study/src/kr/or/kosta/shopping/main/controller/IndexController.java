package kr.or.kosta.shopping.main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.shopping.common.controller.Controller;
import kr.or.kosta.shopping.common.controller.ModelAndView;

/** 
 *   /index 요청시
 * @author Lee Gwangyong
 *
 */
public class IndexController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// 다양한 서비스 객체를 이용한 비즈니스 메소드 호출
		ModelAndView mav = new ModelAndView();
		mav.setView("/index.jsp");
		
		return mav;
	}

}
