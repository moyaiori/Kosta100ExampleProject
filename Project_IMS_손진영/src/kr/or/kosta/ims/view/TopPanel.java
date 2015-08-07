package kr.or.kosta.ims.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kr.or.kosta.ims.util.GUIUtil;
/**
 * 상단에 로그인 정보와 로그아웃 버튼을 보여줄 패널
 * @author 손진영
 *
 * 작성일 : 2015-08-03
 */
public class TopPanel extends JPanel {
	/** 컴포넌트 */
	JLabel userL;
	JButton logoutB;
	
	/** 생성자 */
	public TopPanel(){
		userL = new JLabel("손진영님 로그인..");
		logoutB = new JButton("로그아웃");
		setComponents();
	}
	
	/** 화면 배치 */
	public void setComponents(){
		setLayout(new BorderLayout());
		logoutB.setSize(100, 30);
		add(userL, BorderLayout.WEST);
		add(logoutB, BorderLayout.EAST);
	}
}
