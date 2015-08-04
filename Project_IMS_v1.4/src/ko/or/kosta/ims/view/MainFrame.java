package ko.or.kosta.ims.view;

/**
 * 메인 전체 화면
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import ko.or.kosta.ims.util.GuiUtil;


public class MainFrame extends JFrame {

	MainUI mainPanel;
	JPanel topPanel;
	
	JLabel loginUserL;
	JButton loginOutBtn;
	
	LoginFrame loginFrame;

	public MainFrame() {
		this("악기재고관리시스템 - 메인화면");
	}

	public MainFrame(String title) {
		super(title);

		mainPanel = new MainUI();
		topPanel = new JPanel();
		
		loginUserL = new JLabel(new LoginFrame().getId() + "님이 로그인중...");
		loginOutBtn = new JButton("로그아웃");
	}

	public void setComponents() {
		setLayout(new BorderLayout());

		loginUserL.setBorder(new EmptyBorder(10, 10, 10, 0));
		
		topPanel.setLayout(new BorderLayout(50,20));
		topPanel.add(loginUserL, BorderLayout.WEST);
		topPanel.add(loginOutBtn, BorderLayout.EAST);
		
		
		add(mainPanel, BorderLayout.CENTER);
		add(topPanel, BorderLayout.NORTH);
	}

	/**
	 * 프레임 종료 메서드
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
	 * 로그인 다시 띄우기
	 */
	private void viewLoginUI(){
		loginFrame = new LoginFrame();
		loginFrame.setSize(300, 270);
		GuiUtil.setCenterScreen(loginFrame);
		GuiUtil.setLookNFeel(loginFrame, GuiUtil.THEME_NIMBUS);

		loginFrame.setVisible(true);
		loginFrame.eventRegist();
		loginFrame.setComponents();
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
		
		loginOutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				viewLoginUI();
				exit();
			}
		});
	}
}
