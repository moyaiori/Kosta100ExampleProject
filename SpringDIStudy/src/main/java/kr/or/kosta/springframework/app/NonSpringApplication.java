package kr.or.kosta.springframework.app;

import kr.or.kosta.springframework.beans.DefaultMessageRenderer;
import kr.or.kosta.springframework.beans.HiWorldMessageProvider;
import kr.or.kosta.springframework.beans.MessageProvider;
import kr.or.kosta.springframework.beans.MessageRenderer;

public class NonSpringApplication {

	public static void main(String[] args) {
		// 개발자가 객체 생성
//		MessageProvider messageProvider = new HelloWorldMessageProvider();
		MessageProvider messageProvider = new HiWorldMessageProvider();
		MessageRenderer messageRenderer = new DefaultMessageRenderer();
		
		// 개발자가 객체간의 의존관계 주입(DI)
		DefaultMessageRenderer renderer = (DefaultMessageRenderer)messageRenderer;
		renderer.setmessageProvider(messageProvider);
		
		messageRenderer.render();		

	}

}





