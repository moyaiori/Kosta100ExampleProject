import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/**
 * 채팅 메인 화면
 * 내부 클래스를 이용한 이벤트 리스너 구현
 * @author Lee Gwangyong
 */
public class ChatFrame extends Frame{
	
	TextArea messageTA;	// 채팅 보기 필드
	List userList;		// 사용자 리스트
	Panel southPanel;	// 우측 패널
	TextField inputTF;	// 입력 창
	Button sendB;		// 전송 버튼
	
	public ChatFrame(){
		this("non - title");
	}
	
	public ChatFrame(String title){
		super(title); // setTitle();
		
		messageTA = new TextArea();
		userList = new List();
		userList.add("날라리");
		userList.add("학생");
		userList.add("회사원");
		
		southPanel = new Panel();
		inputTF = new TextField(20);
		sendB = new Button("전        송");
		
	}
	
	
	// 화면배치
	public void setComponents(){
		makeSouthPanel();
		setLayout(new BorderLayout());
		add(messageTA, BorderLayout.CENTER);
		add(userList, BorderLayout.EAST);		
		add(southPanel, BorderLayout.SOUTH);
	}
	
	private void makeSouthPanel() {
		// 패널 완성
		southPanel.setLayout(new BorderLayout(5,5));
		southPanel.add(inputTF, BorderLayout.CENTER);
		southPanel.add(sendB, BorderLayout.EAST);
		
	}
	/**
	 * 이벤트에 이벤트 핸들러 등록
	 */
	public void eventRegist(){
		// 이름있는 지역 내부 클래스를 이용한 이벤트 리스너
//		class Exiter extends WindowAdapter {
//			public void windowClosing(WindowEvent e){
//				exit();
//			}
//		}
		
		//-----------이름없는 지역 내부 클래스-------------
		// 프로그램 종료 버튼 이벤트 구현
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {exit();};
		});
		
		// 채팅 입력(엔터누를시) 이벤트 구현
		inputTF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SetChatMessage();
			}
		});
		
		// 채팅 입력 (전송 버튼 구현)
		sendB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SetChatMessage();
			}
		});
		
		userList.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				selectUser();
			}
		});
		
		
		// 내부에 리스너를 인터페이스를 등록했기때문에 this로 사용한다.
//		addWindowListener(new ExitHandler());
//		addWindowListener(new Exiter());
//		inputTF.addActionListener(this);
//		sendB.addActionListener(this);
//		userList.addItemListener(this);
	}
	
	// ---------------- 기능 구현 ---------------
	
	/**
	 * 채팅 메시지 출력 기능
	 */
	public void SetChatMessage(){
		// 텍스트를 추가해준다. setText는 덮어쓰기한다.
		String message = inputTF.getText();
		// 유효성 검증, 내용이없거나 공백만 왔을경우 
		if (message == null || message.trim().length() == 0) {
			return;
		}
		messageTA.append(message + "\n");
		inputTF.setText("");
	}
	
	/**
	 * 사용자 선택
	 */
	
	public void selectUser(){
		String user = userList.getSelectedItem();
		System.out.println(user + " user Selected");
	}
	
	// --------------- event 처리 ----------------
	
	/**
	 * 종료
	 */
	public void exit(){
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	/**
	 * 멤버 내부 클래스를 이용한 이벤트 리스너
	 */
	public class ExitHandler extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e) {
			exit();
		}
	}

	
}










