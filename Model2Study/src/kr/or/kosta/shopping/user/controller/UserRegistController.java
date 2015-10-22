package kr.or.kosta.shopping.user.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.shopping.common.controller.Controller;
import kr.or.kosta.shopping.common.controller.ModelAndView;
import kr.or.kosta.shopping.user.domain.User;
import kr.or.kosta.shopping.user.service.UserService;

/*
 *  /user/registProc.mall
 */
public class UserRegistController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		System.out.println("userRegist");
		ModelAndView mav = new ModelAndView();
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		
		User user = new User(id, name, passwd);
		
		UserService service = UserService.getInstance();
		service.add(user);
		
		mav.addObject("user", user);
		mav.setView("/user/registResult.jsp");
		
		return mav;
	}

}
