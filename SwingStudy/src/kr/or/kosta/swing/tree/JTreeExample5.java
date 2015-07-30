package kr.or.kosta.swing.tree;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 * JTree 활용
 * TreeCellRenderer 설정을 이용한 노드이미지 변경
 * 이벤트 처리
 * @author 김기정
 */
public class JTreeExample5 extends JFrame {
	
	JTree tree;
	
	TreeModel model;
	
	// 노드이미지 변경을 위한 셀렌더러
	DefaultTreeCellRenderer cellRenderer;

	// 루트 노드 생성
	DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("회원관리");
	// 브랜치/리프 노드 생성
	DefaultMutableTreeNode listNode, addNode, searchNode, deleteNode;
	
	public JTreeExample5() {
		this("스윙컴포넌트들...");
	}

	public JTreeExample5(String title) {
		super(title);
		
		
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
		
		// 기본 제공되는 TreeCellRenderer 사용
		cellRenderer = new DefaultTreeCellRenderer();
		
		// 노드 이미지 변경하가..
		cellRenderer.setLeafIcon(createImageIcon("icons4680.png"));
		cellRenderer.setClosedIcon(createImageIcon("icons5063.png"));
		cellRenderer.setOpenIcon(createImageIcon("icons5139.png"));
		tree.setCellRenderer(cellRenderer);
		
	}

	public ImageIcon createImageIcon(String  fileName) {
		return new ImageIcon("classes/images/" + fileName);
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
		
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				// 선택노드 얻기				
				MutableTreeNode selectNode = (MutableTreeNode) tree.getLastSelectedPathComponent();
				if(selectNode == rootNode){
					System.out.println("회원관리 선택");
				}else if(selectNode == listNode){
					System.out.println("목록 선택");
				}else if(selectNode == addNode){
					System.out.println("등록 선택");
				}else if(selectNode == searchNode){
					System.out.println("검색 선택");
				}else if(selectNode == deleteNode){
					System.out.println("삭제 선택");
				}
				
				// 노드 경로 얻기
				TreePath treePath =  tree.getSelectionPath();
				//System.out.println(treePath);
				Object[] path = treePath.getPath();
				for (Object node : path) {
					System.out.print(node + "\\");
				}
			}
		});
	}

	public static void main(String[] args) {
		// JFrame.setDefaultLookAndFeelDecorated(true);
		JTreeExample5 frame = new JTreeExample5();
		frame.setContents();
		frame.setSize(200, 600);
		frame.setVisible(true);
		frame.eventRegist();
	}
}






