import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.omg.CORBA.OMGVMCID;

public class RehearsalExample extends Frame {
	

	// NORTH
	Label recipientLB; 		//받는 사람 문자열
	TextField recipientTF;  //받는 사람
	Label addFileLB; 		//첨부 파일 문자열
	TextField addFileTF;	//첨부 파일
	Button findFileBtn;		//첨부 파일 찾기
	Label titleLB;			//제목 문자열
	TextField titleTF;		//제목
	Panel northPanel;		//상단 패널
	GridBagLayout gridBagLayout;			// 그리드백
	GridBagConstraints gridBagConstraints;	// 그리드백속성
	
	// CENTER
	TextField inputTF;		//내용 입력
	Panel centerPanel;		//상단 패널
	
	// SOUTH
	Button sendBtn;			//보내기
	Button cAncelBtn;		//취소
	Panel southPaenl;		//상단 패널
	
	
	
	
	public RehearsalExample(){
		this("예행 연습");
	}
	
	public RehearsalExample(String title){
		super(title);
		
		recipientLB = new Label("받는사람");
		recipientTF = new TextField();
		addFileLB = new Label("첨부파일");
		addFileTF = new TextField();
		findFileBtn = new Button("찾기");
		titleLB = new Label("제목");
		titleTF = new TextField();
		northPanel = new Panel();
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		inputTF = new TextField();
		centerPanel = new Panel();
		
		sendBtn = new Button("보내기");
		cAncelBtn = new Button("취 소");
		southPaenl = new Panel();
	}
	
	public void setComponents(){
		setLayout(new BorderLayout(0,0));
		
		makeNorthPanel();
		makeCenterPanel();
		makeSouthPanel();
		
		
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(southPaenl, BorderLayout.SOUTH);
	}
	
	private void makeNorthPanel(){
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		northPanel.setLayout(gridBagLayout);
		
		add(titleLB, 1, 0, 1, 1, 1.0, 1.0);
//		northPanel.add(titleLB, 0, 1, 1, 1, 1.0, 1.0);
//		northPanel.add(titleLB, 0, 2, 1, 1, 1.0, 1.0);
	}
	
	private void makeCenterPanel(){
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(inputTF, BorderLayout.CENTER);
	}
	
	private void makeSouthPanel(){
		southPaenl.setLayout(new FlowLayout());
		southPaenl.add(sendBtn, BorderLayout.CENTER);
		southPaenl.add(cAncelBtn, BorderLayout.EAST);
	}
	
	
	private void add(Component component, int gridX, int gridY, int gridWidth, int gridHeight, double weightX, double weightY){
		gridBagConstraints.gridx = gridX;
		gridBagConstraints.gridy = gridY;
		gridBagConstraints.gridwidth = gridWidth;
		gridBagConstraints.gridheight = gridHeight;
		gridBagConstraints.weightx = weightX;
		gridBagConstraints.weighty = weightY;
		
		gridBagLayout.setConstraints(component, gridBagConstraints);
		northPanel.add(component, gridBagConstraints);
	}
	
	public void exit(){
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	
	public void eventRegist(){
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				exit();
			}
		});
	}
	
	

	public static void main(String[] args) {
		RehearsalExample ui = new RehearsalExample();
		ui.setComponents();
		ui.setSize(600,400);
		ui.setVisible(true);
		ui.eventRegist();
	}

}
