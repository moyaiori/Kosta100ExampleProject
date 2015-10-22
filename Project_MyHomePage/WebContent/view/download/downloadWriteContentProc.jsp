<%@page import="kr.or.kosta.user.domain.Board"%>
<%@page import="kr.or.kosta.download.dao.DownloadDao"%>
<%@page import="kr.or.kosta.download.dao.JdbcDownloadDao"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="kr.or.kosta.common.dao.DaoFactory.DaoFactoryType"%>
<%@page import="kr.or.kosta.common.dao.DaoFactory"%>
<%@page import="kr.or.kosta.board.dao.JdbcBoardDao"%>
<%@ page contentType="text/html; charset=utf-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String fileRepository = "I:/KOSTA100/";

	DaoFactory factory = DaoFactory.getInstance(DaoFactoryType.JDBC);
	DownloadDao downloadDao = (DownloadDao)factory.getDao(JdbcDownloadDao.class);
	
	String email = null;
	String loginId = null;

	// 쿠키 읽기
	Cookie[] cookies = request.getCookies();

	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("email")) {
				email = URLDecoder.decode(cookie.getValue(), "utf-8");
			}else if (cookie.getName().equals("loginId")) {
				loginId = URLDecoder.decode(cookie.getValue(), "utf-8");
			}
		}
	}
	
	Board file = new Board();
	String fileName = null;

	if (request.getMethod().equalsIgnoreCase("post")) {
		// 아파치 파일 업로드 API를 이용한 파일 수신 및 서버 디렉토리에 저장
		DiskFileItemFactory itemFactory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
		fileUpload.setSizeMax(1024 * 1024 * 1024); // 업로드 파일 용량 제한

		List<FileItem> fileList = null;
		

		try {
			fileList = fileUpload.parseRequest(request);
			for (FileItem item : fileList) {
				if (item.isFormField()) {// ParameterName=ParameterValue
					if(item.getFieldName().equals("subject")){
						file.setSubject(item.getString("utf-8"));
						
					}else if(item.getFieldName().equals("passwd")){
						file.setPasswd(item.getString("utf-8"));
						
					}else if(item.getFieldName().equals("file")){
						file.setFile(item.getString("utf-8"));
						
					}else if(item.getFieldName().equals("content")){
						file.setContent(item.getString("utf-8"));
					}
					
				} else {// 업로드 파일인 경우
					fileName = item.getName();
					System.out.println("업로드 파일명: " + fileName);
					// fileName = c:\xxx\yyy\업로드파일명
					String[] tokens = fileName.split("\\\\");
					fileName = tokens[tokens.length - 1];//파일명만 추출
					long fileSize = item.getSize();
					System.out.println("파일사이즈: " + fileSize);

					// 업로드된 파일을 서버의 특정 디렉토리에 저장
					File saveFile = new File(fileRepository + fileName);
					item.write(saveFile);
				}
			}
			// 업로드 결과 Response
			response.setContentType("text/html; charset=utf-8");
			//PrintWriter out = response.getWriter();
			System.out.println("파일 업로드 완료!");
		} catch (Exception e) {
			//new ServletException(e.getMessage());
			e.printStackTrace();
			response.setContentType("text/html; charset=utf-8");
			//PrintWriter out = response.getWriter();
			System.out.println("파일 올리기 실패, 용량 초과");
		}
	}
	
	System.out.println("file : " + file);
	
	file.setIp(request.getRemoteAddr());
	file.setWriter(loginId);
	file.setFile(fileName);
	
	downloadDao.wirte(file);
	
	
%>

<script>
	location.href = "downloadList.jsp";
</script>