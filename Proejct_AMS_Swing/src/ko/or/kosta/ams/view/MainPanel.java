package ko.or.kosta.ams.view;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import kr.or.kosta.ams.model.Account;
import kr.or.kosta.ams.model.AccountManager;
import kr.or.kosta.ams.model.MinusAccount;

/**
 * 상단의 
 * @author Lee Gwangyong
 *
 */
public class MainPanel extends Panel {
	JLabel accKindLB, accNumLB, accOwnrLB, passLB, accDrawMoneyLB ,accBrowLB;
	JTextField accNumTF, accOwnrTF, passTF, accDrawMoneyTF, accBrowTF;
	JButton accLookUp, accDelete,  accSearch, accNew, accAllLookUp;
	JComboBox<String> accKindC;
	JLabel accList, money;
	
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	AccountManager manager;
	
	AccountTableModel accModel;
	JTable showTB;
	
	public MainPanel(){
		this(null);
	}
	
	
	public MainPanel(AccountManager manager){
		accKindLB = new JLabel("계좌종류");
		accNumLB = new JLabel("계좌번호");
		accOwnrLB = new JLabel("예금주명");
		passLB = new JLabel("비밀번호");
		accDrawMoneyLB = new JLabel("입금금액");
		accBrowLB = new JLabel("대출금액");
		
		accNumTF = new JTextField();
		accOwnrTF = new JTextField();
		passTF = new JTextField();
		accDrawMoneyTF = new JTextField();
		accBrowTF = new JTextField();
		
		accLookUp = new JButton("조 회");
		accDelete = new JButton("삭 제");
		accSearch = new JButton("검 색");
		accNew = new JButton("신규등록");
		accAllLookUp = new JButton("전체조회");
		
		accKindC = new JComboBox<String>();
		accKindC.addItem("전체");
		accKindC.addItem("입출금계좌");
		accKindC.addItem("마이너스계좌");
		
		accList = new JLabel("계좌목록");
		money = new JLabel("(단위 : 원)");
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		

		accModel = new AccountTableModel();
		showTB = new JTable(accModel);
		
		this.manager = manager;
//		showTB = new JTable(5,5);
		
		
		setComponents();
		eventRegist();
		
		testData();
		printAllAccount();
	}
	
	
	
	/**
	 * 화면 구성
	 */
	public void setComponents(){
		
		setLayout(gridBagLayout);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.insets = new Insets(3,5,3,5);
		
		add(accKindLB, 		0, 0, 1, 1, 0.0, 0.0);
		add(accKindC, 		1, 0, 2, 1, 0.0, 0.0);
		
		add(accNumLB,	 	0, 1, 1, 1, 0.0, 0.0);
		add(accNumTF, 		1, 1, 2, 1, 0.0, 0.0);
		add(accLookUp, 		3, 1, 1, 1, 0.0, 0.0);
		add(accDelete, 		4, 1, 1, 1, 0.0, 0.0);
		add(new Label(" "), 5, 1, 1, 1, 0.0, 0.0);
		add(new Label(" "), 6, 1, 1, 1, 0.0, 0.0);
		
		add(accOwnrLB, 		0, 2, 1, 1, 0.0, 0.0);
		add(accOwnrTF, 		1, 2, 2, 1, 0.0, 0.0);
		add(accSearch, 		3, 2, 1, 1, 0.0, 0.0);
		
		add(passLB, 		0, 3, 1, 1, 0.0, 0.0);
		add(passTF, 		1, 3, 2, 1, 0.0, 0.0);
		add(accDrawMoneyLB, 3, 3, 1, 1, 0.0, 0.0);
		add(accDrawMoneyTF, 4, 3, 3, 1, 0.0, 0.0);
		
		add(accBrowLB, 		0, 4, 1, 1, 0.0, 0.0);
		add(accBrowTF, 		1, 4, 2, 1, 0.0, 0.0);
		add(accNew, 		3, 4, 1, 1, 0.0, 0.0);
		add(accAllLookUp, 	4, 4, 1 ,1, 0.0, 0.0);
		add(new Label(" "), 5, 4, 1, 1, 0.0, 0.0);
		
		add(accList, 		0, 5, 1, 1, 0.0, 0.0);
		add(money, 			6, 5, 1, 1, 0.0, 0.0);
		
		add(showTB, 		0, 6, 6, 5, 1.0, 1.0);
		
	}
	
