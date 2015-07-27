package kr.or.kosta.ams.view;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.util.List;

import kr.or.kosta.ams.model.MinusAccount;
import kr.or.kosta.ams.model.Account;
import kr.or.kosta.ams.model.AccountManager;

public class MainPanel extends Panel {
	Label kindL, numL, nameL, secretNumL, receiveMoneyL, loanedMoneyL, listL, unitL;
	Button findB, deleteB, searchB, registB, allfindB;
	Choice choice;
	TextField numTF, nameTF, secretNumTF, receiveMoneyTF, loanedMoneyTF;
	TextArea listTA;
	
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	AccountManager accountManager;
	MinusAccount minusAccount;
	Account account;
	
	public MainPanel(){
		kindL = new Label("계좌종류");
		choice = new Choice();
		choice.add("전체");
		choice.add("입출금계좌");
		choice.add("마이너스계좌");
		
		numL = new Label("계좌번호");
		numTF = new TextField();
		findB = new Button("조회");
		deleteB = new Button("삭제");
		
		nameL = new Label("예금주명");
		nameTF = new TextField();
		searchB = new Button("검색");
		
		secretNumL = new Label("비밀번호");
		secretNumTF = new TextField();
		
		receiveMoneyL = new Label("입금금액");
		receiveMoneyTF = new TextField();
		
		loanedMoneyL = new Label("대출금액");
		loanedMoneyTF = new TextField();
		
		registB = new Button("신규등록");
		allfindB = new Button("전체조회");
		
		listL = new Label("계좌목록");
		unitL = new Label("(단위 : 원)");
		listTA = new TextArea();
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		accountManager = new AccountManager();
		minusAccount = new MinusAccount();
		account = new Account();
		
		setComponents();
		setRegist();
		test();
	}
	
	public void setComponents(){
		setLayout(gridBagLayout);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.insets = new Insets(3, 5, 3, 5);
		
		add(kindL, 0, 0, 1, 1, 0.0, 0.0);
		add(choice, 1, 0, 2, 1, 0.0, 0.0);
		add(new Label(" "),2, 0, 1, 1, 0.1, 0.0);
		add(numL, 0, 1, 1, 1, 0.0, 0.0);
		add(numTF, 1, 1, 2, 1, 1.0, 0.0);
		add(findB, 3, 1, 1, 1, 0.0, 0.0);
		add(deleteB, 4, 1, 1, 1, 0.0, 0.0);
		add(new Label(" "),5, 1, 1, 1, 0.1, 0.0);
		add(nameL, 0, 2, 1, 1, 0.0, 0.0);
		add(nameTF, 1, 2, 2, 1, 1.0, 0.0);
		add(searchB, 3, 2, 1, 1, 0.0, 0.0);
		add(new Label(" "), 4, 2, 1, 1, 0.1, 0.0);
		add(secretNumL, 0, 3, 1, 1, 0.0, 0.0);
		add(secretNumTF, 1, 3, 2, 1, 1.0, 0.0);
		add(receiveMoneyL, 3, 3, 1, 1, 0.0, 0.0);
		add(receiveMoneyTF, 4, 3, 3, 1, 1.0, 0.0);
		add(new Label(" "), 6, 3, 1, 1, 0.1, 0.0);
		add(loanedMoneyL, 0, 4, 1, 1, 0.0, 0.0);
		add(loanedMoneyTF, 1, 4, 2, 1, 1.0, 0.0);
		add(registB, 3, 4, 1, 1, 0.0, 0.0);
		add(allfindB, 4, 4, 1, 1, 0.0, 0.0);
		add(new Label(" "), 5, 4, 1, 1, 0.1, 0.0);
		add(listL, 0, 5, 1, 1, 0.0, 0.0);
		add(unitL, 6, 5, 1, 1, 0.0, 0.0);
		add(listTA, 0, 6, 7, 5, 1.0, 1.0);
	
	}
	
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
	
	public void select(){
		if(choice.getSelectedItem() == "입출금계좌"){
			loanedMoneyTF.setEnabled(false);
		}else{
			loanedMoneyTF.setEnabled(true);
		}
	}
	
	public void find(){
		Account ga = accountManager.getAccount(numTF.getText());
		if (ga != null)
			//System.out.println(ga);
		listTA.append(ga.toString()+"\n");
		else
			//System.out.println("계좌번호로 계좌조회 실패");
			listTA.append("계좌번호로 계좌조회 실패 \n");

	}
	
