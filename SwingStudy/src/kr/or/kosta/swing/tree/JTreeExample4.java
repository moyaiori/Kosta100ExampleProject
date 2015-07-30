package kr.or.kosta.swing.tree;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

import kr.or.kosta.swing.util.GuiUtil;

/**
 * JTree 활용 예제
 * TreeModel을 모델로 사용
 * @author 김기정
 */
public class JTreeExample4 extends JFrame {
	JTree tree;
	TreeModel model;
	
	public JTreeExample4() {
		this("스윙컴포넌트들...");
	}

	public JTreeExample4(String title) {
		super(title);
		
		// 루트 노드 생성
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("회원관리");
		
		// 브랜치/리프 노드 생성
		DefaultMutableTreeNode listNode, addNode, searchNode, deleteNode;
		
		listNode = new DefaultMutableTreeNode("목록");
		addNode = new DefaultMutableTreeNode("등록");
		searchNode = new DefaultMutableTreeNode("검색");
		deleteNode = new DefaultMutableTreeNode("삭제");
		
		// 루트노드에 브랜치노드 추가
		rootNode.add(listNode);
		rootNode.add(addNode);
		rootNode.add(searchNode);
		rootNode.add(deleteNode);
		
		// TreeModel을 JTree의 모델로 사용
		model = new DefaultTreeModel(rootNode);
		
		tree = new JTree(model);
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
		JTreeExample4 frame = new JTreeExample4();
		frame.setContents();
		frame.setSize(200, 600);
		
		GuiUtil.setLookNFeel(frame, GuiUtil.THEME_NIMBUS);
		frame.setVisible(true);
		frame.eventRegist();
	}
}






