import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/**
 * UI와 별도로 작성한 이벤트 처리 클래스
 * 마우스, 액션, 윈도우 이벤트 처리를 위한 이벤트 핸들러
 * @author Lee Gwangyong
 *
 */
public class EventHandler extends WindowAdapter implements MouseListener, ActionListener {

	UserFrame userFrame;
	
	// 외부 클래스에서 접근하기위해 생성자로 초기화 해준다.
	public EventHandler(UserFrame userFrame) {
		this.userFrame = userFrame;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse Event Cliecked");
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Mouse Event Entered");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("Mouse Event Exited");
	}
	
	//----------- window listener(Adapter) -------------
	@Override
	public void windowClosing(WindowEvent e) {
		userFrame.exit();
	}

	//----------- action listener -------------
	@Override
	public void actionPerformed(ActionEvent e) {
		userFrame.setMessage("버튼이 클릭되었습니다.");
	}

}











