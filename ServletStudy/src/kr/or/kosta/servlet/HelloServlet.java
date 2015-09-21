package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 최초로 작성하는 서블릿
 */
public class HelloServlet extends HttpServlet {
       
    public HelloServlet() {
        System.out.println("서블릿 컨테이너에 의해 자동 호출됨..");
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request);
		System.out.println(response);
		// 요청에 따른 동적컨텐츠(HTML) 생성 및 응답
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>최초 서블릿</title>");
		out.println("<meta chartset='utf-8'>");
		out.println("</head>");
		out.println("<body style='font-size:30pt;'>");
		Calendar today = Calendar.getInstance();
		String todayStr = String.format("%1$tF %1$tT", today);
		out.println("오늘의 날짜 : " + todayStr);
		out.println("</body>");
		out.println("</html>");
	}

}








