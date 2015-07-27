import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseListener;

public class UserFrame extends Frame {
	/**
	 * 화면 정의시 접근제한자를 생략한다.
	 */
	Button button;
	Label lable;
	
	public UserFrame(){
		this("non - title");
	}
	
	public UserFrame(String title){
		super(title); // setTitle();
		button = new Button("AWT 버튼");
		lable = new Label("졸지마...");
	}
	
	/**
	 * 화면배치
	 */
	public void setComponents(){
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(button);
		add(lable);
	}
	
	/**
	 * 이벤트 소스별 이벤트 리스터 등록
	 */
	public void eventRegist(){
		addWindowListener(new EventHandler(this));
//		button.addMouseListener(new EventHandler());
		button.addActionListener(new EventHandler(this));
	}
	
	/**
	 * 라벨 메시지 변경
	 */
	public void setMessage(String message){
		lable.setText(message);
	}
	
	/**
	 * 프레임창 종료
	 */
	public void exit(){
		// 화면에서 제거한다.
		setVisible(false);
		// OS에 그래픽 리소스 반환 
		dispose();
		System.exit(0);
	}

}









