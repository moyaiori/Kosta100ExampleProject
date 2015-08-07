package kr.or.kosta.ims.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import kr.or.kosta.ims.model.Inventory;
import kr.or.kosta.ims.util.GUIUtil;
/**
 * 악기 재고 관리 시스템의 메인화면
 * @author 신영선
 *
 */
public class MainFrame extends JFrame {
	
	
	Inventory ivt = new Inventory(10,2); // 악기를 저장할 목록!

	InventoryPanel invenP;
	RegistNewPanel registP;
	JPanel logingP;

	JLabel logingLabel;
	JButton logoutB;
	JTabbedPane tabPane;

	LoginFrame lgF;
	
	public MainFrame(LoginFrame login){
		this("no-title", login);
	}
	
	public MainFrame(String title, LoginFrame login){	
		
		super(title);
		
		lgF =  login;
		
		invenP = new InventoryPanel(this);		
		registP = new RegistNewPanel(this);
		
		registP.styles.setEnabled(false); // 신규악기등록화면 처음 입장(?)시 스타일 콤보박스 비활성화 - 기타선택 
		
		logingP = new JPanel();
		logingP.setLayout(new GridLayout(1, 5));
		
		logingLabel = new JLabel("방긋방긋 로그인중...");
		logoutB = new JButton("로그아웃");		
		
		logingP.add(logingLabel);
		logingP.add(new Label(""));
		logingP.add(new Label(""));
		logingP.add(logoutB);
		
		tabPane = new JTabbedPane();
		
		tabPane.addTab("악기재고 현황", invenP);
		tabPane.addTab("신규악기 등록", registP);
		
		setComponents();
		eventRegist();
	}
	
	public void setComponents(){
		add(logingP, BorderLayout.NORTH);
		add(tabPane, BorderLayout.CENTER);
	}
	
	public void exit(){
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	
	/** 사용자 정의 메소드 */
	/**
	 * 로그아웃 버튼 눌렀을 때, 로그인 프레임 보이기
	 */
	public void changeFrame(){
		setVisible(false);
		dispose();
		
		GUIUtil.setLookNFeel(lgF, GUIUtil.THEME_NIMBUS);
		lgF.setVisible(true);

	}
	
	
	/** 이벤트 등록 */
	public void eventRegist(){
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		
		/**
		 * 로그아웃 버튼 클릭시, 다시 로그인 창으로 돌아가기
		 */
		logoutB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				changeFrame();
				
			}
		});
	}
}
