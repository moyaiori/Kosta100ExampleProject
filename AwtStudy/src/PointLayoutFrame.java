import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
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
 * 좌표 배치 연습 
 * 내부 클래스를 이용한 이벤트 리스너 구현
 * @author Lee Gwangyong
 */
public class PointLayoutFrame extends Frame{
	
	Label idL;
	TextField idTF;
	
	public PointLayoutFrame(){
		this("non - title");
	}
	
	public PointLayoutFrame(String title){
		super(title); // setTitle();
		idL = new Label("아이디");
		idTF = new TextField();
	}
	
	// 화면배치
	public void setComponents(){
		// 프레임의 레이아웃은 기본적으로 보더이다. 플로우가 아니다. 패널만 안에 플로우 
		
		setLayout(null); // 레이아웃 매니저 삭제
		idL.setBounds(50, 50, 100, 30);
		idL.setBackground(Color.LIGHT_GRAY);
		idTF.setBounds(160, 100, 30, 100);
		add(idL);
		add(idTF);
		
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
		
		
	}	
	
	// --------------- event 처리를 위한 메소드들 ----------------
	
	/**
	 * 종료
	 */
	public void exit(){
		setVisible(false);
		dispose();
		System.exit(0);
	}

	public static void main(String[] args) {
		PointLayoutFrame frame = new PointLayoutFrame("카드 레이아웃 연습");
		
		frame.setSize(400, 500);
		frame.setComponents();
		frame.setVisible(true);
		frame.eventRegist();
	}
	
}










