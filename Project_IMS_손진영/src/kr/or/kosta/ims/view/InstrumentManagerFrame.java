package kr.or.kosta.ims.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import kr.or.kosta.ims.model.Inventory;
import kr.or.kosta.ims.util.GUIUtil;
/**
 * 로그인 후 악기 재고를 관리하는 프레임
 * @author 손진영
 *
 * 작성일 : 2015-08-03
 */

public class InstrumentManagerFrame extends JFrame {
	/** 프래임에 속할 패널 */
	InstrumentPanel tableP;
	InstrumentAddPanel addP;
	TopPanel topP;
	JPanel centerP;

	/** JTabbedPane */
	JTabbedPane tabPane;
	
	/** 데이터를 관리한 매니져 */
	Inventory manager;
	
	/** 생성자 */
	public InstrumentManagerFrame() {
		this("악기 재고 관리 시스템 - 메인화면");
	}

	public InstrumentManagerFrame(String title) {
		super(title);
		manager = new Inventory(10, 2);
		tableP = new InstrumentPanel(manager);
		addP = new InstrumentAddPanel(manager);
		topP = new TopPanel();
		centerP = new JPanel();
		
		/** Tab에 2가지 패널 추가 */
		tabPane = new JTabbedPane();
		tabPane.addTab("악기재고현황", tableP);
		tabPane.addTab("신규악기등록", addP);
		centerP.setLayout(new BorderLayout());
		centerP.add(tabPane, BorderLayout.CENTER);
	}
	
	/** 화면배치 */
	public void setComponents(){	
		add(topP, BorderLayout.NORTH);
		add(centerP, BorderLayout.CENTER);
	}
	
	/** 이벤트 처리 */
	public void eventRegist(){
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		/** 로그아웃 버튼 클릭시 화면 전환 이벤트 처리 */
		topP.logoutB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				logout();
			}
		});
	}
	
	/** 메인화면이 종료되고 로그인 화면 활성화 */
	public void logout(){
		LoginFrame frame = new LoginFrame();
		frame.setSize(400, 300);
		frame.setComponents();
		GUIUtil.setCenterScreen(frame);
		GUIUtil.setLookNFeel(frame, GUIUtil.THEME_NIMBUS);
		frame.setVisible(true);
		frame.eventReist();
		setVisible(false);
		dispose();
	}
	
	/** 화면 종료 */
	public void exit(){
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
}
