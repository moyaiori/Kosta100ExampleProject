import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.FlowLayout;
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
 * 카드패널 연습
 * 내부 클래스를 이용한 이벤트 리스너 구현
 * @author Lee Gwangyong
 */
public class CardLayoutFrame extends Frame{
	
	Button redB, greenB, blueB;
	
	RedPanel redP;
	GreenPanel greenP;
	BluePanel blueP;
	
	CardLayout cardLayout;
	
	Panel buttonP, cardP;
	
	
	public CardLayoutFrame(){
		this("non - title");
	}
	
	public CardLayoutFrame(String title){
		super(title); // setTitle();
		
		redB = new Button("Red");
		greenB = new Button("Green");
		blueB = new Button("Blue");
		
		redP = new RedPanel();
		greenP = new GreenPanel();
		blueP = new BluePanel();
		buttonP = new Panel();
		cardP = new Panel();
		
		cardLayout = new CardLayout();
	}
	
	
	// 화면배치
	public void setComponents(){
		// 프레임을 상속받은 컴포넌트는 기본적으로 플로우 레이아웃이다.
		buttonP.setLayout(new FlowLayout(FlowLayout.LEFT));
		buttonP.add(redB);
		buttonP.add(greenB);
		buttonP.add(blueB);
		
		
		// 하지않을경우 모든 카드가 일정하게  배치된다.
		cardP.setLayout(cardLayout);

		// 첫번쨰 인자값
		// 해당 패널(컴포넌트)
		// 두번째 인자값
		// 카드에 대한 이름을 지정한다
		cardP.add(redP, "Red");
		cardP.add(greenP, "Green");
		cardP.add(blueP, "Blue");
		
		add(buttonP, BorderLayout.NORTH);
		add(cardP, BorderLayout.CENTER);
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
		
		// 카드패널 바꾸기 이벤트 처리
		redB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showCard("Red");
				
			}
		});
		
		greenB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showCard("Green");
				
			}
		});
		
		blueB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showCard("Blue");
				
			}
		});
		
	}	
	
	// --------------- event 처리를 위한 메소드들 ----------------
	
	/**
	 * 카드 교체 기능
	 * 기능을 만든후에 이벤트에서 메소드로 호출하는 방식으로 구현
	 * 바로 이벤트에서 처리하지않도록
	 */
	
	public void showCard(String cardID){
		cardLayout.show(cardP, cardID);
	}
	
	
	/**
	 * 종료
	 */
	public void exit(){
		setVisible(false);
		dispose();
		System.exit(0);
	}

	public static void main(String[] args) {
		CardLayoutFrame frame = new CardLayoutFrame("카드 레이아웃 연습");
		
		frame.setSize(400, 500);
		frame.setComponents();
		frame.setVisible(true);
		frame.eventRegist();
	}
	
}










