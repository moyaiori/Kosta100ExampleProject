package ko.or.kosta.chat.client;

import java.util.Vector;

import javax.swing.AbstractListModel;

/**
 * JList의 뷰+컨트롤러(델리게이트)가 사용하는 데이터 저장을 위한 모델클래스
 * @author 김기정
 */
public class UserModel extends AbstractListModel{
	
	Vector<String> list;
	
	public UserModel(){
		list = new Vector<String>();
		// 테스트 초기화
		list.addElement("날라리");
//		list.addElement("양아치");
//		list.addElement("쓰레기");
//		list.addElement("대걸레");
	}
	
	@Override
	// View와 Controller에 의해 자동 호출되는 콜백메소드
	public int getSize() {
		return list.size();
	}

	@Override
	// View와 Controller에 의해 자동 호출되는 콜백메소드
	public Object getElementAt(int index) {
		return list.elementAt(index);
	}
	
	/**
	 * 접속자 등록
	 */
	public void addUser(String user){
		list.addElement(user);
		// 뷰하고, 컨트롤러에게 데이터 변경을 통보
		fireContentsChanged(list, 0, list.size());
	}
	
	/**
	 * 접속자 퇴장
	 */
	public void removeUser(String user){
		list.removeElement(user);
		// 뷰하고, 컨트롤러에게 데이터 변경을 통보
		fireContentsChanged(list, 0, list.size());
	}
}