	/**
	 * 그리드 백 구성
	 * @param component
	 * @param gridx
	 * @param gridy
	 * @param gridwidth
	 * @param gridheight
	 * @param weightx
	 * @param weighty
	 */
	private void add(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty){
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth  = gridwidth;
		gridBagConstraints.gridheight  = gridheight;
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;
		gridBagLayout.setConstraints(component, gridBagConstraints);
		add(component);
	}
	
	/**
	 * 테스트용 데이터
	 */
	
	private void testData(){
		manager.openAccount(new Account("1111-1111", "이광용", 1234, 100000));
		manager.openAccount(new Account("2222-2222", "가승호", 1234, 1000000));
		manager.openAccount(new MinusAccount("3333-3333", "안상이", 1234, 10000, 5000));
		manager.openAccount(new MinusAccount("4444-4444", "조현빈", 1234, 100000, 5000000));
	}
	
	//**********************************************************
	//***************이벤트 처리 부분 메서드화******************
	//**********************************************************
	
	/**
	 * 입출금 계좌선택시 대출금액 선택 불가
	 */
	private void setEnableBrowTF(boolean bool){
		if (bool) {
			accBrowTF.setEnabled(false);
		}else{
			accBrowTF.setEnabled(true);
		}
	}
	/**
	 * 전체 계좌 조회(전체조회)
	 */
	private void printAllAccount(){
		accModel.resultAccountList(manager.getAccounts());
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
		accModel.resultAccountList(manager.getAccounts());
	}
	
	/**
	 * 예금주 명으로 검색하기 (검색)
	 */
	private void searchAccount(String accOwner){
		List<Account> list = manager.searchAccount(accOwner);
		accModel.resultAccountList(list);
	}
	
	/**
	 * 입출금 계좌 개설 (신규등록)
	 */
	private void openAcction(){
		// TODO 성공 여부에 따른 팝업창 구현
		manager.openAccount(new Account(
				accNumTF.getText(), 
				accOwnrTF.getText(),
				Integer.parseInt(passTF.getText()), 
				Long.parseLong(accDrawMoneyTF.getText()))
				);
		accModel.resultAccountList(manager.getAccounts());
	}
	
	/**
	 * 마이너스 계좌 개설 (신규등록)
	 */
	private void openMinusAcction(){
		// TODO 성공 여부에 따른 팝업창 구현
		manager.openAccount(new MinusAccount(
				accNumTF.getText(), 
				accOwnrTF.getText(),
				Integer.parseInt(passTF.getText()), 
				Long.parseLong(accDrawMoneyTF.getText()),
				Long.parseLong(accBrowTF.getText()))
				);
		accModel.resultAccountList(manager.getAccounts());
	}
	
	//*********************************************************
	//***********************이벤트 등록***********************
	//*********************************************************
	
	
	public void eventRegist(){
		// 입출금계좌 텍스트필드 활성화 이벤트
		accKindC.addItemListener(new ItemListener() {
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
		accLookUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lookUpAccount(accNumTF.getText());
			}
		});
		
		// 계좌 삭제
		accDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAccount(accNumTF.getText());
			}
		});
		
		// 예금주명으로 검색
		accSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchAccount(accOwnrTF.getText());
				
			}
		});
		
		// 계좌 신규 등록
		accNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (accKindC.getSelectedItem() == "입출금계좌") {
					openAcction();
				}else if(accKindC.getSelectedItem() == "마이너스계좌"){
					openMinusAcction();
				}else {
					return;
				}
			}
			
		});
		
		// 계좌 전체 조회
		accAllLookUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				printAllAccount();
			}
		});
	
	}
	
	
//	public static void main(String[] args) {
//		Frame frame = new Frame();
//		MainPanel mp = new MainPanel();
//		frame.add(mp);
//		frame.setSize(500, 400);
//		frame.setVisible(true);
//	}
	
}
