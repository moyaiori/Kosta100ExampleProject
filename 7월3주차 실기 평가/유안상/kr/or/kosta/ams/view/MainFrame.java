package kr.or.kosta.ams.view;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import kr.or.kosta.ams.model.AccountManager;

public class MainFrame extends Frame {
	MainPanel mainPanel;
	AccountManager manager;

	/** 프레임의 생성자(오버로딩) 인스턴스변수를을 생성하고 타이틀을 결정한다*/
	public MainFrame(){
		this("KOSTA은행 계좌관리 - 메인화면");
	}
	public MainFrame(String title){
		super(title);
		this.manager = new AccountManager();
		mainPanel = new MainPanel();
		mainPanel.setEvent();
	}
	
	/** 컴포넌트를 생성하는 메소드
	 *  이곳에서는 패널을 부착하기만 하면 된다.
	 */
	public void setComponent(){
		add(mainPanel);
	}
	
	/** 종료 메소드 */
	public void exit(){
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	/** M이벤트메소드를 등록 */
	public void setEvent(){
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e){
				exit();
			}
		});
	}
}
