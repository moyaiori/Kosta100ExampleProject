package kr.or.kosta.ims.view;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import kr.or.kosta.ims.model.Instrument;
/**
 * 악기의 정보를 보여줄 테이블 모델
 * @author 손진영
 *
 * 작성일 : 2015-08-03
 */
public class InstrumentTableModel extends AbstractTableModel {
	/** 테이블에 들어갈 헤더와 데이터 */
	Vector<String> headName;
	Vector<Instrument> instrumentList;
	
	/** 생성자 */
	public InstrumentTableModel() {
		headName = new Vector<String>();
		headName.addElement("악기종류");
		headName.addElement("일련번호");
		headName.addElement("모델명");
		headName.addElement("가격");
		headName.addElement("제조사");
		
		instrumentList = new Vector<Instrument>();
	}
	/** 반드시 구현해야하는 오버라이딩 메소드 */
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return headName.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return instrumentList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object cellData = null;
		switch(columnIndex){
		case 0:
			/** 악기 종류 */
			cellData = instrumentList.elementAt(rowIndex).getName();
			break;
		case 1:
			/** 일련번호 */
			cellData = instrumentList.elementAt(rowIndex).getSerialNumber();
			break;
		case 2:
			/** 모델명 */
			cellData = instrumentList.elementAt(rowIndex).getSpecification().getProperty("model");
			break;
		case 3:
			/** 가격 */
			cellData = instrumentList.elementAt(rowIndex).getFormatPrice();
			break;
		case 4:
			/** 제조사 */
			cellData = instrumentList.elementAt(rowIndex).getSpecification().getProperty("builder");
			break;
		}
		return cellData;
	}
	
	/** 헤더를 표시하기 위한 오버라이딩 */
	@Override
	public String getColumnName(int column) {
		return headName.elementAt(column);
	}
	
	/** 조회시 검색된 악기 객체를 모델이 뷰에게 변경하라고 통보 */
	public void serialList(Instrument instrument){
		instrumentList.clear();
		instrumentList.addElement(instrument);
		fireTableDataChanged();
	}
	
	/** 특정 조건 검색시 검색된 목록을 모델이 뷰에게 변경하라고 통보 */
	public void searchList(List<Instrument> instruments){
		instrumentList.clear();
		for (Instrument instrument : instruments) {
			instrumentList.addElement(instrument);
		}
		fireTableDataChanged();
	}
}
