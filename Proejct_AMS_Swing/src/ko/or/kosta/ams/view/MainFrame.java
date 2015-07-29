package ko.or.kosta.ams.view;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import kr.or.kosta.ams.model.Account;
import kr.or.kosta.ams.model.AccountManager;
import kr.or.kosta.ams.model.AccountTableModel;
import kr.or.kosta.ams.model.MinusAccount;


public class MainFrame extends Frame {
	AccountManager manager;
	MainPanel panel;
	TextArea showTA;
	JTable showTB;
	AccountTableModel accModel;

	
	public MainFrame(){
		this("KOSTA은행 계좌관리 - 메인화면");
	}
	public MainFrame(String title){
		super(title);
		
		// 연관 관계시에 이런식으로
//		this.manager = manager;
		// 집합관계일시
		manager = new AccountManager();
		panel = new MainPanel();
		showTA = new TextArea();
		
		accModel = new AccountTableModel();
		showTB = new JTable(accModel);
		
	}
	
	/**
	 * 화면 배치
	 */
	public void setComponents(){
		setLayout(new BorderLayout());
		// 초이스 아이템 초기값이 입출금계좌 및 전체 이기때문에 대출금 막기
		setEnableBrowTF(true);
		add(panel, BorderLayout.NORTH);
//		add(showTA, BorderLayout.CENTER);
		add(new JScrollPane(showTB), BorderLayout.CENTER);
		
	}
	
	//------------------- 이벤트 처리 관련 메서드---------------
	
	/**
	 * 프레임 종료 메서드
	 */
	private void exit(){
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	/**
	 * 입출금 계좌선택시 대출금액 선택 불가
	 */
	private void setEnableBrowTF(boolean bool){
		if (bool) {
			panel.accBrowTF.setEnabled(false);
		}else{
			panel.accBrowTF.setEnabled(true);
		}
	}
	/**
	 * 검색한 계좌로 보여주기 (조회)
	 */
	private void lookUpAccount(String accNum){
		Account acc = manager.getAccount(accNum);
		accModel.resultAccount(acc);
	}
	
	/**
	 * 계좌 삭제(삭제)
	 */
	private void removeAccount(String accNum){
		manager.removeAccount(accNum);
		accModel.updateAccount(manager.getAccounts());
	}
	
	/**
	 * 예금주 명으로 검색하기 (검색)
	 */
	private void searchAccount(String accOwner){
		List<Account> list = manager.searchAccount(accOwner);
		accModel.resultAccount(list);
	}
	
	/**
	 * 입출금 계좌 개설 (신규등록)
	 */
	private void openAcction(){
		// TODO 성공 여부에 따른 팝업창 구현
		manager.openAccount(new Account(
				panel.accNumTF.getText(), 
				panel.accOwnrTF.getText(),
				Integer.parseInt(panel.passTF.getText()), 
				Long.parseLong(panel.accDrawMoneyTF.getText()))
				);
		accModel.updateAccount(manager.getAccounts());
	}
	
	/**
	 * 마이너스 계좌 개설 (신규등록)
	 */
	private void openMinusAcction(){
		// TODO 성공 여부에 따른 팝업창 구현
		manager.openAccount(new MinusAccount(
				panel.accNumTF.getText(), 
				panel.accOwnrTF.getText(),
				Integer.parseInt(panel.passTF.getText()), 
				Long.parseLong(panel.accDrawMoneyTF.getText()),
				Long.parseLong(panel.accBrowTF.getText()))
				);
		accModel.updateAccount(manager.getAccounts());
	}
	
	//----------------------------------------------------------------
	
	/**
	 * 이벤트 등록 및 처리
	 */
	public void eventRegist(){
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				exit();
			}
		});
		
		// 입출금계좌 텍스트필드 활성화 이벤트
		panel.accKindC.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getItem() == "입출금계좌") {
					setEnableBrowTF(true);
				}else{
					setEnableBrowTF(false);
				}
			}
		});
		
		// 계좌 번호 조회 (조회)
		panel.accLookUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lookUpAccount(panel.accNumTF.getText());
			}
		});
		
		// 계좌 삭제
		panel.accDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAccount(panel.accNumTF.getText());
			}
		});
		
		// 예금주명으로 검색
		panel.accSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchAccount(panel.accOwnrTF.getText());
				
			}
		});
		
		// 계좌 신규 등록
		panel.accNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (panel.accKindC.getSelectedItem() == "입출금계좌") {
					openAcction();
				}else if(panel.accKindC.getSelectedItem() == "마이너스계좌"){
					openMinusAcction();
				}else {
					return;
				}
			}
			
		});
		
		// 계좌 전체 조회
		panel.accAllLookUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accModel.updateAccount(manager.getAccounts());
			}
		});
	}
}
