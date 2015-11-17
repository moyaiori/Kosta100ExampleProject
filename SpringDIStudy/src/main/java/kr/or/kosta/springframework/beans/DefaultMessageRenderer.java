package kr.or.kosta.springframework.beans;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("messageRenderer")	// bean 태그와 같다
public class DefaultMessageRenderer implements MessageRenderer {
	
//	@Autowired
	@Resource(name="hiMessageProvider") // property 태그와 같다
	private MessageProvider messageProvider;
	
	public DefaultMessageRenderer() {}

	public DefaultMessageRenderer(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
	}

	public MessageProvider getmessageProvider() {
		return messageProvider;
	}

	public void setmessageProvider(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
	}

	public void render() {
		System.out.println(messageProvider.getMessage());
	}

}
