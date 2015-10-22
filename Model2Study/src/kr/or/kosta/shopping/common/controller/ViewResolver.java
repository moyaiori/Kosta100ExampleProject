package kr.or.kosta.shopping.common.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * View 결정 및 실행
 * @author 김기정
 *
 */
public interface ViewResolver{
	public void execute(HttpServletRequest request, HttpServletResponse response, String uri) throws ServletException, IOException;
}
