package kr.or.kosta.swing.mvc;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * MVC 디자인패턴과 관련된 예제
 * JList의 아이템에 사용자 이미지와 이름을 같이 보여주기
 * @author 김기정
 *
 */
public class ViewExample2 extends JFrame {
	JList<Student> list;
	
	Vector<Student> items;
	StudentCellRender renderer;
	
	public ViewExample2() {
		this("스윙컴포넌트들...");
	}

	public ViewExample2(String title) {
		super(title);
		items = new Vector<Student>();
		items.addElement(new Student("김기정", "87342065", "무역학과", "images/icons4685.png"));
		items.addElement(new Student("이맹구", "87342065", "무역학과", "images/icons4686.png"));
		items.addElement(new Student("이맹구", "87342065", "무역학과", "images/icons4687.png"));
		list = new JList<Student>(items);
		
		renderer = new StudentCellRender();
		list.setCellRenderer(renderer);
	}

	public void setContents() {
		setLayout(new FlowLayout());
		add(new JScrollPane(list));
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
		ViewExample2 frame = new ViewExample2();
		frame.setContents();
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.eventRegist();
	}
}






