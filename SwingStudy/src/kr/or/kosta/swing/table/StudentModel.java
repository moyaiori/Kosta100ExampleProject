package kr.or.kosta.swing.table;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class StudentModel extends AbstractTableModel implements TableModel {
	
	Vector<String> headerNames;
	Vector<Vector<String>> cellDatas;
	
	
	public StudentModel(){
		headerNames = new Vector<String>();
		headerNames.addElement("이름");
		headerNames.addElement("학번");
		headerNames.addElement("학과");
		
		cellDatas = new Vector<Vector<String>>();
		
		// 가상 Row 테이터
		Vector<String> row = new Vector<String>();
		row.addElement("김기정");
		row.addElement("87342065");
		row.addElement("무역학과");
		
		Vector<String> row2 = new Vector<String>();
		row2.addElement("박기정");
		row2.addElement("87342065");
		row2.addElement("무역학과");
		cellDatas.addElement(row);
		cellDatas.addElement(row2);
		
	}

	// 주로 뷰에게 데이터를 제공하기 위한 역할의 메소드들
	// 반드시 구현해야 하는 구현 메소드(추상메서드)
	@Override
	public int getRowCount() {
		return cellDatas.size();
	}

	@Override
	public int getColumnCount() {
		return headerNames.size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return cellDatas.elementAt(rowIndex).elementAt(columnIndex);
	}
	
	@Override
	//추상 메소드는 아니지만 헤더이름이 나오기위해서는
	// 반드시 재정의 필요
	public String getColumnName(int column) {
		return headerNames.elementAt(column);
	}
	
	/**
	 * 학생정보 등록을 위한 사용자 정의 메소드
	 */
	public void addStudent(String name, String ssn, String major){
		Vector<String> row = new Vector<String>();
		row.addElement(name);
		row.addElement(ssn);
		row.addElement(major);	
		
		cellDatas.addElement(row);
		
		// 뷰에게 변경을 통보
		fireTableStructureChanged();
	}
	
	public void setStudent(Student student){
		cellDatas.clear();
		
		Vector<String> row = new Vector<String>();
		row.addElement(student.getName());
		row.addElement(student.getSsn());
		row.addElement(student.getMajor());	
		
		cellDatas.addElement(row);
		
		// 뷰에게 변경을 통보
		fireTableStructureChanged();
	}


}





