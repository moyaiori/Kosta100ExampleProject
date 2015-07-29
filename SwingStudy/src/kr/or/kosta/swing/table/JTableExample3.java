package kr.or.kosta.swing.table;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * MVC 디자인패턴과 관련된 예제
 * JTable 활용 예제
 * @author 김기정
 *
 */
public class JTableExample3 extends JFrame {
	JTable table;
	
	JButton button, searchB;
	
	JLabel majorL;
	JTextField majorTF;
	JPanel updateP;
	
	// 테이블이 보여는 모델
//	StudentModel model;
	StudentModel2 model;
	
	public JTableExample3() {
		this("스윙컴포넌트들...");
	}

	public JTableExample3(String title) {
		super(title);
		button = new JButton("동적추가를 위한 버튼");
		searchB = new JButton("검색");

//		model = new StudentModel();
		model = new StudentModel2();
		table = new JTable(model);
//		table.setModel(model);
		
		majorL = new JLabel("학과");
		majorTF = new JTextField(10);
		updateP = new JPanel();
		
		updateP.add(majorL);
		updateP.add(majorTF);
		
	}

	public void setContents() {
		//setLayout(new FlowLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
//		add(searchB, BorderLayout.NORTH);
		add(updateP, BorderLayout.NORTH);
	}

	public void exit() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	public void studentAdd(){
		String name = "홍길동";
		String ssn = "45454545";
		String major = "체육학과";
		model.addStudent(name, ssn, major);
	}
	
	public void eventRegist() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				studentAdd();
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int selectedRow = table.getSelectedRow();
				Object selectedValue =  model.getValueAt(selectedRow, 2);
				majorTF.setText(selectedValue.toString());
			}
		});
		
		majorTF.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				model.updateStudent(selectedRow, majorTF.getText());
			}
		});
		
	}

	public static void main(String[] args) {
		// JFrame.setDefaultLookAndFeelDecorated(true);
		JTableExample3 frame = new JTableExample3();
		frame.setContents();
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.eventRegist();
	}
}






