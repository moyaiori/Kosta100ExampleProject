package kr.or.kosta.springframework.beans;

import org.springframework.stereotype.Component;

@Component("hiMessageProvider")
public class HiWorldMessageProvider implements MessageProvider {

	public String getMessage() {
		return "Hi. Spring Framework~~~~";
	}

}
