package kr.or.kosta.ams.view;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
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
	Label kindL, accountNumL, OwnerL, passwdL, depositL, lendMoneyL, kindListL, unitL;
	Button inquiryB, deleteB, searchB, enrollB, allInquiryB;
	Choice listC;
	TextField accountNumTF, OwnerTF, passwdTF, depositTF, lendMoneyTF;
	TextArea viewTA;
	
	AccountManager manager;
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;

	StringBuffer sb, sb2, sb3, sb4;
	String choice;
	String bar;
	
	public MainPanel(AccountManager manager){
		this.manager = manager;
		
		kindL = new Label("계좌종류");
		accountNumL = new Label("계좌번호");
		OwnerL = new Label("예금주명");
		passwdL = new Label("비밀번호");
		depositL = new Label("입금금액");
		lendMoneyL = new Label("대출금액");
		kindListL = new Label("계좌목록");
		unitL = new Label("(단위 : 원)");
		
		inquiryB = new Button("조 회");
		deleteB = new Button("삭 제");
		searchB = new Button("검 색");
		enrollB = new Button("신규등록");
		allInquiryB = new Button("전체조회");
		
		listC = new Choice();
		listC.add("전체");
		listC.add("입출금계좌");
		listC.add("마이너스계좌");
		
		accountNumTF = new TextField(20);
		OwnerTF = new TextField();
		passwdTF = new TextField();
		depositTF = new TextField();
		lendMoneyTF = new TextField();
		
		viewTA = new TextArea();
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		setComponents();
		component();
		eventRegist();
	}
	
	public void setComponents(){
		setLayout(gridBagLayout);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.insets = new Insets(3, 5, 3, 5);
		
		add(kindL,          0, 0, 1, 1, 0.0, 0.0);
		add(listC,          1, 0, 1, 1, 0.0, 0.0);
		add(accountNumL,    0, 1, 1, 1, 0.0, 0.0);
		add(accountNumTF,   1, 1, 1, 1, 1.0, 0.0);
		add(inquiryB,       2, 1, 1, 1, 0.0, 0.0);
		add(deleteB,        3, 1, 1, 1, 0.0, 0.0);
		add(new Label(" "), 4, 1, 1, 1, 0.1, 0.0);
		add(new Label(" "), 5, 1, 1, 1, 0.1, 0.0);
		add(OwnerL,         0, 2, 1, 1, 0.0, 0.0);
		add(OwnerTF,        1, 2, 1, 1, 1.0, 0.0);
		add(searchB,        2, 2, 1, 1, 0.0, 0.0);
		add(passwdL,        0, 3, 1, 1, 0.0, 0.0);
		add(passwdTF,       1, 3, 1, 1, 1.0, 0.0);
		add(depositL,       2, 3, 1, 1, 0.0, 0.0);
		add(depositTF,      3, 3, 2, 1, 1.0, 0.0);
		add(lendMoneyL,     0, 4, 1, 1, 0.0, 0.0);
		add(lendMoneyTF,    1, 4, 1, 1, 1.0, 0.0);
		add(enrollB,        2, 4, 1, 1, 0.0, 0.0);
		add(allInquiryB,    3, 4, 1, 1, 0.0, 0.0);
		add(kindListL,      0, 5, 1, 1, 0.0, 0.0);
		add(unitL,          4, 5, 1, 1, 0.0, 0.0);
		add(viewTA,         0, 6, 5, 1, 0.0, 0.0);
	}
	
	public void component(){
		manager.openAccount(new Account("입출금계좌", "1111-1111", "김동욱", 1234, 1000));
		manager.openAccount(new Account("입출금계좌", "1111-2222", "송동욱", 1234, 100000000));
		manager.openAccount(new MinusAccount("마이너스계좌", "2222-1111", "이동욱", 1234, 200000000, 3000000000L));
		manager.openAccount(new Account("입출금계좌", "1111-3333", "윤동욱", 1234, 300000000));
		manager.openAccount(new MinusAccount("마이너스계좌", "2222-2222", "김동욱", 1234, 300000000, 500000000));
		manager.openAccount(new Account("입출금계좌", "2222-3333", "박동욱", 1234, 300000000));
		choice = "전체";
		bar = ("-----------------------------------------------------------------------------------------------");
	}
	
	private void add(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty){
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;
		gridBagLayout.setConstraints(component, gridBagConstraints);
		add(component);
	}
	
	private void eventRegist(){
		allInquiryB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				printAll();
			}
		});
		
		inquiryB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				accountNumSearch();
			}
		});
		
		deleteB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteAccount();
			}
		});
		
		searchB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nameSearch();
			}
		});
		
		enrollB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				enroll();
			}
		});	
		
		listC.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					choice = listC.getSelectedItem();
				}
				
				if(choice == "마이너스계좌"){
					lendMoneyTF.setEnabled(true);
				}else{
					lendMoneyTF.setEnabled(false);
				}
			}
		});
		
		OwnerTF.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nameSearch();
			}
		});
		
	}
	
	/**
	 * 계좌개설
	 */
	public void enroll(){
		if(choice == "마이너스계좌"){
			String minusN1 = "마이너스계좌";
			String minusN2 = accountNumTF.getText();
			String minusN3 = OwnerTF.getText();
			String minusN4 = passwdTF.getText();
			String minusN5 = depositTF.getText();
			String minusN6 = lendMoneyTF.getText();
			manager.openAccount(new MinusAccount(minusN1, minusN2, minusN3, Integer.parseInt(minusN4), Integer.parseInt(minusN5), Integer.parseInt(minusN6)));
			viewTA.setText("마이너스계좌가 등록되었습니다");
		}else{
			String message1 = "입출금계좌";
			String message2 = accountNumTF.getText();
			String message3 = OwnerTF.getText();
			String message4 = passwdTF.getText();
			String message5 = depositTF.getText();
			
			manager.openAccount(new Account(message1 ,message2,message3,Integer.parseInt(message4),Integer.parseInt(message5)));
			viewTA.setText("입출금계좌가 등록되었습니다");
		}
			
	}
	
	/**
	 * 전체계좌 조회
	 */
	public void printAll(){
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();
		StringBuilder sb4 = new StringBuilder();
		List<Account> allList = manager.getAccounts();
			for(Account account : allList){
				if(account != null){
					if(account instanceof MinusAccount){
						MinusAccount minusAccount = (MinusAccount)account;
						sb4.append(minusAccount + "\n");
						sb3.append(minusAccount + "\n");		
					}else{
						sb4.append(account + "\n");
						sb2.append(account + "\n");
					}
				}
			}
			if(choice == "전체"){
				viewTA.setText(form(sb)+sb4+"");
			}else if(choice == "입출금계좌"){
				viewTA.setText(form(sb)+sb2+"");
			}else{
				viewTA.setText(form(sb)+sb3+"");
			}
	}
	
	/**
	 * 
	 */
	
	/**
	 * 계좌로 계좌검색
	 */
	public void accountNumSearch(){
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();
		StringBuilder sb4 = new StringBuilder();
		String message = accountNumTF.getText();
		Account getAccount = manager.getAccount(message);
		if(getAccount != null){
			sb4.append(getAccount.toString()+"\n");
			if(getAccount instanceof MinusAccount){
				MinusAccount minusAccount = (MinusAccount)getAccount;
				sb3.append(minusAccount.toString()+"\n");
			}else
				sb2.append(getAccount.toString()+"\n");
		}else{
			viewTA.setText("계좌가 존재하지 않습니다.");
		}
		if(choice == "전체"){
			viewTA.setText(form(sb)+sb4+"");
		}else if(choice == "입출금계좌"){
			viewTA.setText(form(sb)+sb2+"");
		}else{
			viewTA.setText(form(sb)+sb3+"");
		}
	}
	
	/**
	 * 예금주명으로 계좌검색 
	 */
	public void nameSearch(){
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();
		StringBuilder sb4 = new StringBuilder();
		StringBuilder sb5 = new StringBuilder();
		String message = OwnerTF.getText();
		List<Account> searchList = manager.searchAccount(message);
		if(!searchList.isEmpty()){
			for(Account account : searchList){
				if(account != null){
					if(account instanceof MinusAccount){
						MinusAccount minusAccount = (MinusAccount)account;
						sb5.append(minusAccount + "\n");
						sb3.append(minusAccount + "\n");
					}else{
						sb5.append(account + "\n");
						sb2.append(account + "\n");
					}
				}
			}
		}else{
			sb4.append("검색된 계좌가 없습니다.");
			viewTA.setText(sb2 + "");
		}
		
		if(choice == "전체"){
			viewTA.setText(form(sb)+sb5+"");
		}else if(choice == "입출금계좌"){
			viewTA.setText(form(sb)+sb2+"");
		}else{
			viewTA.setText(form(sb)+sb3+"");
		}
	}
	/**
	 * 계좌삭제
	 */
	public void deleteAccount(){
		sb = new StringBuffer();
		sb2 = new StringBuffer();
		String message = accountNumTF.getText();
		boolean remove = manager.removeAccount(message);
		if(remove){
			sb.append("계좌를 삭제하였습니다.");
			viewTA.setText(sb + "");
		}else{
			sb2.append("삭제하고자 하는 계좌가 존재하지 않습니다.");
			viewTA.setText(sb2 + "");
		}
	}
	
	/**
	 * 양식
	 */
	public String form(StringBuilder sb){
		sb.append(bar+"\n");
		sb.append("계좌종류\t계좌번호\t예금주명\t현재잔액\t대출금액\n");
		sb.append(bar+"\n");
		sb.append(bar+"\n");
		return sb.toString();
	}
}