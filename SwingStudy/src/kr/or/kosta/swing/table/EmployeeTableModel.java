package kr.or.kosta.swing.table;

import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

public class EmployeeTableModel extends AbstractTableModel {
	
	Vector<String> headerNames;
	Vector<Employee> employeeList;
	
	public EmployeeTableModel(){
		headerNames = new Vector<String>();
		headerNames.addElement("이름");
		headerNames.addElement("사번");
		headerNames.addElement("부서");
		headerNames.addElement("나이");
		headerNames.addElement("몸무게");
		headerNames.addElement("성별");
		headerNames.addElement("사진");
		
		employeeList = new Vector<Employee>();
		// 테스트를 위한 사원데이터
		//System.out.println(getClass().getResource("/images"));
		Employee emp1 = new Employee("김기정", "1234", "KOSTA", 40, 53.56, true, new ImageIcon(("classes/images/icons4680.png")));
		Employee emp2 = new Employee("박기순", "1234", "KOSTA", 40, 53.56, false, new ImageIcon(("classes/images/icons5139.png")));
		employeeList.addElement(emp1);
		employeeList.addElement(emp2);
	}

	@Override
	public int getRowCount() {
		return employeeList.size();
	}

	@Override
	public int getColumnCount() {
		return headerNames.size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object cellData = null;
		switch (columnIndex) {
			case 0: 
				cellData = employeeList.elementAt(rowIndex).getName();
				break;
			case 1: 
				cellData = employeeList.elementAt(rowIndex).getSsn();
				break;
			case 2: 
				cellData = employeeList.elementAt(rowIndex).getDepartment();
				break;
			case 3: 
				cellData = employeeList.elementAt(rowIndex).getAge();
				break;
			case 4: 
				cellData = employeeList.elementAt(rowIndex).getWeight();
				break;
			case 5: 
				cellData = employeeList.elementAt(rowIndex).isMan();
				break;
			case 6: 
				cellData = employeeList.elementAt(rowIndex).getIcon();
				break;
		}
		
		return cellData;
	}
	
	@Override
	//추상 메소드는 아니지만 헤더이름이 나오기위해서는
	// 반드시 재정의 필요
	public String getColumnName(int column) {
		return headerNames.elementAt(column);
	}
	
	// 필수적으로 재정의해야 하는 메소드는 아니지만
	// 테이블의 각각의 셀에 원하는 데이터유형을 보여주고자 한다면 ...
	@Override
	public Class getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}
}





