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

import javax.swing.JOptionPane;

import kr.or.kosta.ams.model.Account;
import kr.or.kosta.ams.model.AccountManager;
import kr.or.kosta.ams.model.MinusAccount;

/**
 * 메인프레임에 부착할 Main패널을 만듦 Panel의 레이아웃은 GridBagLayout으로 설정한다. 해당 패널에 들어가는 컴포넌트를
 * 이곳에서 모두 선언(및 생성) 한다.
 * 
 * @author AS
 */
public class MainPanel extends Panel {
	Label kindAccount, accountNum, accountOwner, password, depositMoney, borrowMoney, accountList, accountUnit;
	Choice accountChoice;
	TextField accountNumTF, accountOwnerTF, passwordTF, depositMoneyTF, borrowMoneyTF;
	Button inquiryBTN, deleteBTN, searchBTN, newBTN, allBTN;
	TextArea contentTA;
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	AccountManager manager;

	public MainPanel() {
		/** 선언한 컴포넌트 생성 */
		kindAccount = new Label("계좌종류");
		accountNum = new Label("계좌번호");
		accountOwner = new Label("예금주명");
		password = new Label("비밀번호");
		depositMoney = new Label("입금금액");
		borrowMoney = new Label("대출금액");
		accountList = new Label("계좌목록");
		accountUnit = new Label("(단위:원)");
		accountChoice = new Choice();
		accountNumTF = new TextField();
		accountOwnerTF = new TextField();
		passwordTF = new TextField();
		depositMoneyTF = new TextField();
		borrowMoneyTF = new TextField();
		borrowMoneyTF.setEnabled(false);  // Choice의 초기값이 "전체"이므로 초기값을 false로 주었다.
		inquiryBTN = new Button("조 회");
		deleteBTN = new Button("삭 제");
		searchBTN = new Button("검 색");
		newBTN = new Button("신규등록");
		allBTN = new Button("전체조회");
		contentTA = new TextArea();
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		accountChoice.setSize(1000, 10);
		manager = new AccountManager();
		setChoice();
		setComponent();
	}
	
	/** 초이스의 아이템을 추가하는 메소드*/
	public void setChoice() {
		accountChoice.add("전체");
		accountChoice.add("입출금계좌");
		accountChoice.add("마이너스계좌");
	}
	
	/** 컴포넌트들의 레이아웃, 위치등을 결정하는 메소드*/
	public void setComponent() {
		setLayout(gridBagLayout); // 패널의 레이아웃을 GridBagLayout으로 설정
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.insets = new Insets(3, 5, 3, 5); // 컴포넌트들 마다의 간격 설정(위, 왼쪽, 아래, 오른쪽)
		
		addComponent(kindAccount, 0, 0, 1, 1, 0.0, 0.0);
		addComponent(accountChoice, 1, 0, 1, 1, 0.3, 0.0);
		addComponent(accountNum, 0, 1, 1, 1, 0.0, 0.0);
		addComponent(accountNumTF, 1, 1, 3, 1, 1.0, 0.0);
		addComponent(inquiryBTN, 4, 1, 1, 1, 0.0, 0.0);
		addComponent(deleteBTN, 5, 1, 1, 1, 0.0, 0.0);
		addComponent(accountOwner, 0, 2, 1, 1, 0.0, 0.0);
		addComponent(accountOwnerTF, 1, 2, 3, 1, 1.0, 0.0);
		addComponent(searchBTN, 4, 2, 1, 1, 0.0, 0.0);
		addComponent(password, 0, 3, 1, 1, 0.0, 0.0);
		addComponent(passwordTF, 1, 3, 3, 1, 0.0, 0.0);
		addComponent(new Label(""),3, 3, 1, 1, 0.0,0.0);
		addComponent(depositMoney, 4, 3, 1, 1, 0.0, 0.0);
		addComponent(depositMoneyTF, 5, 3, 4, 1, 1.0, 0.0);
		addComponent(borrowMoney, 0, 4, 1, 1, 0.0, 0.0);
		addComponent(borrowMoneyTF, 1, 4, 3, 1, 1.0, 0.0);
		addComponent(newBTN, 4, 4, 2, 1, 0.0, 0.0);
		addComponent(allBTN, 6, 4, 2, 1, 0.0, 0.0);
		addComponent(new Label(" "), 4, 4, 1, 1, 0.1, 0.0);
		addComponent(new Label(" "), 5, 4, 1, 1, 0.1, 0.0);
		addComponent(new Label(" "), 6, 4, 1, 1, 0.1, 0.0);
		addComponent(accountList, 0, 5, 1, 1, 0.0, 0.0);
		addComponent(accountUnit, 7, 5, 1, 1, 0.0, 0.0);
		addComponent(contentTA, 0, 6, 8, 1, 0.0, 1.0);
		/** 
		 * 원하는 위치에 원하는 컴포넌트를 등록하기 위해서
		 * 공백 레이블을 사용함.
		 */
	}
	
