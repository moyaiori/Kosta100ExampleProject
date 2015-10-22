package kr.or.kosta.shopping.user.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.shopping.common.controller.Controller;
import kr.or.kosta.shopping.common.controller.ModelAndView;
import kr.or.kosta.shopping.user.domain.User;
import kr.or.kosta.shopping.user.service.UserService;

/*
 *  /user/list.mall
 */
public class UserListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav = new ModelAndView();
		
		UserService service = UserService.getInstance();
		List<User> list = service.list();
		
		mav.addObject("list", list);
		mav.addObject("contentFile", "/user/list.jsp");
		
		return mav;
	}

}
