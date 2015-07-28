package kr.or.kosta.swing.table;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * MVC 디자인패턴과 관련된 예제
 * JTable 활용 예제
 * @author 김기정
 *
 */
public class JTableExample2 extends JFrame {
	JTable table;
	
	// 테이블이 보여 는 모델
	Vector<Vector<String>> cellDatas;
	
	Vector<String> headerNames;
	
	public JTableExample2() {
		this("스윙컴포넌트들...");
	}

	public JTableExample2(String title) {
		super(title);
		cellDatas = new Vector<Vector<String>>();
		
		// Row 테이터
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
		
		
		// 헤더네임
		headerNames = new Vector<String>();
		headerNames.addElement("이름");
		headerNames.addElement("학번");
		headerNames.addElement("학과");
		
		table = new JTable(cellDatas, headerNames);
		
	}

	public void setContents() {
		//setLayout(new FlowLayout());
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
		// JFrame.setDefaultLookAndFeelDecorated(true);
		JTableExample2 frame = new JTableExample2();
		frame.setContents();
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.eventRegist();
	}
}






