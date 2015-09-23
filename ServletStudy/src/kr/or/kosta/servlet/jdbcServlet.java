package kr.or.kosta.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.apache.jasper.tagplugins.jstl.core.If;

/**
 * 파일 다운로드 처리 서블릿
 */
public class jdbcServlet extends HttpServlet {

	private String fileRepository = "I:/KOSTA100/workspace/ServletStudy/fileDirectory/";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String driverName = "oracle.jdbc.driver.OracleDriver";
		// Driver driver = new OracleDriver();

		String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String dbUserId = "hr";
		String dbUserPw = "hr";

		String sql = "SELECT employee_id , last_name, salary,  hire_date" + " FROM employees";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuilder html = new StringBuilder();

		// #1. Oracle JDBC Driver 로드(인스턴스 생성)
		try {
			Class.forName(driverName).newInstance();

			// #2. Oracle 연결(JDBC URL 설정)
			con = DriverManager.getConnection(dbUrl, dbUserId, dbUserPw);

			// #3. Statement는 SQL 문장을 서버에 실행(전송)하며, 반환된 결과를 수신
			pstmt = con.prepareStatement(sql);

			// #4. 서버에 SQL 전송 및 결과 집합 수신
			rs = pstmt.executeQuery(sql); // DML
			// int updateCount = stmt.executeUpdate(sql); // DDL, DCL

			// #5. ResultSet의 데이터 읽기
			while (rs.next()) {
				// 각행의 컬럼값 읽기
				int employeeId = rs.getInt("employee_id");
				String lastName = rs.getString("last_name");
				int salary = rs.getInt("salary");
				Date hireDate = rs.getDate("hire_date");
				
				html.append("<tr>");
				html.append("	<td>" + employeeId + "</td>");
				html.append("	<td>" + lastName + "</td>");
				html.append("	<td>" + salary + "</td>");
				html.append("	<td>" + hireDate + "</td>");
				html.append("</tr>");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("사원 목록");
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
		out.println("<th>사원번호</th>");
		out.println("<th>성</th>");
		out.println("<th>급여</th>");
		out.println("<th>입사일</th>");
		out.println("</tr>");
		out.print(html.toString());
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}
