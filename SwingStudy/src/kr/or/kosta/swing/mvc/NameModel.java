package kr.or.kosta.swing.mvc;

import java.util.Vector;

import javax.swing.AbstractListModel;

/**
 * JList의 뷰+컨트롤러(델리게이트)가 사용하는 데이터 저장을 위한 모델클래스
 * @author 김기정
 */
public class NameModel extends AbstractListModel/* implements ListModel*/{
	
	Vector<String> list;
	
	public NameModel(){
		list = new Vector<String>();
		// 테스트 초기화
		list.addElement("규빈");
		list.addElement("희상");
	}
	
	@Override
	// View와 Controller에 의해 자동 호출되는 콜백메소드
	public int getSize() {
		System.out.println("getSize() 호출됨..");
		return list.size();
	}

	@Override
	// View와 Controller에 의해 자동 호출되는 콜백메소드
	public Object getElementAt(int index) {
		System.out.println("getElementAt(int index) 호출됨..");
		return list.elementAt(index);
	}
	
	/**
	 * 등록 기능 추가
	 */
	public void addName(String name){
		list.addElement(name);
		// 뷰하고, 컨트롤러에게 데이터 변경을 통보
		fireContentsChanged(list, 0, list.size());
	}
	
	/**
	 * 삭제 기능 추가
	 */
	public void deleteName(int idx){
		list.removeElementAt(idx);
		// 뷰하고, 컨트롤러에게 데이터 변경을 통보
		fireContentsChanged(list, 0, list.size());
	}
	
	/**
	 * 수정 기능 추가
	 */
	public void updateName(String name, int index){
		list.setElementAt(name, index);
		// 뷰하고, 컨트롤러에게 데이터 변경을 통보
		fireContentsChanged(list, 0, list.size());
	}
}





