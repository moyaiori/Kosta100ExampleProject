import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EmailFrame extends Frame{
	EmailPanel emailPanel;
	Button sendB, cancleB;
	Panel buttonPanel;
	
	MenuBar menuBar;
	Menu fileMenu;
	MenuItem newMI, exitMI, newAddMI;
	
	
	public EmailFrame(){
		this("No-Title");
	}
	public EmailFrame(String title){
		super(title);
		emailPanel = new EmailPanel();
		
		sendB = new Button("보내기");
		cancleB = new Button("취  소");
		buttonPanel = new Panel();
		
		createMenu();
	}
	
	private void createMenu(){
		// 서브메뉴를 넣을땐 메뉴 아이템 밑에 메뉴 아이템을 넣으면 된다.
		menuBar = new MenuBar();
		fileMenu = new Menu("FIle");
		
		newMI = new MenuItem("New");
		newMI.setShortcut(new MenuShortcut(KeyEvent.VK_N));
		exitMI = new MenuItem("Exit");
		exitMI.setShortcut(new MenuShortcut(KeyEvent.VK_Q));
		
		fileMenu.add(newMI);
		fileMenu.addSeparator();
		fileMenu.add(exitMI);
		menuBar.add(fileMenu);
		setMenuBar(menuBar);
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
		
		exitMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				exit();
			}
		});
	}
	
	public static void main(String[] args) {
		EmailFrame frame = new EmailFrame("이메일 보내기 화면 실습");
		frame.setSize(500, 350);
		frame.setComponents();
		
		GuiUtil.setCenterScreen(frame);
		
		frame.setVisible(true);
		frame.eventRegist();
	}
	
}








