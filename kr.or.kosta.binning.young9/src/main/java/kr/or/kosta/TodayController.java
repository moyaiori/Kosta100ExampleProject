package kr.or.kosta;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodayController {
	Logger logger = Logger.getLogger(getClass());	
	
	/*
	@RequestMapping("/today")
	public String today(HttpServletRequest request, Model model){
		String id = request.getParameter("id");
		logger.debug("당신의 아이디는 " + id + "입니다..");
		
		Calendar today = Calendar.getInstance();
		model.addAttribute("today", today);
		
		return "today";
	}
	*/
	
	@RequestMapping("/today")
	public String today(Model model, @RequestParam(value="id", required=false) String id){
		logger.debug("당신의 아이디는 " + id + "입니다..");
		
		Calendar today = Calendar.getInstance();
		model.addAttribute("today", today);
		
		return "today";
	}

}
