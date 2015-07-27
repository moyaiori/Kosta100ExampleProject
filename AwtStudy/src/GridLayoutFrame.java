import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
/**
 * GridLayout 활용
 * @author Lee Gwangyong
 *
 */
public class GridLayoutFrame extends Frame {
	Button[] buttons; // 그리드 버튼을 위한 배열
	
	
	public GridLayoutFrame(){
		this("non - title");
	}
	
	public GridLayoutFrame(String title){
		super(title); // setTitle();
		buttons = new Button[100];
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new Button("버튼" + (i+1));
		}
		
	}
	
	// 화면배치
	public void setComponents(){
		setLayout(new GridLayout(10, 10));
		
		for (Button button : buttons) {
			add(button);
		}
		
//		ChatFrame.ExitHandler eventHandler = new ChatFrame().new ExitHandler();
		addWindowListener(new ChatFrame().new ExitHandler());
		
	}

}
