package kr.or.kosta.swing.tree;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;

import kr.or.kosta.swing.util.GuiUtil;

/**
 * JTree 활용
 * Hashtable을 모델로 사용
 * @author 김기정
 */
public class JTreeExample3 extends JFrame {
	JTree tree;
	
	Hashtable<String, Object> nodes;
	
	public JTreeExample3() {
		this("스윙컴포넌트들...");
	}

	public JTreeExample3(String title) {
		super(title);
		
		// Hashtable을 JTree의 모델로 사용
		nodes = new Hashtable<String, Object>();
		
		Hashtable<String, Object> subNodes = new Hashtable<String, Object>();
		subNodes.put("목록", "");
		subNodes.put("등록", "");
		subNodes.put("삭제", "");
		
		// 루트노드 설정
		nodes.put("사원관리", subNodes);
		
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
		JTreeExample3 frame = new JTreeExample3();
		frame.setContents();
		frame.setSize(200, 600);
		
		GuiUtil.setLookNFeel(frame, GuiUtil.THEME_NIMBUS);
		frame.setVisible(true);
		frame.eventRegist();
	}
}






