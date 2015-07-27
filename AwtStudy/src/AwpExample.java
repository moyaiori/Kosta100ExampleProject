import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.TextField;

/**
 * Frame 생성 및 사용
 * @author Lee Gwangyong
 *
 */
public class AwpExample {

	public static void main(String[] args) {
		// 외부 컨테이너 생성
		Frame window = new Frame("첫번째 Frame");
		window.setResizable(false);
//		window.setSize(300, 300);
		window.setVisible(true);
//		window.setLocation(200, 200);
		Rectangle rec = new Rectangle(200, 200, 400, 400);
//		window.setBounds(200, 200, 400, 400);
		window.setBounds(200, 200, 400, 400);
		
		// 비주얼 컴포넌트
		Button button = new Button("AWT버튼");
		button.setBackground(new Color(155, 120, 90));
		button.setForeground(Color.CYAN);
		button.setFont(new Font("굴림", Font.BOLD + Font.ITALIC, 20));
		button.setEnabled(false);
		
		Label label = new Label("AWT Label");
		label.setBackground(new Color(90, 200, 50));
		label.setForeground(Color.blue);
		
		
		TextField tf = new TextField("아이디",10);
		Choice choice = new Choice();
		choice.add("삼성 라이언즈");
		choice.add("기아 타이거즈");
		choice.add("넥센 히어로즈");
		choice.add("두산 베어즈");
		choice.add("LG 트윈즈");
		
		// 프레임의 배치관리자를 변경
		window.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		window.add(button);
		window.add(label);
		window.add(tf);
		window.add(choice);
		
		Container container = button.getParent();
		Component[] childs = container.getComponents();
		
		for (Component component : childs) {
			component.setBackground(Color.DARK_GRAY);
			component.setForeground(Color.GREEN);
		}
		
	}
}
