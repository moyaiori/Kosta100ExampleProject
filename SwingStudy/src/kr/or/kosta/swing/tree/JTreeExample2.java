package kr.or.kosta.swing.tree;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;

/**
 * JTree 활용
 * Vector를 모델로 사용
 * @author 김기정
 */
public class JTreeExample2 extends JFrame {
	JTree tree;
	
	Vector<String> nodes;
	
	public JTreeExample2() {
		this("스윙컴포넌트들...");
	}

	public JTreeExample2(String title) {
		super(title);
		
		// Vector를 JTree의 모델로 사용
		nodes = new Vector<String>();
		nodes.addElement("사원목록");
		nodes.addElement("사원등록");
		nodes.addElement("사원검색");
		tree = new JTree(nodes);
	}

	public void setContents() {
		//setLayout(new FlowLayout());
		add(new JScrollPane(tree), BorderLayout.CENTER);
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
		JTreeExample2 frame = new JTreeExample2();
		frame.setContents();
		frame.setSize(200, 600);
		frame.setVisible(true);
		frame.eventRegist();
	}
}






