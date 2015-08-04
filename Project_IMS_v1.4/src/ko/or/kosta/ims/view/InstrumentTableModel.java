package ko.or.kosta.ims.view;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import ko.or.kosta.ims.model.Instrument;
import ko.or.kosta.ims.model.InstrumentSpecification.specPropertie;


public class InstrumentTableModel extends AbstractTableModel {
	
	Vector<String> instrumentHeaderNames;
	Vector<Instrument> instrumentsList;
	
	public InstrumentTableModel() {
		// TODO Auto-generated constructor stub
		instrumentHeaderNames = new Vector<String>();
		instrumentHeaderNames.addElement("악기종류");
		instrumentHeaderNames.addElement("일련번호");
		instrumentHeaderNames.addElement("모델명");
		instrumentHeaderNames.addElement("가격");
		instrumentHeaderNames.addElement("제조사");
		
		instrumentsList = new Vector<Instrument>();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return instrumentsList.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return instrumentHeaderNames.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object cellData = null;
		
		switch (columnIndex) {
		case 0:	// 악기 종류
			cellData = instrumentsList.elementAt(rowIndex).getName();
			break;
		case 1:	// 일련 번호
			cellData = instrumentsList.elementAt(rowIndex).getSerialNumber();
			break;
		case 2: // 모델명
			cellData = instrumentsList.elementAt(rowIndex).getSpecification().getProperty(specPropertie.MODEL);
			break;
		case 3: // 가격
			cellData = instrumentsList.elementAt(rowIndex).getPrice();
			break;
		case 4: // 제조사
			cellData = instrumentsList.elementAt(rowIndex).getSpecification().getProperty(specPropertie.BUILDERS);
			break;

		}
		
		return cellData;
	}
	
	@Override
	//추상 메소드는 아니지만 헤더이름이 나오기위해서는
	// 반드시 재정의 필요
	public String getColumnName(int column) {
		return instrumentHeaderNames.elementAt(column);
	}
	
	// 필수적으로 재정의해야 하는 메소드는 아니지만
	// 테이블의 각각의 셀에 원하는 데이터유형을 보여주고자 한다면 ...
	@Override
	public Class getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}
	
	/**
	 * 일련번호 검색 결과
	 */
	public void resultInstruments(Instrument instrument){
		instrumentsList.clear();
		instrumentsList.addElement(instrument);
		fireTableStructureChanged();
	}
	
	/**
	 * 리스트로 보여주기
	 */
	public void resultInstrumentsList(List<Instrument> list){
		instrumentsList.clear();
		for (Instrument account : list) {
			instrumentsList.addElement(account);
		}
		fireTableStructureChanged();
		
	}
	

}
