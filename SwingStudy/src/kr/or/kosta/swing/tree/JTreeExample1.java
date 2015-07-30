package kr.or.kosta.swing.tree;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;

/**
 * JTree 활용
 * Object[]을 모델로 사용
 * @author 김기정
 */
public class JTreeExample1 extends JFrame {
	JTree tree;
	
	public JTreeExample1() {
		this("스윙컴포넌트들...");
	}

	public JTreeExample1(String title) {
		super(title);
		
		// 배열을 JTree의 모델로 사용
		Object[] nodes = {"사원목록", "사원등록", "사원검색"};
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
		JTreeExample1 frame = new JTreeExample1();
		frame.setContents();
		frame.setSize(200, 600);
		frame.setVisible(true);
		frame.eventRegist();
	}
}
