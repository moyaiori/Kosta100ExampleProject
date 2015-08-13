package kr.or.kosta.chat.common;
/**
 * 채팅메시지 타입을 위한 상수들
 * @author Lee Gwangyong
 *
 */
public interface MessageType {
	
	String DELIMETER = "☆";
	
	String SC_CONNECT = "100";		// 최초연결시
	String SC_CHAT = "200";			// 채팅내용
	String SC_DISCONNECT = "300";	// 연결종료시
}
