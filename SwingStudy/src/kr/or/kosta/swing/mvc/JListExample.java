package kr.or.kosta.swing.mvc;
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
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * MVC 디자인패턴과 관련된 예제
 * @author 김기정
 *
 */
public class JListExample extends JFrame {
	JList list;
	
	// JList의 View가 보여줄 데이터 저장을 위한 모델
	//String[] model;
	//Vector<String> model;
	
	// 사용자정의 ListModel
	//NameModel model;
	
	// 이미 만들어져 있는 DefaultListModel
	DefaultListModel<Icon> model;
	
	
	JTextField tf;
	JButton button, deleteButton, updateButton;
	
	public JListExample() {
		this("스윙컴포넌트들...");
	}

	public JListExample(String title) {
		super(title);
		String[] items = {"aaa", "bbb"};
		
		// 모델 생성
		//model = new String[10];
		//model[0] = "규빈";
		//model[1] = "희상";
		//model[2] = "기정";
		//model = new Vector<String>();
		//model.addElement("규빈");
		//model.addElement("희상");
		
		//model = new NameModel();
		
		model = new DefaultListModel<Icon>();
		
		list = new JList(model);
		//list.setModel(model);
		//list.getModel();
		
		tf = new JTextField(20);
		button = new JButton("등록");
		deleteButton = new JButton("삭제");
		updateButton = new JButton("수정");
	}

	public void setContents() {
		setLayout(new FlowLayout());
		add(new JScrollPane(list));
		add(tf);
		add(button);
		add(deleteButton);
		add(updateButton);
		
	}
	
	public ImageIcon createImageIcon(String  fileName) {
		return new ImageIcon("images/" + fileName);
	}

	public void exit() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	public void add(){
		String name = tf.getText();
		if(name != null){
			tf.setText("");
			//model[3] = name;
			//model.addElement(name);
			//model.addName(name);
			model.addElement(createImageIcon(name));
		}
		
				
	}
	
	public void delete(){
		int idx = list.getSelectedIndex();
		//model.deleteName(idx);
		model.removeElementAt(idx);
	}
	
	public void update(){
		String name = tf.getText();
		name = name.substring(7);
		if(name != null){
			int idx = list.getSelectedIndex();
			//model.updateName(name, idx);
			model.setElementAt(createImageIcon(name), idx);
		}
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
				add();				
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				delete();			
			}
		});
		
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Object value = list.getSelectedValue();
				if(value != null){
					tf.setText(value.toString());
				}
				
			}
		});
		
		updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				update();			
			}
		});
		
	}

	public static void main(String[] args) {
		// JFrame.setDefaultLookAndFeelDecorated(true);
		JListExample frame = new JListExample();
		frame.setContents();
		frame.setSize(600, 400);
		frame.setVisible(true);
		frame.eventRegist();
	}
}






