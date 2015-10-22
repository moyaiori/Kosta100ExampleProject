package kr.or.kosta.shopping.common.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/** 모든 세부 컨트롤러 오브젝트들에 대한 실행메소드 규약 선언 */
public interface Controller {
	/** 실행 규약 메소드 */
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException;
}