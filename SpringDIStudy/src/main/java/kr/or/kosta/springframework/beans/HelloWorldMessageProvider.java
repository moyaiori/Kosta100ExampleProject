package kr.or.kosta.springframework.beans;

import org.springframework.stereotype.Component;


@Component("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {

	public String getMessage() {
		return "안녕하세요. Spring Framework~~~~";
	}

}
