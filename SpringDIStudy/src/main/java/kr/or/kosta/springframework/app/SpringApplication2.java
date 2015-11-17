package kr.or.kosta.springframework.app;

import kr.or.kosta.springframework.beans.MessageProvider;
import kr.or.kosta.springframework.beans.MessageRenderer;
import kr.or.kosta.springframework.beans.User;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 애노테이션을 이용한 빈 자동 등록
 * @author 김기정
 *
 */
public class SpringApplication2 {

	public static void main(String[] args) {
		ApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(
						"kr.or.kosta.springframework.beans");
		MessageProvider messageProvider = applicationContext.getBean("messageProvider", MessageProvider.class);
		System.out.println(messageProvider.getMessage());
		
		MessageRenderer messageRenderer = applicationContext.getBean("messageRenderer", MessageRenderer.class);
		messageRenderer.render();
		
		User usr = applicationContext.getBean("user", User.class);
		System.out.println(usr);
		
	}
}



