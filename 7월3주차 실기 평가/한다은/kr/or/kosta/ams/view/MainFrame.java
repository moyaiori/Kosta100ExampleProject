package kr.or.kosta.ams.view;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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
		panel = new MainPanel();
	}
	
	public void setComponents(){
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
