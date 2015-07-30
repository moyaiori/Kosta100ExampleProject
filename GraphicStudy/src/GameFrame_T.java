import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * 화면 갱신 관련 처리
 * @author 김기정
 *
 */
public class GameFrame extends Frame implements KeyListener{
	
	GamePanel panel;
	Button leftB, topB, rightB, bottomB;
	Panel southPanel, directionPanel;
	
	public GameFrame() {
		panel = new GamePanel();
		leftB = new Button("◀");
		topB = new Button("▲");
		rightB = new Button("▶");
		bottomB = new Button("▼");
		
		southPanel = new Panel();
		directionPanel = new Panel();
	}
	
	public void setComponents(){
		directionPanel.setLayout(new GridLayout(3, 3));
		directionPanel.add(new Label(""));
		directionPanel.add(topB);
		directionPanel.add(new Label(""));
		directionPanel.add(leftB);
		directionPanel.add(new Label(""));
		directionPanel.add(rightB);
		directionPanel.add(new Label(""));
		directionPanel.add(bottomB);
		directionPanel.add(new Label(""));
		southPanel.add(directionPanel);
		add(panel,BorderLayout.CENTER);
		add(southPanel,BorderLayout.SOUTH);
	}
	
	public void exit(){
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	public void eventRegist(){
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		
		
		leftB.addKeyListener(this);
		rightB.addKeyListener(this);
		topB.addKeyListener(this);
		bottomB.addKeyListener(this);
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			leftB.requestFocus();
			panel.move(GamePanel.Direction.LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			rightB.requestFocus();
			panel.move(GamePanel.Direction.RIGHT);
			break;
		case KeyEvent.VK_UP:
			topB.requestFocus();
			panel.move(GamePanel.Direction.UP);
			break;
		case KeyEvent.VK_DOWN:
			bottomB.requestFocus();
			panel.move(GamePanel.Direction.DOWN);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	public static void main(String[] args) {
		GameFrame frame = new GameFrame();
		frame.setComponents();
		frame.eventRegist();
		frame.setSize(600, 500);
		frame.setVisible(true);	
	}

}
