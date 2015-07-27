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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/**
 * Borderlayout 
 * @author Lee Gwangyong
 * 현재 UI가 이벤트 리스터(핸들러)
 */
public class BorderLayoutFrame extends Frame implements WindowListener, ActionListener, ItemListener{
	
	TextArea messageTA;	// 채팅 보기 필드
	List userList;		// 사용자 리스트
	Panel southPanel;	// 우측 패널
	TextField inputTF;	// 입력 창
	Button sendB;		// 전송 버튼
	
	public BorderLayoutFrame(){
		this("non - title");
	}
	
	public BorderLayoutFrame(String title){
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
		// 내부에 리스너를 인터페이스를 등록했기때문에 this로 사용한다.
		addWindowListener(this);
		inputTF.addActionListener(this);
		sendB.addActionListener(this);
		userList.addItemListener(this);
	}
	
	/**
	 * 채팅 메시지 출력 기능
	 * 
	 */
	public void SetChatMessage(String message){
		// 텍스트를 추가해준다. setText는 덮어쓰기한다.
		messageTA.append(message + "\n");
	}
	
	/**
	 * 사용자 선택
	 */
	
	public void selectUser(){
		String user = userList.getSelectedItem();
		System.out.println(user + " user Selected");
	}
	
	/**
	 * 종료
	 */
	public void exit(){
		setVisible(false);
		dispose();
		System.exit(0);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		exit();
	}
	
	// 그래픽이 모두 반납이 됬다는것을 알려주는 이벤트
	// 이런것을 시스템 이벤트, 자원을 모두 닫았다고 자동 콜백
	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

	// --------------- Action Listener ---------------
	@Override
	public void actionPerformed(ActionEvent e) {
		String chatMessage = inputTF.getText();
		SetChatMessage(chatMessage);
		inputTF.setText("");
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED){
			selectUser();
		}
	}
	
}