	/** GridBagConstraints의 속성들을 계속 사용하기 때문에
	 *  재사용성을 위해서 메소드로 정함
	 *  패널에 컴보넌트를 부착함
	 */
	private void addComponent(Component com, int gridx, int gridy, int gridWidth, int gridHeight, double weightx,
			double weighty) {
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth = gridWidth;
		gridBagConstraints.gridheight = gridHeight;
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;
		// GridBagLayout의 설정을 현재 Constraints(위에서 설정)한 값으로 적용한다
		gridBagLayout.setConstraints(com, gridBagConstraints);
		add(com); // 컴포넌트를 Panel에 부착한다.
	}

	/** 발생하는 이벤트를 등록한 메소드 
	 *  내부의 이벤트들은 모두 "이름없는 지역 내부클래스"를 이용하였다 
	 *  상세한 기능들은 메소드로 따로 분리하고 메소드만 호출하도록 했다.
	 */
	public void setEvent() {
		/** Choice의 속성이 바뀔 때 실행됨*/
		accountChoice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				choiceChange();
			}
		});
		/** 전체조회 버튼 클릭*/
		allBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				allSearch();
			}
		});
		/** 신규등록 버튼 클릭*/
		newBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createAccount();
			}
		});
		/** 조회 버튼 클릭*/
		inquiryBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inquiry();
			}
		});
		/** 삭제 버튼 클릭*/
		deleteBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteAccount();
			}
		});
		/** 검색 버튼 클릭*/
		searchBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searhOwner();
			}
		});
	}
	
	/**
	 * 발생하는 이벤트에 마다 따로 메소드로 정의하였다
	 */
	
	/** 전체 조회 메소드 */
	public void allSearch(){
		List<Account> list = manager.returnAccount();
		/** 등록된 계좌가 하나도 없는 경우 실행하지 않고 경고문을 띄운다 */
		if(list.size() == 0){
			JOptionPane.showMessageDialog(null, "계좌가 하나도 존재하지 않습니다.");
			return;
		}
		contentTA.setText(" ");
		contentTA.setText("------------------------------------------------------------------------\n");
		contentTA.append("계좌종류\t계좌번호\t예금주명\t현재잔액\t대출금액\n");
		contentTA.append("========================================================================\n");
		for (Account account2 : list) {
				contentTA.append(account2.toString() + "\n");
		}
		/**
		 * AccountManager에서 등록된 모든 계좌를 List로 받아온다
		 * 확장 for문을 이용하여 해당 계좌를 루프한다.
		 */
	}
	/** 콤보박스의 아이템이 바뀔 때 실행되는 메소드*/ 
	public void choiceChange(){
		if (accountChoice.getSelectedItem().equals("마이너스계좌")) {
			borrowMoneyTF.setEnabled(true);
		} else {
			borrowMoneyTF.setEnabled(false);
		}
	}
	/** 신규계좌 생성 메소드 */
	public void createAccount(){
		/** 텍스트필드의 문자열을 받아올 변수를 생성하고 해당 문자열을 할당받는다*/
		String accountNum = accountNumTF.getText();
		String accountOwner = accountOwnerTF.getText();
		String password = passwordTF.getText();
		String depositMoney = depositMoneyTF.getText();
		
		/** 텍스트필드의 비밀번호, 입금액, 대출액은 int형(숫자)여야 한다.
		 *  하지만 텍스트필드의 내용은 String이다. 이것을 변환받아 저장 할 변수를 선언했다.  
		 */
		int passW = 0;
		long money = 0L;
		long borrowMoney = 0L;
		
		/**
		 * 등록할려는 신규계좌번호가 이미 있는지 알아보기 위해
		 * List gb에 저장되어진 계좌목록들을 받아온다
		 * for문을 돌면서 위에 선언 gb내의 accountNum과 위에 선언된 accountNum을 비교한다
		 * 비교하여 계좌가 존재하면 경고 메세지를 띄우고 리턴으로 빠져나온다.
		 * 같은 방식으로 TextField들의 내용이 있는지 없는지를 검사하고
		 * 내용이 없으면 경고문을 띄우고 리턴한다.
		 */
		List<Account> gb = manager.returnAccount();
		for (Account account : gb) {
			if(account.getAccountNum().equals(accountNum)){
				JOptionPane.showMessageDialog(null, "계좌번호가 이미 존재합니다.");
				return;
			}else if(accountNum.equals("")){
				JOptionPane.showMessageDialog(null, "계좌번호를 입력해주세요.");
				return;
			}else if(accountOwner.equals("")){
				JOptionPane.showMessageDialog(null, "이름을 입력해주세요.");
				return;
			}else if(password.equals("")){
				JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요");
				return;
			}else if(depositMoney.equals("")){
				JOptionPane.showMessageDialog(null, "입금액을 입력해주세요.");
				return;
			}
		}
		
		/**
		 * 생성되는 계좌가 일반계좌인지 마이너스 계좌인지 알아내기 위한
		 * 조건문이다. 해당 조건문에서는 Choice안에 있는 문자열을 통해서
		 * 일반계좌인지 마이너스계좌인지 알아낸다.
		 * 계좌의 종류가 전체인 경우 경고문을 띄운다
		 * 계좌의 종류가 선택되어지면 비밀번호와 입금액 대출액의 값들이 String이기 때문에
		 * int, long형으로 각각 바꿔주어야한다.
		 * 바꾸는 과정에서 Exception이 일어날 수 있으므로 try ~ catch문을 통하여
		 * 예외가 일어날 가능성이 있는 코드를 넣는다
		 * 예외가 발생할 경우 경고메세지를 출력한다.
		 */
		if (accountChoice.getSelectedItem().equals("입출금계좌")) {
			try {
				passW = Integer.parseInt(passwordTF.getText());
				money = Long.parseLong(depositMoneyTF.getText());
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "입력이 잘못 되었습니다.");
				return;
			}
			manager.openAccount(new Account(accountNum, accountOwner, passW, money));
		} else if (accountChoice.getSelectedItem().equals("마이너스계좌")) {
			try {
				passW = Integer.parseInt(passwordTF.getText());
				money = Long.parseLong(depositMoneyTF.getText());
				borrowMoney = Long.parseLong(borrowMoneyTF.getText());
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "대출금을 입력해주세요");
				return;
			}
			manager.openAccount(new MinusAccount(accountNum, accountOwner, passW, money, borrowMoney));
		} else {
			JOptionPane.showMessageDialog(null, "계좌 종류를 선택해주세요");
		}
	}
	/** 계좌번호로 계좌를 조회하는 메소드 */
	public void inquiry(){
		/**
		 * accountNum의 텍스트필드의 스트링을 매개변수로해서
		 * getAccount매소드에 넣는다
		 * getAccount매소드에서 루프를 돌면서
		 * 텍스트필드의 문자열과 계좌내의 문자열이 같은지 조사한다
		 * 같은 문자열이 있는 경우 해당 계좌를 반환한다(searchAccount에 넣는다)
		 */
		Account searchAccount = manager.getAccount(accountNumTF.getText());
		if (searchAccount != null) {
			contentTA.setText(" ");
			contentTA.setText("------------------------------------------------------------------------\n");
			contentTA.append("계좌종류\t계좌번호\t예금주명\t현재잔액\t대출금액\n");
			contentTA.append("========================================================================\n");
			contentTA.append(searchAccount.toString());
		} else {
			JOptionPane.showMessageDialog(null, "해당 계좌가 존재하지 않습니다.");
		}
	}
	/** 계좌 삭제 메소드*/
	public void deleteAccount(){
		boolean result = manager.removeAccount(accountNumTF.getText());
		if (result) {
			JOptionPane.showMessageDialog(null, "계좌가 정상적으로 삭제되었습니다");
		}else{
			JOptionPane.showMessageDialog(null, "계좌번호가 존재하지 않습니다.");
		}
	}
	/** 예금주명으로 계좌 검색 메소드*/
	public void searhOwner(){
		List<Account> gb = manager.searchAccount(accountOwnerTF.getText());
 
		if (gb.size() == 0) {
			JOptionPane.showMessageDialog(null, "이름을 찾을 수 없습니다.");
		} else {
			contentTA.setText(" ");
			contentTA.setText("------------------------------------------------------------------------\n");
			contentTA.append("계좌종류\t계좌번호\t예금주명\t현재잔액\t대출금액\n");
			contentTA.append("========================================================================\n");
			for (Account searchResult : gb) {
				contentTA.append(searchResult.toString()+"\n");
			}
		}
	}
}