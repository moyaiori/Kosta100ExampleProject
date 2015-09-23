package kr.or.kosta.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.apache.jasper.tagplugins.jstl.core.If;

/**
 * 파일 다운로드 처리 서블릿
 */
public class FileListServlet extends HttpServlet {

	private String fileRepository = "I:/KOSTA100/workspace/ServletStudy/fileDirectory/";
	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		process(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		process(request, response);
	}
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("file");
		
		if (fileName != null) {
			System.out.println("fileName : " + fileName);
			String filePath = fileRepository + fileName;
			File file = new File(filePath);
			
			// HTTP 버전별 브라우저 캐시 사용 않도록 응답헤더 설정
			String httpVersion = request.getProtocol();
			if (httpVersion.equals("HTTP/1.0")) {
				response.setDateHeader("Expires", 0);
				response.setHeader("Pragma", "no-cache");
			} else if (httpVersion.equals("HTTP/1.1")) {
				response.setHeader("Cache-Control", "no-cache");
			}
			
			// 파일 다운로드 처리를 위한 응답헤더에 마임타입 설정
			response.setContentType("application/octet-stream");
			fileName = URLEncoder.encode(fileName, "utf-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ";");
			response.setHeader("Content-Length", "" + file.length());

			FileInputStream in = new FileInputStream(file);
			OutputStream outStream = response.getOutputStream();
			try{
				byte[] buffer = new byte[1024];
				int count = 0;
				while ((count = in.read(buffer)) != -1) {
					outStream.write(buffer, 0, count);
				}
			}finally{
				if(outStream != null) outStream.close();
				if(in != null)  in.close();
			}
		}
		
		
		//----------------------
		File dirFile = new File(fileRepository);
		File[] fileList = dirFile.listFiles();
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<script type='text/javascript'>");
		out.println("function donwload(file){");
		out.println("var downloadPath = 'lab?file=';");
		out.println("downloadPath += file;");
		out.println("location.replace(downloadPath);");
//		out.println("console.log(downloadPath);");
		out.println("}");
		out.println("</script>");
		out.println("<title>");
		out.println("자료실");
		out.println("</title>");
		out.println("<style>");
		out.println("table {");
		out.println("border-collapse: collapse;");
		out.println("}");
		out.println("table, th, td {");
		out.println("border: 1px solid black;");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table style='border: 1px solid blue'>");
		out.println("<tr>");
		out.println("<th>연번</th>");
		out.println("<th>파일명</th>");
		out.println("<th>크기</th>");
		out.println("<th>작성자</th>");
		out.println("<th>다운로드</th>");
		out.println("</tr>");
		int count = 0;
		for (File tempFile : fileList) {
			if (tempFile.isFile()) {
				count++;
				out.println("<tr>");
				out.println("<td>" + count + "</td>");
				out.println("<td>" + tempFile.getName() + "</td>");
				out.println("<td>" + tempFile.length() / 1024 + "kb</td>");
				out.println("<td>이광용</td>");
				out.println("<td><button name=\" download" + count + "\" onclick=\"donwload(\'" + tempFile.getName() + "\')\">다운로드</button></td>");
				out.println("</tr>");
			}
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}
