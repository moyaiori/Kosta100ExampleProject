package ko.or.kosta.ams.view;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.List;

import javax.swing.JTable;

import ko.or.kosta.ams.util.GuiUtil;
import kr.or.kosta.ams.model.Account;
import kr.or.kosta.ams.model.AccountManager;
import kr.or.kosta.ams.model.MinusAccount;


public class MainFrame extends Frame {
	AccountManager manager;
	MainPanel panel;
	TextArea showTA;
//	JTable showTB;

	
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
	}
	
	/**
	 * 화면 배치
	 */
	public void setComponents(){
		setLayout(new BorderLayout());
		add(panel, BorderLayout.NORTH);
		add(showTA, BorderLayout.CENTER);
		
		// 초이스 아이템 초기값이 입출금계좌 및 전체 이기때문에 대출금 막기
		setEnableBrowTF(true);
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
	 * 상단 기본틀 및 출력
	 */
	
	private void setUpFrame(StringBuffer sb){
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("---------------------------------------------------------------------------------\n");
		stringBuffer.append(" 계좌종류\t계좌번호\t예금주명\t현재잔액\t대출금액\n");
		stringBuffer.append("=================================================================================\n");
		stringBuffer.append(sb);
		
		showTA.setText(stringBuffer.toString());
	}
	
	/**
	 * 추가 메시지용 오버로딩
	 * @param sb
	 * @param str
	 */
	
	private void setUpFrame(StringBuffer sb, String str){
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("---------------------------------------------------------------------------------\n");
		stringBuffer.append(" 계좌종류\t계좌번호\t예금주명\t현재잔액\t대출금액\n");
		stringBuffer.append("=================================================================================\n");
		stringBuffer.append(sb + "\n");
		stringBuffer.append(str + "\n");
		
		showTA.setText(stringBuffer.toString());
	}
	
	
	/**
	 * 텍스트 에리어 기본 셋팅, 단일 정보 출력(객체)
	 */
	
	private StringBuffer setUpInfo(Account acc){
		StringBuffer sb = new StringBuffer();
		sb.append(checkAcc(acc));
		sb.append(acc.getAccountNum() + "\t\t");
		sb.append(acc.getAccountOwner() + "\t\t");
		sb.append(GuiUtil.numFormat(acc.getRestMoney()) + "\t\t");
		if (acc instanceof MinusAccount) {
			MinusAccount mAcc = (MinusAccount)acc;
			sb.append(GuiUtil.numFormat(mAcc.getBorrowMoney()) + "\t\t");
		}
		return sb;
	}
	
	/**
	 * 텍스트 에리어 기본 셋팅, 다수의 데이터 출력(list)
	 */
	
	private StringBuffer setUpInfo(List<Account> list){
		StringBuffer sb = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		Formatter formatter = new Formatter();
		String temp;
		for (Account acc : list) {
			sb.append(checkAcc(acc));
			sb.append(acc.getAccountNum() + "\t\t");
			sb.append(acc.getAccountOwner() + "\t\t");
			sb.append(GuiUtil.numFormat(acc.getRestMoney()) + "\t\t");
			if (acc instanceof MinusAccount) {
				MinusAccount mAcc = (MinusAccount)acc;
				sb.append(GuiUtil.numFormat(mAcc.getBorrowMoney()) + "\t\t");
//				sb.append(mAcc.getBorrowMoney() + "\t\t");
			}
			sb.append("\n");
		}
		return sb;
	}
	
	/**
	 * 어카운트 비교
	 */
	
	private String checkAcc(Account acc){
		if (acc instanceof MinusAccount) {
			return "마이너스\t";
		}else{
			return "입출금\t\t";
		}
	}
	
	/**
	 * 검색한 계좌로 보여주기 (조회)
	 */
	private void lookUpAccount(String accNum){
		Account acc = manager.getAccount(accNum);
		setUpFrame(setUpInfo(acc), accNum + " : 다음 계좌로 검색 조회됬습니다.");
	}
	
	/**
	 * 계좌 삭제(삭제)
	 */
	
	private void removeAccount(String accNum){
		StringBuffer sb = new StringBuffer();
		if(manager.removeAccount(accNum)){
			setUpFrame(setUpInfo(manager.getAccounts()),accNum + " : 다음 계좌가 삭제 되었습니다.");
		}else{
			sb.append("계좌 삭제에 실패 했습니다.");
		}
	}
	
	/**
	 * 예금주 명으로 검색하기 (검색)
	 */
	private void searchAccount(String accOwner){
		List<Account> list = manager.searchAccount(accOwner);
		setUpFrame(setUpInfo(list), accOwner + " : 다음 예금주명으로 검색한 내용입니다."); 
	}
	
	/**
	 * 입출금 계좌 개설 (신규 등록, 입출금)
	 */
	private void openAcction(String accountNum, String accountOwner, int passwd, long restMoney){
		
		boolean flag = manager.openAccount(new Account(
				accountNum,
				accountOwner, 
				passwd, 
				restMoney
				));

		// 계좌 생성 성공시 
		if(flag){
			setUpFrame(setUpInfo(manager.getAccounts()), "신규 입출금 계좌가 개설되었습니다."); 
		}else{
			setUpFrame(setUpInfo(manager.getAccounts()), "계좌 생성에 실패하였습니다.");
		}
	}
	
	/**
	 * 마이너스 계좌 개설 (신규 등록, 마이너스)
	 */
	private void openMinusAcction(String accountNum, String accountOwner, int passwd, long restMoney, long borrowMoney){
		boolean flag = manager.openAccount(new MinusAccount(
				accountNum,
				accountOwner,
				passwd,
				restMoney,
				borrowMoney
				));
		// 계좌 생성 성공시 
		if(flag){
			setUpFrame(setUpInfo(manager.getAccounts()), "신규 마이너스 계좌가 개설되었습니다."); 
		}else{
			setUpFrame(setUpInfo(manager.getAccounts()), "계좌 생성에 실패하였습니다."); 
		}
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
				// TODO Auto-generated method stub
				if (e.getItem() == "입출금계좌") {
//					System.out.println(e.getItem());
					setEnableBrowTF(true);
				}else{
//					System.out.println(e.getItem());
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
					openAcction(panel.accNumTF.getText(), 
							panel.accOwnrTF.getText(), 
							Integer.parseInt(panel.passTF.getText()), 
							Long.parseLong(panel.accDrawMoneyTF.getText()));
				}else if(panel.accKindC.getSelectedItem() == "마이너스계좌"){
					openMinusAcction(panel.accNumTF.getText(), 
							panel.accOwnrTF.getText(), 
							Integer.parseInt(panel.passTF.getText()), 
							Long.parseLong(panel.accDrawMoneyTF.getText()),
							Long.parseLong(panel.accBrowTF.getText()));
//					System.out.println(panel.accBrowTF.getText());
				}else {
					return;
				}
			}
		});
		
		// 계좌 전체 조회
		panel.accAllLookUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setUpFrame(setUpInfo(manager.getAccounts())); 
			}
		});
	}
}
