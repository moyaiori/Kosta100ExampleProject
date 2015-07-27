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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/**
 * 타이핑 연습
 * 내부 클래스를 이용한 이벤트 리스너 구현
 * @author Lee Gwangyong
 */
public class KeyboardFrame extends Frame{
	
	TextArea messageTA;	// 채팅 보기 필드
	TextField inputTF;	// 입력 창
	
	public KeyboardFrame(){
		this("non - title");
	}
	
	public KeyboardFrame(String title){
		super(title); // setTitle();
		messageTA = new TextArea();
		inputTF = new TextField();
	}
	
	
	// 화면배치
	public void setComponents(){
		setLayout(new BorderLayout());
		add(messageTA, BorderLayout.CENTER);
		add(inputTF, BorderLayout.SOUTH);
	}
	
	/**
	 * 이벤트에 이벤트 핸들러 등록
	 */
	public void eventRegist(){		
		//-----------이름없는 지역 내부 클래스-------------
		// 프로그램 종료 버튼 이벤트 구현
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {exit();};
		});
		
		//키값일 눌려질때마다 키이벤트가 발생한다.
		
		
		//text 리스너로 구현
//		inputTF.addTextListener(new TextListener() {
//			
//			@Override
//			public void textValueChanged(TextEvent e) {
//				String message = inputTF.getText();
//				messageTA.setText(message);
//			}
//		});
		
		// key event로 구현
		inputTF.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				char c = e.getKeyChar();
				System.out.println(c);
//				String message = inputTF.getText();
//				messageTA.setText(message);
			}
		});
		
		messageTA.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("x : " + e.getX() + " y : " + e.getY());
//				System.out.println(e.getButton());
				if (e.getButton() == MouseEvent.BUTTON1) {
					System.out.println("BUTTON1");
				}
			}
		});
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

	public static void main(String[] args) {
		KeyboardFrame frame = new KeyboardFrame("타이핑 연습");
		
		frame.setSize(400, 500);
		frame.setComponents();
		frame.setVisible(true);
		frame.eventRegist();
	}
	
}










