package kr.or.kosta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		String message = "스프링 2.5 웹 애플리케이션 개발 방식";
		mav.addObject("message", message);
		mav.setViewName("hello");
		return mav;
	}

}
