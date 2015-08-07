package kr.or.kosta.notepad;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 문자스트림(BufferedReader/PrintWriter)을 이용한 메모장 애플리케이션 작성
 */
public class JNotepadUI extends JFrame {

	JMenuBar menuBar;
	JMenu fileMenu;
	JMenuItem newMI, openMI, saveMI, exitMI;
	JFileChooser fileChooser;

	JTextArea textArea;

	JNotepadIO notepadIO;

	public JNotepadUI() {
		this("자바 메모장");
	}

	public JNotepadUI(String title) {
		super(title);
		menuBar = new JMenuBar();
		fileMenu = new JMenu("파일");
		newMI = new JMenuItem("새로만들기");
		openMI = new JMenuItem("열기");
		saveMI = new JMenuItem("저장");
		exitMI = new JMenuItem("종료");
		fileChooser = new JFileChooser();
		textArea = new JTextArea();

		fileChooser.setCurrentDirectory(new File("I:/"));

		notepadIO = new JNotepadIO();

	}

	public void setMenu() {
		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		fileMenu.add(newMI);
		fileMenu.add(openMI);
		fileMenu.add(saveMI);
		fileMenu.addSeparator();
		fileMenu.add(exitMI);
	}

	public void setContents() {
		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}

	/** 종료 처리 */
	public void exit() {
		setVisible(false);
		dispose();
		System.exit(0);
	}

	private void newFile() {
		textArea.setText("");
	}

	/**
	 * 파일 열기
	 */
	private void openFile() {
		// 다이얼로그에서 유저가 선택한 버튼 종류 구분
		int userSelection = fileChooser.showSaveDialog(this);
		// 저장 버튼을 눌렀을시
		if (userSelection == fileChooser.APPROVE_OPTION) {
			textArea.setText(notepadIO.fileToString(fileChooser.getSelectedFile()));
		}
	}

	/**
	 * 파일 저장하기
	 */
	private void saveFile() {
		// 다이얼로그에서 유저가 선택한 버튼 종류 구분
		int userSelection = fileChooser.showSaveDialog(this);
		// 저장 버튼을 눌렀을시
		if (userSelection == fileChooser.APPROVE_OPTION) {
			notepadIO.stringToFile(textArea.getText(), fileChooser.getSelectedFile());
		}
	}

	public void eventRegist() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});

		newMI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				newFile();
			}
		});

		saveMI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				saveFile();
			}
		});

		openMI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				openFile();
			}
		});

		exitMI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				exit();
			}
		});

	}

	public static void main(String[] args) {
		JNotepadUI ui = new JNotepadUI();
		ui.setMenu();
		ui.setContents();
		ui.setSize(300, 300);
		// GUIUtil.setFullScreen(ui);
		GUIUtil.setLookNFeel(ui, GUIUtil.THEME_NIMBUS);
		ui.setVisible(true);
		ui.eventRegist();
	}
}
