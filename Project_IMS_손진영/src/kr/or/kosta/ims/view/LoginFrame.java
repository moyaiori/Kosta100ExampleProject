package kr.or.kosta.ims.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * 로그인 화면과 배경을 담을 프레임
 * @author 손진영
 *
 * 작성일 : 2015-08-03
 */
public class LoginFrame extends JFrame {
	/** 프레임에 부착할 Panel */
	LoginPanel loginPanel;
	JLabel inforL;
	
	/** 생성자 */
	public LoginFrame(){
		this("악기 재고 관리 시스템-로그인");
	}
	
	public LoginFrame(String title){
		super(title);
		loginPanel = new LoginPanel(this);
		inforL = new JLabel("id : kosta, passwd : 1111");
		inforL.setForeground(Color.RED);
		
	}
	
	/** 컴포넌트를 프레임에 부착 */
	public void setComponents(){
		add(loginPanel, BorderLayout.CENTER);
		add(inforL, BorderLayout.NORTH);
	}
	
	/** 이벤트 처리 */
	public void eventReist(){
		loginPanel.eventRegist();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
	}
	
	/** 화면 종료 메소드 */
	private void exit(){
		setVisible(false);
		dispose();
		System.exit(0);
	}
}
