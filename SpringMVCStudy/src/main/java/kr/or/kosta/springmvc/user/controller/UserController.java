package kr.or.kosta.springmvc.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.kosta.springmvc.user.domain.User;
import kr.or.kosta.springmvc.user.service.UserService;

/**
 * 사용자 관련 요청 처리 세부 컨트롤러
 * @author Lee Gwangyong
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//단순 포워드
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public String form(){
		return "user/form";
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("user") User user){
		System.out.println("사용자 : " + user);
		return "user/result";
	}


	@RequestMapping("/list")
	public String submit(Model model){
		List<User> list = userService.list();
		model.addAttribute("list",	list);
		return "user/list";
	}
	
	@RequestMapping("/list/{id}")
	public String get(Model model, @PathVariable String id){
		System.out.println("전달받은 사용자 아이디 : " + id);
		// xxx Service
		return "user/list";
	}
	
	
}
