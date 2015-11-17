package kr.or.kosta.school.commons;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.or.kosta.school.domain.Student;
import kr.or.kosta.school.service.AcademicService;

public class ApplicationClass {
	public static void main(String[] args) {

		String configLocation = "config/applicationContext.xml";
		ApplicationContext applicationContext = 
				new GenericXmlApplicationContext(configLocation);

		Student student = new Student("0", "이광용", 100);
		
		AcademicService service = applicationContext.getBean("academicService", AcademicService.class);
		//		service.regist(student);
		
		List<Student> list = service.list();
		
		for (Student students : list) {
			System.out.println(" 학번 : " + students.getSsn() + " 이름 : " + students.getName() + " 점수 : " + students.getScore());
		}
	}
}
