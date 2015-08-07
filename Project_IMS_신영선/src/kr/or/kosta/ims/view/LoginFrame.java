package kr.or.kosta.ims.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import kr.or.kosta.ims.util.GUIUtil;
/**
 * 로그인 화면 프레임
 * @author 신영선
 *
 */
public class LoginFrame extends JFrame{
	
	LoginPanel loginP;
	//ImagePanel imgP;
	MainFrame mainF;
	
	public LoginFrame() {
		this("no-title");
	}

	public LoginFrame(String title) {
		super(title);
		loginP = new LoginPanel();
		//imgP = new ImagePanel();
		mainF = new MainFrame("악기재고관리시스템 - 메인화면", this);
	}

	public void setComponents() {
		setLayout(new BorderLayout());
		add(loginP, BorderLayout.CENTER);
		//add(imgP, BorderLayout.CENTER);
		
	}
	
	public void exit(){
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	/** 사용자 정의 메소드 */
	
	/** 
	 * #1. 로그인 버튼을 눌렀을 때, 로그인화면을 끄고 메인화면으로 넘어가기 
	 */
	public void changeFrame(){
		StringBuffer a = new StringBuffer();
		a.append(loginP.passwdF.getPassword());
		if(loginP.idTF.getText().equals("") && a.toString().equals("")){
			JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 입력해주세요!","알림", JOptionPane.WARNING_MESSAGE);
		}else if(a.toString().equals("")){
			JOptionPane.showMessageDialog(this, "비밀번호를 입력해주세요!","알림", JOptionPane.WARNING_MESSAGE);
		}else if(loginP.idTF.getText().equals("")){
			JOptionPane.showMessageDialog(this, "아이디를 입력해주세요!","알림", JOptionPane.WARNING_MESSAGE);
		}else{
			setVisible(false);
			dispose();
			
			GUIUtil.setLookNFeel(mainF, GUIUtil.THEME_NIMBUS);
			mainF.setVisible(true);
			mainF.setSize(450,400);
			GUIUtil.setCenterScreen(mainF);
			
			//로그인 페이지 - idTF / passwdF 비우기
			loginP.idTF.setText("");
			loginP.passwdF.setText("");
		}
	
	}
	

	/** 이벤트 등록 */
	public void eventRegist(){
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		
		
		/** 로그인 버튼을 눌렀을 때 */
		loginP.loginB.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				changeFrame();		
			}
		});
		
	}
}
