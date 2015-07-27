package ko.or.kosta.ams.view;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class MainPanel extends Panel {
	Label accKindLB, accNumLB, accOwnrLB, passLB, accDrawMoneyLB ,accBrowLB;
	TextField accNumTF, accOwnrTF, passTF, accDrawMoneyTF, accBrowTF;
	Button accLookUp, accDelete,  accSearch, accNew, accAllLookUp;
	Choice accKindC;
	Label accList, money;
	
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	public MainPanel(){
		accKindLB = new Label("계좌종류");
		accNumLB = new Label("계좌번호");
		accOwnrLB = new Label("예금주명");
		passLB = new Label("비밀번호");
		accDrawMoneyLB = new Label("입금금액");
		accBrowLB = new Label("대출금액");
		
		accNumTF = new TextField();
		accOwnrTF = new TextField();
		passTF = new TextField();
		accDrawMoneyTF = new TextField();
		accBrowTF = new TextField();
		
		accLookUp = new Button("조 회");
		accDelete = new Button("삭 제");
		accSearch = new Button("검 색");
		accNew = new Button("신규등록");
		accAllLookUp = new Button("전체조회");
		
		accKindC = new Choice();
		accKindC.add("전체");
		accKindC.add("입출금계좌");
		accKindC.add("마이너스계좌");
		
		accList = new Label("계좌목록");
		money = new Label("(단위 : 원)");
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		
		setComponents();
	}
	
	
	
	// 화면 구성
	public void setComponents(){
		
		setLayout(gridBagLayout);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.insets = new Insets(3,5,3,5);
		
		add(accKindLB, 0, 0, 1, 1, 0.0, 0.0);
		add(accKindC, 1, 0, 2, 1, 0.0, 0.0);
		
		add(accNumLB, 0, 1, 1, 1, 0.0, 0.0);
		add(accNumTF, 1, 1, 2, 1, 0.0, 0.0);
		add(accLookUp, 3, 1, 1, 1, 0.0, 0.0);
		add(accDelete, 4, 1, 1, 1, 0.0, 0.0);
		add(new Label(" "), 5, 1, 1, 1, 0.0, 0.0);
		add(new Label(" "), 6, 1, 1, 1, 0.0, 0.0);
		
		add(accOwnrLB, 0, 2, 1, 1, 0.0, 0.0);
		add(accOwnrTF, 1, 2, 2, 1, 0.0, 0.0);
		add(accSearch, 3, 2, 1, 1, 0.0, 0.0);
		
		add(passLB, 0, 3, 1, 1, 0.0, 0.0);
		add(passTF, 1, 3, 2, 1, 0.0, 0.0);
		add(accDrawMoneyLB, 3, 3, 1, 1, 0.0, 0.0);
		add(accDrawMoneyTF, 4, 3, 3, 1, 0.0, 0.0);
		
		add(accBrowLB, 0, 4, 1, 1, 0.0, 0.0);
		add(accBrowTF, 1, 4, 2, 1, 0.0, 0.0);
		add(accNew, 3, 4, 1, 1, 0.0, 0.0);
		add(accAllLookUp, 4, 4, 1 ,1, 0.0, 0.0);
		add(new Label(" "), 5, 4, 1, 1, 0.0, 0.0);
		
		add(accList, 0, 5, 1, 1, 0.0, 0.0);
		add(money, 6, 5, 1, 1, 0.0, 0.0);
		
	}
	
	// 그리드백 구성
	private void add(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty){
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth  = gridwidth;
		gridBagConstraints.gridheight  = gridheight;
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;
		gridBagLayout.setConstraints(component, gridBagConstraints);
		add(component);
	}
	
//	public static void main(String[] args) {
//		Frame frame = new Frame();
//		MainPanel mp = new MainPanel();
//		frame.add(mp);
//		frame.setSize(500, 400);
//		frame.setVisible(true);
//	}
}
