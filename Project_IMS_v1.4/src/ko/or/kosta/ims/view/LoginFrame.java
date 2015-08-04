package ko.or.kosta.ims.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;import java.util.logging.LoggingPermission;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ko.or.kosta.ims.util.GuiUtil;

public class LoginFrame extends JFrame{
	
	LoginUI loginPanel;
	
	String id, password;

	MainFrame mainFrame;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LoginFrame(){
		this("악기재고 관리시스템 - 로그인");
		
	}
	
	public LoginFrame(String title){
		super(title);
		loginPanel = new LoginUI();
	
		
		id = "이광용";
		password = "1234";
		setComponents();
	}
	
	public void setComponents(){
		add(loginPanel);
	}
	
	/**
	 * 로그인 확인
	 * @return
	 */
	public boolean checkLogin(){
		System.out.println("로그인");
		
		if (loginPanel.idTF.getText().equals(id) && loginPanel.passTF.getText().equals(password)) {
			System.out.println("아이디 확인");
			viewMainUI();
			exit();
			return true;
		}else{
			System.out.println("로그인 실패");
			JOptionPane.showMessageDialog(this, "아이디 혹은 패스워드를 입력하지않았거나 맞지않습니다.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
			loginPanel.idTF.setText("");
			loginPanel.passTF.setText("");
			return false;
		}
	}
	
	/**
	 * 메인 띄우기
	 */
	private void viewMainUI(){
		mainFrame = new MainFrame();
		mainFrame.setSize(550, 680);
		GuiUtil.setCenterScreen(mainFrame);
		GuiUtil.setLookNFeel(mainFrame, GuiUtil.THEME_NIMBUS);
		
		mainFrame.setVisible(true);
		mainFrame.eventRegist();
		mainFrame.setComponents();
	}
	
	/**
	 * 로그인 패널만 제거
	 */
	private void exit() {
		setVisible(false);
		dispose();
//		System.exit(0);
	}

	/**
	 * 프레임 종료 메서드
	 */
	private void exitFrame() {
		setVisible(false);
		dispose();
		System.exit(0);
	}

	/**
	 * 이벤트 등록 및 처리
	 */
	public void eventRegist() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exitFrame();
			}
		});
		
		loginPanel.loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				checkLogin();
			}
		});
	}

}
