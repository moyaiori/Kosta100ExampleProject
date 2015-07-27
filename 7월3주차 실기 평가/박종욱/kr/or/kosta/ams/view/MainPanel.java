package kr.or.kosta.ams.view;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import kr.or.kosta.ams.model.Account;
import kr.or.kosta.ams.model.AccountManager;
import kr.or.kosta.ams.model.MinusAccount;

public class MainPanel extends Panel {

	Label kindL, numL, nameL, pwL, borrowL, depositL, listL, wonL;
	TextField numTF, nameTF, pwTF, borrowTF, depositTF;
	Button selectB, deleteB, searchB, enrollB, allB;
	Choice kindCh;
	TextArea listTA;
	
	GridBagLayout grid;
	GridBagConstraints cons;
	
	AccountManager manager;
	StringBuilder sb; // TextArea 출력 도움 변수
	String bar; // 수평선 출력 변수
	
	public MainPanel(){}
	
	public MainPanel(AccountManager manager){
		this.manager = manager;
		manager.openAccount(new Account("1111-2222", "박종욱", 2521, 100000));
		manager.openAccount(new Account("1611-1551", "김구리", 1421, 200000));
		manager.openAccount(new Account("1234-1234", "김구리", 1221, 300000));
		manager.openAccount(new MinusAccount("1881-3851", "김호민", 7771, 1500000, 5000000));
		manager.openAccount(new Account("1011-8998", "김호민", 7271, 1000000));
		manager.openAccount(new MinusAccount("5822-1599", "김대출", 1261, 500000, 5000000));
		bar = ("--------------------------------------------------------------------------\n");
		
		grid = new GridBagLayout();
		cons = new GridBagConstraints();
		
		kindL = new Label("계좌종류");
		numL = new Label("계좌번호");
		nameL = new Label("예금주명");
		pwL = new Label("비밀번호");
		borrowL = new Label("대출금액");
		depositL = new Label("입금금액");
		listL = new Label("계좌목록");
		wonL = new Label("(단위: 원)");
		
		numTF = new TextField(18);
		nameTF = new TextField();
		pwTF = new TextField();
		borrowTF = new TextField();
		depositTF = new TextField();
		
		selectB = new Button("조회");
		deleteB = new Button("삭제");
		searchB = new Button("검색");
		enrollB = new Button("신규등록");
		allB = new Button("전체조회");
		
		kindCh = new Choice();
		listTA = new TextArea();
		
		setComponents();
	}
	
	public void setComponents(){
		setLayout(grid);
		cons.fill = GridBagConstraints.BOTH;
		cons.insets = new Insets(3, 5, 3, 5);
		
		pwTF.setText("1234");
		depositTF.setText("0");
		borrowTF.setText("0");
		borrowTF.setEnabled(false);
		wonL.setAlignment(FlowLayout.RIGHT);
		
		kindCh.add("전체");
		kindCh.add("입출금계좌");
		kindCh.add("마이너스계좌");

		addGridBag(kindL, 0, 0, 1, 1, 0.0, 0.0);
		addGridBag(kindCh, 1, 0, 1, 1, 1.0, 0.0);
		addGridBag(new Label(" "), 2, 0, 1, 1, 0.0, 0.0);
		addGridBag(new Label(" "), 3, 0, 1, 1, 0.0, 0.0);
		addGridBag(new Label(" "), 4, 0, 1, 1, 0.0, 0.0);
		addGridBag(new Label(" "), 5, 0, 1, 1, 0.0, 0.0);
		
		addGridBag(numL, 0, 1, 1, 1, 0.0, 0.0);
		addGridBag(numTF, 1, 1, 1, 1, 1.0, 0.0);
		addGridBag(selectB, 2, 1, 1, 1, 0.0, 0.0);
		addGridBag(deleteB, 3, 1, 1, 1, 0.0, 0.0);
		
		addGridBag(nameL, 0, 2, 1, 1, 0.0, 0.0);
		addGridBag(nameTF, 1, 2, 1, 1, 1.0, 0.0);
		addGridBag(searchB, 2, 2, 1, 1, 0.0, 0.0);

		addGridBag(pwL, 0, 3, 1, 1, 0.0, 0.0);
		addGridBag(pwTF, 1, 3, 1, 1, 0.0, 0.0);
		addGridBag(depositL, 2, 3, 1, 1, 0.0, 0.0);
		addGridBag(depositTF, 3, 3, 3, 1, 1.0, 0.0);
		
		addGridBag(borrowL, 0, 4, 1, 1, 0.0, 0.0);
		addGridBag(borrowTF, 1, 4, 1, 1, 1.0, 0.0);
		addGridBag(enrollB, 2, 4, 1, 1, 0.0, 0.0);
		addGridBag(allB, 3, 4, 1, 1, 0.0, 0.0);

		addGridBag(listL, 0, 5, 1, 1, 0.0, 0.0);
		addGridBag(wonL, 5, 5, 1, 1, 0.0, 0.0);
		
		addGridBag(listTA, 0, 6, 6, 1, 1.0, 1.0);
		
		eventRegist();
	}
	