	public void delete(){
		if(accountManager.removeAccount(numTF.getText())){
			listTA.append("계좌삭제 성공 \n");
			
		}else{
			listTA.append("없는 계좌번호로 계좌삭제 실패 \n");
		}
	}
	
	public void search(){
		List<Account> arraylist= accountManager.searchAccount(nameTF.getText());
		if(arraylist.isEmpty()){
			listTA.append("예금주로 계좌조회 실패 \n");
			
		}else{
			for (Object object : arraylist) {
				if (object instanceof MinusAccount){   //들어오는 account가 마이너스계좌면 다운캐스팅해서 
					MinusAccount minusAccount=(MinusAccount)object;   //다운캐스팅
					listTA.append(minusAccount+"\t 대출금액: "+minusAccount.getBorrowMoney() + "\n");
				}else
					listTA.append(object.toString() + "\n");
			}
		}
	}
	
	public void regist(){
		String accountNum = numTF.getText();
		String accountOwner = nameTF.getText();
		int password = 0;
		long restmoney = 0L;
		long borrowmoney = 0L;
		

		if(choice.getSelectedItem() == "입출금계좌"){
			password = Integer.parseInt(secretNumTF.getText());
			restmoney = Long.parseLong(receiveMoneyTF.getText());
			accountManager.openAccount(new Account(accountNum, accountOwner, password, restmoney));
			listTA.append("-----------------------------------------------------------------------\n");
			listTA.append("계좌종류\t" + "계좌번호 \t" + "예금주명 \t" + "현재잔액 \t" + "대출잔액\n");
			listTA.append("=======================================================================\n");
			listTA.append("입출금\t" + numTF.getText() + "\t" + nameTF.getText()+ "\t" + receiveMoneyTF.getText()+ "\n");
			listTA.append("-----------------------------------------------------------------------\n");
			listTA.append("계좌등록 성공\n");
			
		}else if(choice.getSelectedItem() == "마이너스계좌"){
			borrowmoney = Long.parseLong(loanedMoneyTF.getText());
			accountManager.openAccount(new Account(accountNum, accountOwner, password, borrowmoney));
			listTA.append("-----------------------------------------------------------------------\n");
			listTA.append("계좌종류\t" + "계좌번호 \t" + "예금주명 \t" + "현재잔액 \t" + "대출잔액\n");
			listTA.append("=======================================================================\n");
			listTA.append("마이너스\t" + numTF.getText() + "\t" + nameTF.getText()+ "\t" + receiveMoneyTF.getText()+ "\t" +loanedMoneyTF.getText()+ "\n");
			listTA.append("-----------------------------------------------------------------------\n");
			listTA.append("계좌등록 성공\n");

		}
		
		
	}
	
	public void allfind(){
		List<Account> list = accountManager.getAccounts();
		listTA.append("-----------------------------------------------------------------------\n");
		listTA.append("계좌종류\t" + "계좌번호 \t" + "예금주명 \t" + "현재잔액 \t" + "대출잔액\n");
		listTA.append("=======================================================================\n");
		for (Account account : list){
			
			listTA.append(account.toString()+"\n");
		}
		listTA.append("-----------------------------------------------------------------------\n");
	}
	
	
	public void setRegist(){
		
		//셀렉트 기능
		choice.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				select();
			}
		});
		
		registB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				regist();
				
			}
		});
				
		
		allfindB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				allfind();
				
			}
		});
		
		findB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				find();
			}
		});
		
		deleteB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		
		searchB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
			

		
		
	}
	public void test(){
		accountManager.openAccount(new Account("1111-2222", "김기정", 1234, 1000));
		accountManager.openAccount(new Account("1111-3333", "박래빈", 1234, 100000000));
		accountManager.openAccount(new MinusAccount("2222-4444", "김준기", 1234, 200000000, 3000000000L));
		accountManager.openAccount(new Account("1111-5555", "송지현", 1234, 300000000));
		accountManager.openAccount(new MinusAccount("2222-6666", "김대출", 1234, 300000000, 500000000));
	}
	public static void main(String[] args) {
		Frame frame = new Frame();
		MainPanel mp = new MainPanel();
		frame.add(mp);
		frame.setSize(500, 400);
		frame.setVisible(true);		

	}

}
