package kr.or.kosta.ams.view;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.WindowConstants;

import kr.or.kosta.ams.model.AccountManager;

public class MainFrame extends Frame {
	
	AccountManager manager;
	MainPanel panel;
	
	public MainFrame(){
		this("KOSTA은행 계좌관리 - 메인화면");
	}
	public MainFrame(String title){
		super(title);
		manager = new AccountManager();
		panel = new MainPanel(manager);	
	}
	
	public void setComponents(){
		setLayout(new BorderLayout());
		add(panel, BorderLayout.CENTER);
	}
	
	public void exit(){
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	public void eventRegist(){
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
	}
}
