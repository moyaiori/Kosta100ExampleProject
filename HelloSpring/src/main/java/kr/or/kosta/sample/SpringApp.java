package kr.or.kosta.sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringApp {

	public static void main(String[] args) {
		// 스프링 설정 파일
		String configPath = "applicationContext.xml";
		
		
		// 스프링 컨테이너 생성
		ApplicationContext springContext = new GenericXmlApplicationContext(configPath);
		System.out.println("메모리에 스프링 컨테이너가 생성 완료");
		
		//Hello hello =  (Hello) springContext.getBean("hello");
		Hello hello = springContext.getBean("hello", Hello.class);
		System.out.println(hello.getMessage());
	}

}
