package kr.or.kosta.swing.table;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 * MVC 모델과 관련된 예제 JTable 활용 예제
 * 
 * @author 김기정
 * 
 */
public class EmployeeUI extends JFrame {
	JTable table;
	EmployeeTableModel model;

	public EmployeeUI() {
		this("스윙컴포넌트들...");
	}

	public EmployeeUI(String title) {
		super(title);
		
		model = new EmployeeTableModel();
		table = new JTable(model);
		// table.setModel(model);
	}

	public void setContents() {
		// 테이블 설정 메소드
		table.setRowHeight(50);
		TableColumnModel tcm = table.getColumnModel();
		// TableColumn tc = tcm.getColumn(0);
		tcm.getColumn(0).setPreferredWidth(200);
		tcm.getColumn(1).setPreferredWidth(50);

		JTableHeader header = table.getTableHeader();
		header.setResizingAllowed(false);
		header.setReorderingAllowed(false);
		
		add(new JScrollPane(table), BorderLayout.CENTER);
	}

	public void exit() {
		setVisible(false);
		dispose();
		System.exit(0);
	}

	public void eventRegist() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
	}

	public static void main(String[] args) {
		EmployeeUI frame = new EmployeeUI();
		
		frame.setContents();
		frame.setSize(500, 200);
		frame.setVisible(true);
		frame.eventRegist();
	}
}
