package kr.or.kosta.ams.view;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import kr.or.kosta.ams.model.Account;
import kr.or.kosta.ams.model.AccountManager;
import kr.or.kosta.ams.model.MinusAccount;

public class MainFrame extends Frame {
	AccountManager accountManager;
	MainPanel panel;
	
	public MainFrame(){
		this("KOSTA 은행 계좌 관리 시스템 - 메인화면");
	}
	
	public MainFrame(String title){
		super(title);
		accountManager = new AccountManager();
		accountManager.openAccount(new Account("1111-1111", "홍길동1", 1234, 100));
		accountManager.openAccount(new Account("2222-1111", "홍길동2", 1234, 25000));
		accountManager.openAccount(new Account("3333-1111", "홍길동3", 1234, 38000));
		accountManager.openAccount(new MinusAccount("4444-1111", "홍길동3", 1234, 4000, 1000L));
		accountManager.openAccount(new MinusAccount("5555-1111", "홍길동4", 1234, 13000, 4500L));
		panel = new MainPanel();
		
	}
	
	public void setComponents(){
		add(panel);//메인 프레임에 패널 부착.
	}
//*************************************************************************************************************//
                              	/*이벤트 처리시 필요한 기능 메소드*/
//*************************************************************************************************************//
	//텍스트 필트 클리어.
	public void clear(){
		panel.textField_accountNum.setText("");
		panel.textField_borrow.setText("");
		panel.textField_deposit.setText("");
		panel.textField_name.setText("");
		panel.textField_passwd.setText("");
	}
	//출력 구분자.
	public void topTitle(){
		panel.textArea_listView.setText("");
		panel.textArea_listView.append("--------------------------------------------------------------------------------\n");
		panel.textArea_listView.append("계좌종류" + "\t" + "계좌번호" + "\t" + "예금주명" +"\t" + "현재잔액" + "\t" + "대출금액\n");
		panel.textArea_listView.append("================================================================================\n");

	}
	
	public void endTitle(){
		panel.textArea_listView.append("--------------------------------------------------------------------------------\n");
	}
	
//	계좌 생성 메소드.
//	매개변수로 받아온 계좌 타입에 따라 일반 계좌와 마이너스 계좌를 구분하여 생성한다.
	public boolean createAccount(String accountType, String accountNum, String name, int passwd, long deposit){

		if(accountType.equals("generalAccount")){
			if(accountManager.openAccount(new Account(accountNum, name, passwd, deposit))){
				return true;
			}else{
				return false;
			}
		}else if(accountType.equals("minusAccount")){
			if(panel.textField_borrow.getText().isEmpty()){
				return false;
			}else{
				long borrow = Long.parseLong(panel.textField_borrow.getText());//마이너스 계좌의 속성 추사 삽입.
				if(accountManager.openAccount(new MinusAccount(accountNum, name, passwd, deposit, borrow))){
					return true;
				}else{
					return false;
				}
			}
		}else{ }
		
		return false;
	}
	
	//전체 계좌 출력.
	public void accountPrint(){
		List<Account> list = accountManager.getAccounts();
		
			String item = panel.choice_account.getSelectedItem();
			if(item.equals("전체")){			
				for(Account account : list){
					panel.textArea_listView.append(getAccountType(account)+account.toString() + "\n");
				}
			}else if(item.equals("입출금계좌")){
				for(Account account : list){
					if(account instanceof MinusAccount){
					}else{
						panel.textArea_listView.append(getAccountType(account)+account.toString() + "\n");
					}
				}
			}else if(item.equals("마이너스계좌")){
				for(Account account : list){
					if(account instanceof MinusAccount){
						panel.textArea_listView.append(getAccountType(account)+account.toString() + "\n");
					}else{}
				}
				
			}else{}
	}
	
	//초이스 상태 변경에 따라 대출금액 비활 성화.
	public void textFieldState(String item){
		if(item.equals("전체") || item.equals("입출금계좌")){
			panel.textField_borrow.disable();
		}else if(item.equals("마이너스계좌")){
			panel.textField_borrow.enable();
		}
	}
	
	//계좌의 타입을 구분.
	public String getAccountType(Account account){
		if(account instanceof MinusAccount){
			return "마이너스";
		}else{
			return "입출금\t";
		}
	}
	
