package kr.or.kosta.ams.view;

import java.awt.Button;
import java.awt.Choice;
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

public class MainPanel extends Panel {
	//Layout 설정.
	GridBagLayout grid = new GridBagLayout();
	GridBagConstraints gridConstraints = new GridBagConstraints();
	
	//component.
	//라벨.
	Label label_accountType;
	Label label_accountNum;
	Label label_name;
	Label label_passwd;
	Label label_deposit;
	Label label_borrow;
	Label label_accountList;
	Label label_measure;
	
	Label label_empty;
	Label label_empty2;
	Label label_empty3;
	
	//텍스트 필드.
	TextField textField_accountNum;
	TextField textField_name;
	TextField textField_passwd;
	TextField textField_deposit;
	TextField textField_borrow;
	//버튼.
	Button btn_check;
	Button btn_delete;
	Button btn_search;
	Button btn_createAccount;
	Button btn_searchAll;
	//텍스트 area.
	TextArea textArea_listView;
	//선택창.
	Choice choice_account;
	
	//생성자.
	public MainPanel(){
//===========================  컴포넌트 생성 ========================//
		label_accountType = new Label("계좌종류");
		label_accountNum = new Label("계좌번호");
		label_name = new Label("예금주명");
		label_passwd = new Label("비밀번호");
		label_deposit = new Label("입금 금액");
		label_borrow = new Label("대출금액");
		label_accountList = new Label("계좌목록");
		label_measure = new Label("(단위 : 원)",2);
		label_empty = new Label(" ");
		label_empty2 = new Label(" ");
		label_empty3 = new Label(" ");
		
		//텍스트 필드.
		textField_accountNum = new TextField(15);
		textField_name = new TextField(15);
		textField_passwd = new TextField(15);
		textField_deposit = new TextField(15);
		textField_borrow = new TextField(15);
		
		//버튼.
		btn_check = new Button("계좌 조회");
		btn_delete = new Button("계좌번호로 삭제");
		btn_search = new Button("이름으로 검색");
		btn_createAccount = new Button("신규 계좌 등록");
		btn_searchAll = new Button("전체조회");
		//텍스트 area.
		textArea_listView = new TextArea();
		//선택창.
		choice_account = new Choice();
		choice_account.add("전체");
		choice_account.add("입출금계좌");
		choice_account.add("마이너스계좌");
//====================================================================//
		setComponents();
	}
	
	public void setComponents(){
		//패널 레이아웃 gridBaglayout로 설정.
		setLayout(grid);
		gridConstraints.fill = gridConstraints.BOTH;
		gridConstraints.insets = new Insets(3,5,3,5);
		textField_borrow.disable();//대출금 입력란 디폴트 세팅.
		textField_passwd.setEchoChar('*');//비빌번호 숨김.

//======================== GridBagLayout 설정 =======================//
		addGrid(label_accountType, 0, 0, 1, 1, 0.0, 0.0);
		addGrid(label_accountNum,  0, 1, 1, 1, 0.0, 0.0);
		addGrid(label_name,        0, 2, 1, 1, 0.0, 0.0);
		addGrid(label_passwd,      0, 3, 1, 1, 0.0, 0.0);
		addGrid(label_borrow,      0, 4, 1, 1, 0.0, 0.0);
		addGrid(label_accountList, 0, 5, 1, 1, 0.0, 0.0);
		addGrid(label_deposit,     2, 3, 1, 1, 0.0, 0.0);
		addGrid(label_measure,     5, 5, 1, 1, 1.0, 0.0);	
		
		addGrid(choice_account,        1, 0, 1, 1, 0.0, 0.0);
		
		addGrid(textField_accountNum,  1, 1, 1, 1, 0.0, 0.0);
		addGrid(textField_name,        1, 2, 1, 1, 0.0, 0.0);
		addGrid(textField_passwd,      1, 3, 1, 1, 0.0, 0.0);
		addGrid(textField_borrow,      1, 4, 1, 1, 0.0, 0.0);
		addGrid(textField_deposit,     3, 3, 1, 2, 0.0, 0.0);
		
		addGrid(btn_check,         2, 1, 1, 1, 0.0, 0.0);
		addGrid(btn_delete,        3, 1, 1, 1, 0.0, 0.0);
		addGrid(btn_search,        2, 2, 1, 1, 0.0, 0.0);
		addGrid(btn_createAccount, 2, 4, 1, 1, 0.0, 0.0);
		addGrid(btn_searchAll,     3, 4, 1, 1, 0.0, 0.0);
		
		addGrid(textArea_listView, 0, 6, 1, 6, 1.0, 1.0);
		
		addGrid(label_empty2,     5, 1, 1, 1, 0.0, 0.0);
		addGrid(label_empty,      4, 1, 1, 1, 0.0, 0.0);
		addGrid(label_empty3,     5, 3, 1, 1, 0.0, 0.0);
//===================================================================//
	}

	public void addGrid(Component component, int gridx, int gridy, int gridheight, int gridwidth, double weightx, double weighty){
		gridConstraints.gridx = gridx;
		gridConstraints.gridy = gridy;
		gridConstraints.gridheight = gridheight;
		gridConstraints.gridwidth = gridwidth;
		gridConstraints.weightx = weightx;
		gridConstraints.weighty = weighty;
		grid.setConstraints(component, gridConstraints);
		add(component);//현재 패널에 컴포넌트를 붙이기.
	}
	
}//end of class.
