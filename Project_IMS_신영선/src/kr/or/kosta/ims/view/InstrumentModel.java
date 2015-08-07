package kr.or.kosta.ims.view;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import kr.or.kosta.ims.model.Instrument;
import kr.or.kosta.ims.model.Instruments;
/**
 * 테이블 출력을 위한 InstrumentModel 클래스 
 * @author 신영선
 *
 */
public class InstrumentModel extends AbstractTableModel {
	
	Vector<String> headerNames; // 행
	Vector<Instrument> cellDatas; // 열
	
	public InstrumentModel() {
		
		headerNames = new Vector<String>();
		headerNames.addElement("악기 종류");
		headerNames.addElement("일련 번호");
		headerNames.addElement("모델 명");
		headerNames.addElement("가격");
		headerNames.addElement("제조사");
		
		
		cellDatas = new Vector<Instrument>();
		
	}
	
	@Override
	public int getColumnCount() {
		return headerNames.size();
	}

	@Override
	public int getRowCount() {
		return cellDatas.size();
	}

	
	/**악기종류, 일련번호, 모델명, 가격, 제조사*/
	@Override
	public Object getValueAt(int rowIndex, int coulumnIndex) {
		Object cellData = null;
		switch (coulumnIndex) {
		case 0: //악기종류
			cellData = cellDatas.elementAt(rowIndex).getName();
			break;
		case 1: //일련번호
			cellData = cellDatas.elementAt(rowIndex).getSerialNumber();
			break;
		case 2:	// 모델명
			cellData = cellDatas.elementAt(rowIndex).getInstrumentSpecification().getProperty("model");
			break;
		case 3: //가격
			cellData = cellDatas.elementAt(rowIndex).getPrice();
			break;
		case 4: //제조사
			cellData = cellDatas.elementAt(rowIndex).getInstrumentSpecification().getProperty("builder");
			break;
		}
		return cellData;
	}
	
	@Override
	/** 헤더이름 출력 */
	public String getColumnName(int column) {
		return headerNames.elementAt(column);
	}
	
	
	/** 악기 전체 리스트 테이블에 출력 */
	public void print(List<Instrument> list){
		cellDatas.clear();
		for (Instrument instrument : list) {//
			cellDatas.addElement(instrument);
		}
			
		fireTableStructureChanged();
	}
		
	/** 조회된 악기 테이블에 출력 - 악기 1개 */
	public void printA(Instrument instrument){
		cellDatas.clear();
		cellDatas.addElement(instrument);

		fireTableStructureChanged();
	}
}