	//프로그램 종료.
	public void exit(){
		setVisible(false);
		dispose();
		System.exit(0);;
	}
//**************************************** End of Function Method *********************************************//
	
	
//*************************************************************************************************************//
  	                                      /*버튼별 이벤트 수행 메소드*/
//*************************************************************************************************************//
	public void eventRegister(){
//		계좌 번호로 계좌 조회 - btn_check
		panel.btn_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.textArea_listView.setText("");
				String accountNum = panel.textField_accountNum.getText();
//				해당 필드가 비어있는지 검사.
				if(accountNum.isEmpty()){
					panel.textArea_listView.setText("[계좌 번호를 입력해 주세요.]");
				}else{
					//텍스트 필드의 계좌 번호를 getAccount메소드를 이용하여 해당 계좌 번호의 정보를 account로 받아온다.
					Account account = accountManager.getAccount(accountNum);
//					정확한 계좌 값이 들어 왔는지 검사.
					if(account == null){
						panel.textArea_listView.setText("[해당 계좌 번호가 없습니다.]");
					}else{
						panel.textArea_listView.setText("[계좌 번호로 조회]");
						topTitle();
						panel.textArea_listView.append(getAccountType(account) + account.toString() + "\n");//textArea에 출력.
						endTitle();
					}
				}
				clear();//텍스트 필드 초기화.
			}
		});
		
		//삭제 - btn_delete (계좌 번호로 삭제.)
		panel.btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.textArea_listView.setText("");
				String accountNum = panel.textField_accountNum.getText();
				if(accountNum.isEmpty()){
					panel.textArea_listView.setText("[계좌 번호를 입력해 주세요.]");
				}else if(accountManager.removeAccount(accountNum)){
					panel.textArea_listView.append("[삭제 성공]\n\n");
					topTitle();
					accountPrint();
					endTitle();
				}else{
					panel.textArea_listView.setText("[해당 계좌 번호가 존재하지 않습니다.]");
				}
				clear();
			}
		});
		
		//검색 - btn_search 예금주 명으로 검색.
		panel.btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.textArea_listView.setText("");
				String name = panel.textField_name.getText();
				if(name.isEmpty()){
					panel.textArea_listView.setText("[이름을 입력해 주세요.]");
				}else{
					List<Account> list = accountManager.searchAccount(name);
					//검색 결과가 없을 경우 예외 처리.
					if(list.isEmpty()){
						panel.textArea_listView.setText("[해당 사용자가 존재하지 않습니다.]");
					}else{
						panel.textArea_listView.append("[사용자 이름으로 계좌 검색]\n\n");
						topTitle();
						for(Account account : list){
							panel.textArea_listView.append(getAccountType(account) + account.toString() + "\n");
						}
						endTitle();
					}
				}
			clear();
			}
		});
		
		//계좌 신규등록 - btn_createAccount
		panel.btn_createAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String accountNum = panel.textField_accountNum.getText();
				String name = panel.textField_name.getText();
				String passwd = panel.textField_passwd.getText();
				String deposit = panel.textField_deposit.getText();
				//선택된 계좌 항목을 구분.
				String item = panel.choice_account.getSelectedItem();
				
				//계좌 정보 입력 값이 비었는지 확인.
				if(name.isEmpty()||accountNum.isEmpty()||passwd.isEmpty()||deposit.isEmpty()){
					panel.textArea_listView.setText("[계좌 정보를 모두 입력해 주세요.]");
				}else{
					panel.textArea_listView.setText("");
					if(item.equals("입출금계좌")){
						if(createAccount("generalAccount", accountNum, name, Integer.parseInt(passwd),Integer.parseInt(deposit))){
							panel.textArea_listView.append("[" + name + " 님의 계좌가 생성되었습니다.]\n\n");
							topTitle();
							accountPrint();
							endTitle();
						}else{
							panel.textArea_listView.setText("[계좌 생성에 실패하였습니다.]\n");
						}

					}else if(item.equals("마이너스계좌")){
						if(createAccount("minusAccount", accountNum, name, Integer.parseInt(passwd),Integer.parseInt(deposit))){
							panel.textArea_listView.append("[" + name + " 님의 계좌가 생성되었습니다.]\n\n");
							topTitle();
							accountPrint();
							endTitle();
						}else{
							panel.textArea_listView.setText("[대출금을 입력해 주세요.]\n");
						}

					}else if(item.equals("전체")){
						panel.textArea_listView.setText("[계좌 분류를 선택해 주세요.]");
					}
				}
				clear();
			}
		});
		
		//btn_searchAll (전체조회)
		panel.btn_searchAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.textArea_listView.setText("");
				if(accountManager.getCount() == 0){
					panel.textArea_listView.setText("[계좌가 존재하지 않습니다.]");
				}else{
					panel.textArea_listView.append("[계좌 목록 조회]\n");
					topTitle();
					accountPrint();
					endTitle();
				}
				clear();
			}
		});
		
		//텍스트필드 비활성화.
		panel.choice_account.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String item = panel.choice_account.getSelectedItem();
				 textFieldState(item);
			}
		});
		
		//화면 종료.
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				exit();
			}
		});//end of addWindowListener()
		
	}//end of eventRegister()
//*************************************************************************************************************//	

}//end of class.
