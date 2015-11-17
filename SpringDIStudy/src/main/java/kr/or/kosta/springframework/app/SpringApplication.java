package kr.or.kosta.springframework.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.or.kosta.springframework.beans.DefaultMessageRenderer;
import kr.or.kosta.springframework.beans.HiWorldMessageProvider;
import kr.or.kosta.springframework.beans.MessageProvider;
import kr.or.kosta.springframework.beans.MessageRenderer;
import kr.or.kosta.springframework.beans.SomeService;
import kr.or.kosta.springframework.beans.User;

public class SpringApplication {

	public static void main(String[] args) {
		// 스프링 컨테이너에 의해 객체가 생성되고(IOC), 객체간 의존관계 주입(DI)
//		String configLocation = "config/applicationContext.xml";
		// 팀단위 작업 시 설정 파일 여러개로 분리 시
		String[] configLocations = {"config/applicationContext.xml"};
		ApplicationContext applicationContext = 
				new GenericXmlApplicationContext(configLocations);
		
		
		// 사용하고자 하는 빈(객체)을 컨테이너로부터 검색
//		MessageRenderer messageRenderer = springContainer.getBean(DefaultMessageRenderer.class);
//		MessageRenderer messageRenderer = (MessageRenderer)springContainer.getBean("messageRenderer");
		MessageRenderer messageRenderer = applicationContext.getBean("messageRenderer", MessageRenderer.class);
		messageRenderer.render();
		
		
		// 기타 주요한 메소드
		System.out.println(applicationContext.containsBean("messageProvider"));	// 저장여부 확인
		Class clazz = applicationContext.getType("messageProvider");	// 빈 타입을 볼수 있다.
		System.out.println(clazz.toString());
		
		// 빈은 싱글톤으로 관리됨..
		MessageRenderer messageRenderer2 = applicationContext.getBean("messageRenderer", MessageRenderer.class);
		System.out.println(messageRenderer == messageRenderer2);
		
		User user = applicationContext.getBean("user", User.class);
		System.out.println(user);
		
		SomeService someService = applicationContext.getBean("someService", SomeService.class);
		System.out.println(someService.getAge());
		System.out.println(someService.getName());
		System.out.println(someService.getUser());
		System.out.println(someService.getNameList());
		System.out.println(someService.getUserList());
	}
}



