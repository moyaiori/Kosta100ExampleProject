package ko.or.kosta.chat.client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import kr.or.kosta.chat.common.MessageType;

/**
 * 채팅 메인 화면 내부 클래스를 이용한 이벤트 리스너 구현
 * 
 * @author Lee Gwangyong
 */
public class ChatUI extends JFrame {

	JTextArea messageTA; // 채팅 보기 필드
	JList<String> userList; // 사용자 리스트
	UserModel userModel;// userList용 모델
	JPanel southPanel; // 우측 패널
	JTextField inputTF; // 입력 창
	JButton sendB; // 전송 버튼

	ChatClient chatClient;
	private static final String SERVERIP = "localhost";
//	private static final String SERVERIP = "192.168.0.28";
	private static final int SERVERPORT = 7777;
	
	// 사용자 정보
	private String nicName = "이광용";		// 대화명

	public ChatUI() {
		this(":: 즐거운 대화 나누세요 ::");
	}

	public ChatUI(String title) {
		super(title); // setTitle();

		messageTA = new JTextArea();
		userList = new JList<String>();
		userList.setPreferredSize(new Dimension(100, 100));
		userModel = new UserModel();
		userList.setModel(userModel);

		southPanel = new JPanel();
		inputTF = new JTextField(20);
		sendB = new JButton("전        송");

	}

	public String getNicName() {
		return nicName;
	}

	public void setNicName(String nicName) {
		this.nicName = nicName;
	}

	// 화면배치
	public void setComponents() {
		makeSouthPanel();
		setLayout(new BorderLayout());
		add(new JScrollPane(messageTA), BorderLayout.CENTER);
		add(new JScrollPane(userList), BorderLayout.EAST);
		add(southPanel, BorderLayout.SOUTH);
	}

	private void makeSouthPanel() {
		// 패널 완성
		southPanel.setLayout(new BorderLayout(5, 5));
		southPanel.add(inputTF, BorderLayout.CENTER);
		southPanel.add(sendB, BorderLayout.EAST);

	}

	// ---------------- 기능 구현 ---------------

	/**
	 * 채팅 메시지 출력 기능
	 */
	public void setChatMessage() {
		String message = inputTF.getText();
		if (message == null || message.trim().length() == 0) {
			return;
		}
		// messageTA.append(message + "\n");
		inputTF.setText("");

		try {
			// 200|*|닉네임|*|채팅메시지
			chatClient.sendMessage(MessageType.SC_CHAT + 
					MessageType.DELIMETER + 
					nicName + 
					MessageType.DELIMETER + 
					message);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "네트워크 상태를 확인하여 주세요.", "연 결 실 패", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * 일반 메시지 출력
	 */
	public void setMessage(String message) {
		messageTA.append(message + "\r\n");
	}

	/**
	 * 사용자 선택
	 */

	public void selectUser() {
		String user = (String) userList.getSelectedValue();
		// System.out.println(user + " user Selected");
	}

	// --------------- event 처리 ----------------

	/**
	 * 종료
	 */
	public void exit() {
		// 연결 종료시  닉네임 전송(300|*|아이디)
		try {
			chatClient.sendMessage(MessageType.SC_DISCONNECT + MessageType.DELIMETER + nicName);
		} catch (IOException e) {}
		
		chatClient.disConnect();
		setVisible(false);
		dispose();
		System.exit(0);
	}

	/**
	 * 이벤트에 이벤트 핸들러 등록
	 */
	public void eventRegist() {

		// 프로그램 종료 버튼 이벤트 구현
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}

			// 채팅서버 연결
			@Override
			public void windowOpened(WindowEvent e) {
				inputTF.requestFocus();
				chatClient = new ChatClient(SERVERIP, SERVERPORT);
				chatClient.setUi(ChatUI.this);
				try {
					chatClient.connect();
					setMessage("KotalkServer[" + chatClient.getPort() + "] Connected.....");
					// 최초 전송시  닉네임 전송(100|*|아이디)
					chatClient.sendMessage(MessageType.SC_CONNECT + MessageType.DELIMETER + nicName);
					chatClient.receiveMessage();
					} catch (IOException ex) {
					String errorMessage = "아래와 같은 예외가 발생하여 서버와 연결할 수 없습니다. \r\n" + ex.toString();
					JOptionPane.showMessageDialog(null, errorMessage, "연 결 실 패", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// 채팅 입력(엔터누를시) 이벤트 구현
		inputTF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setChatMessage();
			}
		});

		// 채팅 입력 (전송 버튼 구현)
		sendB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setChatMessage();
			}
		});

		// 사용자 선택시
		userList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				selectUser();
			}
		});
	}
}
