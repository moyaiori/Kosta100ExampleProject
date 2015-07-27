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

public class EmailFrame extends Frame{
	EmailPanel emailPanel;
	Button sendB, cancleB;
	Panel buttonPanel;
	
	public EmailFrame(){
		this("No-Title");
	}
	public EmailFrame(String title){
		super(title);
		emailPanel = new EmailPanel();
		
		sendB = new Button("보내기");
		cancleB = new Button("취  소");
		buttonPanel = new Panel();
	}
	
	/** 화면 배치 */
	public void setComponents(){
		setLayout(new BorderLayout());// 디폴트
		buttonPanel.add(sendB);
		buttonPanel.add(cancleB);
		
		add(emailPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * 종료
	 */
	public void exit(){
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	/**
	 * 이벤트소스에 이벤트 핸들러 등록
	 */
	public void eventRegist(){
		// 이름없는 지역 내부클래스
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
	}
	
	public static void main(String[] args) {
		EmailFrame frame = new EmailFrame("이메일 보내기 화면 실습");
		frame.setSize(500, 350);
		frame.setComponents();
		frame.setVisible(true);
		frame.eventRegist();
	}
	
}








