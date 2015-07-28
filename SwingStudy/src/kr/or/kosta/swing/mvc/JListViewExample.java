package kr.or.kosta.swing.mvc;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * MVC 디자인패턴과 관련된 예제
 * @author 김기정
 *
 */
public class JListViewExample extends JFrame {
	JList<String> list;
	DefaultListModel<String> model;
	
	MyCellRenderer cellRenderer;
	
	public JListViewExample() {
		this("스윙컴포넌트들...");
	}

	public JListViewExample(String title) {
		super(title);
		model = new DefaultListModel<String>();
		model.addElement("김민형");
		model.addElement("이재하");
		model.addElement("박퇴폐");
		list = new JList<String>();
		list.setModel(model);
		cellRenderer = new MyCellRenderer();
		list.setCellRenderer(cellRenderer);
	}

	public void setContents() {
		setLayout(new FlowLayout());
		add(new JScrollPane(list));
		//ListCellRenderer cellRenderer = list.getCellRenderer();
		//System.out.println(cellRenderer);
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
		JListViewExample frame = new JListViewExample();
		frame.setContents();
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.eventRegist();
	}
}






