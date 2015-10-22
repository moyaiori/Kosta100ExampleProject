package kr.or.kosta.shopping.hello.controller;

import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.shopping.common.controller.Controller;
import kr.or.kosta.shopping.common.controller.ModelAndView;

public class TodayController implements Controller {

	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {

		ModelAndView mav = new ModelAndView();
		
		//Model을 이용한 데이터 가공
//		String Message = xxxService.bizmethod();
		

		Calendar today = Calendar.getInstance();
		
		mav.addObject("today", today);
		
		mav.setView("/today.jsp");
		
		return mav;
	}

}
