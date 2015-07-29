package kr.or.kosta.swing.table;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * MVC 디자인패턴과 관련된 예제
 * JTable 활용 예제
 * @author 김기정
 *
 */
public class JTableExample extends JFrame {
	JTable table;
	
	public JTableExample() {
		this("스윙컴포넌트들...");
	}

	public JTableExample(String title) {
		super(title);
		// 테이블이 보여주는 모델
		Object[][] cellDatas = {{"김기정", "87342065", "무역학과"}, 
				                {"박기정", "87342065", "무역학과"},
				                {"최기정", "87342065", "무역학과"}
				               };
		Object[] headerNames = {"이름", "학번", "학과"};
		table = new JTable(5, 5);
//		table = new JTable(cellDatas, headerNames);
		
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
		JTableExample frame = new JTableExample();
		frame.setContents();
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.eventRegist();
	}
}






