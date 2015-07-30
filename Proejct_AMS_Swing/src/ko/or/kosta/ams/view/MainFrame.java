package ko.or.kosta.ams.view;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import kr.or.kosta.ams.model.AccountManager;


public class MainFrame extends Frame {
	AccountManager manager;
	MainPanel panel;
	
	public MainFrame(){
		this("KOSTA은행 계좌관리 - 메인화면");
	}
	public MainFrame(String title){
		super(title);
		
		// 연관 관계시에 이런식으로
//		this.manager = manager;
		// 집합관계일시
		manager = new AccountManager();
		panel = new MainPanel(manager);
	}
	
	/**
	 * 화면 배치
	 */
	public void setComponents(){
		
		add(panel);
//		setLayout(new BorderLayout());
//		add(panel, BorderLayout.CENTER);
	}
	/**
	 * 프레임 종료 메서드
	 */
	private void exit(){
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	/**
	 * 이벤트 등록 및 처리
	 */
	public void eventRegist(){
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
	}
}
