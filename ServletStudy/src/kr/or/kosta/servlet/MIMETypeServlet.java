package kr.or.kosta.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  마임타입 변경을 통한 다양한 종류의 데이터 응답
 */
public class MIMETypeServlet extends HttpServlet {

	private static final String PATH = "I:/KOSTA100/workspace/ServletStudy/fileDirectory/";
//	private static String FILE = "bgm.mp3";
	private static String FILE = "servlet.pptx";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html; charset=utf-8");
//		response.setContentType("text/plain; charset=utf-8");
//		response.setContentType("audio/mpeg");
		response.setContentType("application/vnd.ms-powerpoint");
		OutputStream out = response.getOutputStream();
		
		File file = new File(PATH + FILE);
		InputStream in = null;
		if(file.exists()){
			try {
				in = new FileInputStream(file);
				byte[] buffer = new byte[1024];
				int count = 0;
				
				while((count = in.read(buffer)) != -1){
					out.write(buffer, 0, count);
				}
			} finally {
				// out은 컨테이너가 닫는다
				if(in != null) in.close();
			}
		}
	}
}