	public void addGridBag(Component com, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty) {
		cons.gridx = gridx;
		cons.gridy = gridy;
		cons.gridwidth = gridwidth;
		cons.gridheight = gridheight;
		cons.weightx = weightx;
		cons.weighty = weighty;
		grid.setConstraints(com, cons);
		add(com);
	}
	
	// 이벤트 리스너 등록
	public void eventRegist(){
		allB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				printAccounts();
			}
		});
		
		selectB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectAccount();
			}
		});
		
		searchB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchAccount();
			}
		});
		
		deleteB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAccount();
			}
		});
		
		enrollB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				enrollAccount();
			}
		});
		
		kindCh.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getItem().equals("마이너스계좌"))
					borrowTF.setEnabled(true);
				else borrowTF.setEnabled(false);
			}
		});
	}
	
	// 출력 폼
	private void template(){
		sb = new StringBuilder();
		sb.append(bar);
		sb.append("계좌종류\t계좌번호\t예금주명\t현재잔액\t대출금액\n");
		sb.append(bar);
		sb.append(bar);
	}
	
	// 계좌 신규 등록
	private void enrollAccount(){
		int pw = Integer.parseInt(pwTF.getText());
		long restMoney = Integer.parseInt(depositTF.getText());
		long borrowMoney = Integer.parseInt(borrowTF.getText());
		
		if(numTF.getText().trim().equals("") || nameTF.getText().trim().equals("") || borrowTF.getText().equals("") ||
				pwTF.getText().trim().equals("") || depositTF.getText().trim().equals("")  ){
			listTA.setText("입력하지 않은 항목이 있습니다...");
		} else{ // 모든 정보 입력시
			if ( checkAccount() != 1) { // 계좌번호 미중복시
				if (kindCh.getSelectedItem().equals("입출금계좌")) {
					manager.openAccount(new Account(numTF.getText(), nameTF.getText(), pw, restMoney));
					listTA.setText("입출금계좌가 생성되었습니다!");
				} else if (kindCh.getSelectedItem().equals("마이너스계좌")) {
					manager.openAccount(new MinusAccount(numTF.getText(), nameTF.getText(), pw, restMoney, borrowMoney));
					listTA.setText("마이너스계좌가 생성되었습니다!");
				}
				else {
					listTA.setText("계좌종류를 선택해주세요...");
				}
			} else{
				listTA.setText("이미 존재하는 계좌번호입니다...");
			}
		}
	}

	// 계번호 중복확인
	private int checkAccount(){
		List<Account> list = manager.getAccounts();
		for (Account account : list) {
			if ( account.getAccountNum().equals(numTF.getText()) ) // 계좌 중복시
				return 1;
		}
		return 0;
	}
	
	// 계좌 삭제
	private void removeAccount(){
		if( manager.removeAccount(numTF.getText()) ){
			listTA.setText("해당 계좌가 삭제되었습니다.");
		} else {
			listTA.setText("삭제할 계좌가 존재하지 않습니다...");
		}
	}
		
	// 계좌 검색
	private void searchAccount() {
		List<Account> list = manager.searchAccount(nameTF.getText());
		if (list.size() != 0) { // 검색 계좌 존재
			kindAccount(list);
		} else {
			listTA.setText("검색한 예금주가 존재하지 않습니다.");
		}
	}
	
	// 계좌 조회
	private void selectAccount(){
		Account acc = manager.selectAccount(numTF.getText());
		if( acc != null ){ // 조회 계좌 존재
			template();
			if( acc instanceof MinusAccount ){
				MinusAccount minus_acc = (MinusAccount) acc;
				sb.append(minus_acc.toString());
			} else {
				sb.append(acc.toString());
			}
			sb.append(bar);
			listTA.setText(sb.toString());
		} else {
			listTA.setText("조회한 계좌가 존재하지 않습니다...");
		}
	}
	
	// 계좌 전체 조회
	private void printAccounts(){
		List<Account> list = manager.getAccounts();
		if (list.size() != 0) {
			kindAccount(list);
		} else {
			listTA.setText("계좌가 존재하지 않습니다.");
		}
	}
	
	// 계좌 종류별 출력
	private void kindAccount(List<Account> list){
		template();
		if (kindCh.getSelectedItem().equals("전체")) {			
			for (Account acc : list) {
				if (acc instanceof MinusAccount) {
					MinusAccount minus_acc = (MinusAccount) acc;
					sb.append(minus_acc.toString());
				} else
					sb.append(acc.toString());
			}
		} else if (kindCh.getSelectedItem().equals("마이너스계좌")) {	
			for (Account acc : list) {
				if (acc instanceof MinusAccount) {
					MinusAccount minus_acc = (MinusAccount) acc;
					sb.append(minus_acc.toString());
				} 
			}
		} else {
			for (Account acc : list) {
				if (!(acc instanceof MinusAccount)) {
					sb.append(acc.toString());
				} 
			}
		}
		sb.append(bar);
		listTA.setText(sb.toString());
	}

}