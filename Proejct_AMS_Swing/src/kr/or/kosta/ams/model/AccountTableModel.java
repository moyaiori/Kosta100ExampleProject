package kr.or.kosta.ams.model;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import ko.or.kosta.ams.util.GuiUtil;

public class AccountTableModel extends AbstractTableModel {
	
	Vector<String> accHeaderNames;
	Vector<Account> accList;
	
	AccountManager manager;
	
	
	public enum accType{
		GENERAL, MINUS
	}
	
	public AccountTableModel() {
		// TODO Auto-generated constructor stub
		accHeaderNames = new Vector<String>();
		accHeaderNames.addElement("계좌종류");
		accHeaderNames.addElement("계좌번호");
		accHeaderNames.addElement("예금주명");
		accHeaderNames.addElement("현재잔액");
		accHeaderNames.addElement("대출금액");
		
		accList = new Vector<Account>();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return accList.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return accHeaderNames.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Object cellData = null;
		switch (columnIndex) {
		case 0:	// 계좌종류
			if (checkAcc(accList.elementAt(rowIndex))) {
				cellData = "마이너스";
			} else {
				cellData = "입출금";
			}
			break;
		case 1: // 계좌번호
			cellData = accList.elementAt(rowIndex).getAccountNum();
			break;
		case 2: // 예금주명
			cellData = accList.elementAt(rowIndex).getAccountOwner();
			break;
		case 3: // 현재잔액
			cellData = GuiUtil.numFormat(accList.elementAt(rowIndex).getRestMoney());
			break;
		case 4: // 대출금액
			if (checkAcc(accList.elementAt(rowIndex))) {
			 MinusAccount minusAccount = (MinusAccount)accList.elementAt(rowIndex);
			cellData = GuiUtil.numFormat(minusAccount.getBorrowMoney());
		} else {
			cellData = "0";
		}
			break;
		}
		return cellData;
	}
	
	@Override
	//추상 메소드는 아니지만 헤더이름이 나오기위해서는
	// 반드시 재정의 필요
	public String getColumnName(int column) {
		return accHeaderNames.elementAt(column);
	}
	
	// 필수적으로 재정의해야 하는 메소드는 아니지만
	// 테이블의 각각의 셀에 원하는 데이터유형을 보여주고자 한다면 ...
	@Override
	public Class getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}
	
	/**
	 *  매니저에서 결과화면 가져오기
	 */
	public void updateAccount(List<Account> list){
		accList.clear();
		for (Account account : list) {
			accList.addElement(account);
		}
		// 뷰에게 변경을 통보
		fireTableStructureChanged();
	}
	
	/**
	 * 매니저에서 검색한 결과 보여주기 (단일)
	 */
	public void resultAccount(Account account){
		accList.clear();
		accList.addElement(account);
		fireTableStructureChanged();
	}
	
	/**
	 * 매니저에서 검색한 결과 보여주기 (리스트)
	 */
	public void resultAccount(List<Account> list){
		accList.clear();
		for (Account account : list) {
			accList.addElement(account);
		}
		fireTableStructureChanged();
		
	}

	/**
	 * 계좌 종류 비교
	 * @param acc
	 * @return
	 */
	private boolean checkAcc(Account acc){
		if (acc instanceof MinusAccount) {
			return true;
		}else{
			return false;
		}
	}

}
