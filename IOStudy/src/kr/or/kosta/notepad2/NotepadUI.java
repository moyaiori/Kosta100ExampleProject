package kr.or.kosta.notepad2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

/**
 * 문자스트림을 이용한 메모장 작성
 */
public class NotepadUI extends JFrame {
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenuItem newMI, openMI, saveMI, exitMI;
	JTextArea textArea;
	
	public NotepadUI(){
		this("자바 메모장");
	}
	public NotepadUI(String title){
		super(title);
		createMenus();
		textArea = new JTextArea();
	}
	
	public void createMenus(){
		menuBar = new JMenuBar();
		fileMenu = new JMenu("파일");
		newMI = new JMenuItem("새로만들기");
		openMI = new JMenuItem("열기");
		saveMI = new JMenuItem("저장");
		exitMI = new JMenuItem("종료");
		// 단축키 설정
		newMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
		openMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));
		saveMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
		exitMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_MASK));
		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		fileMenu.add(newMI);
		fileMenu.add(openMI);
		fileMenu.add(saveMI);
		fileMenu.addSeparator();//구분선
		fileMenu.add(exitMI);
	}
	
	public void setContents(){
		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}
	
	public void exit(){
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	public void readFile(){
		JFileChooser fileChooser = new JFileChooser(".");
		int action = fileChooser.showOpenDialog(this);
		// 열기 버튼 선택시
		if(action == JFileChooser.APPROVE_OPTION){
			File selectedFile = fileChooser.getSelectedFile();
			FileDao dao = new FileDao(selectedFile.getAbsolutePath());
			try {
				String fileText = dao.read();
				textArea.setText(fileText);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "열기 에러", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void saveFile(){
		JFileChooser fileChooser = new JFileChooser(".");
		int action = fileChooser.showSaveDialog(this);
		// 저장 버튼 선택시
		if(action == JFileChooser.APPROVE_OPTION){
			File saveFile = fileChooser.getSelectedFile();
			FileDao dao = new FileDao(saveFile.getAbsolutePath());
			try {
				String txt = textArea.getText();
				txt = txt.replaceAll("\n", "\r\n");
				dao.save(txt);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "저장 에러", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void eventRegist(){
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		
		exitMI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		
		newMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});

		
		openMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				readFile();
			}
		});
		
		saveMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveFile();
			}
		});
	}
	
	
	public static void main(String[] args) {
		NotepadUI ui = new NotepadUI();
		ui.setContents();
		GUIUtil.setFullScreen(ui);
		ui.setVisible(true);
		ui.eventRegist();
	}
}
