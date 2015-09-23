package kr.or.kosta.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 자료실 리스트
 */
public class FileListServlet extends HttpServlet {
	
	private String fileRepository = "I:/KOSTA100/workspace/ServletStudy/fileDirectory/";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		process(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File file = new File(fileRepository);
		File[] fileList = file.listFiles();
		
		// 요청에 따른 동적컨텐츠(HTML) 생성 및 응답
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); // 브라우저에 보낼 Socket 연결
		
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<meta charset='utf-8'>");
		out.println("<head>");
		out.println("<link href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css' rel='stylesheet'>");
		out.println("<style>");
		out.println("tr th{ text-align: center;}");
		out.println("tr td{ text-align: center;}");
		out.println("</style>");
		out.println("<title>자료실 서블릿</title>");
		out.println("<script>");
		out.println("window.onload = function(){");
		out.println("   var buttons = document.getElementsByTagName('button');");
		out.println("   for ( var i in buttons) {");
		out.println("       buttons[i].onclick = function(){");
		out.println("          var fileName = this.getAttribute('name');");
		out.println("          request(fileName);");
		out.println("       }");
		out.println("   }");
		out.println("}");
		out.println("function request(fileName){");
		out.println("   location.href='download?file='+fileName");
		out.println("}");
		out.println("</script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='page-header container'>");
		out.println("<header><h1>자료실</h1></header></div>");
		out.println("<div class='container'>");
		out.println("<table class='table'>");
		out.println("<tr class='active'>");
		out.println("<th class='col-md-1'>번호</th>");
		out.println("<th class='col-md-6'>파일명</th>");
		out.println("<th class='col-md-1'>파일크기</th>");
		out.println("<th class='col-md-1'>작성자</th>");
		out.println("<th class='col-md-1'>다운로드</th>");
		out.println("</tr>");
		
		for (int i=0; i<fileList.length; i++) {
			out.println("<tr>");
			out.println("<td>"+ (i+1) + "</td>");
			out.println("<td>"+ fileList[i].getName() + "</td>");
			out.println("<td>"+ fileList[i].length()/1024 + "KB</td>");
			out.println("<td>관리자</td>");
			out.println("<td><button name='"+fileList[i].getName()+"'>다운로드</button></td>");
			out.println("</tr>");
		} 
		out.println("</table></div>");
		out.println("</body>");
		out.println("</html>");
	}
}
