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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import kr.or.kosta.ams.model.AccountManager;

/**
 * 상단의 
 * @author Lee Gwangyong
 *
 */
public class MainPanel extends Panel {
	JLabel accKindLB, accNumLB, accOwnrLB, passLB, accDrawMoneyLB ,accBrowLB;
	JTextField accNumTF, accOwnrTF, passTF, accDrawMoneyTF, accBrowTF;
	JButton accLookUp, accDelete,  accSearch, accNew, accAllLookUp;
	JComboBox<String> accKindC;
	JLabel accList, money;
	
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	
	public MainPanel(){
		accKindLB = new JLabel("계좌종류");
		accNumLB = new JLabel("계좌번호");
		accOwnrLB = new JLabel("예금주명");
		passLB = new JLabel("비밀번호");
		accDrawMoneyLB = new JLabel("입금금액");
		accBrowLB = new JLabel("대출금액");
		
		accNumTF = new JTextField();
		accOwnrTF = new JTextField();
		passTF = new JTextField();
		accDrawMoneyTF = new JTextField();
		accBrowTF = new JTextField();
		
		accLookUp = new JButton("조 회");
		accDelete = new JButton("삭 제");
		accSearch = new JButton("검 색");
		accNew = new JButton("신규등록");
		accAllLookUp = new JButton("전체조회");
		
		accKindC = new JComboBox<String>();
		accKindC.addItem("전체");
		accKindC.addItem("입출금계좌");
		accKindC.addItem("마이너스계좌");
		
		accList = new JLabel("계좌목록");
		money = new JLabel("(단위 : 원)");
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		
		setComponents();
	}
	
	
	
	/**
	 * 화면 구성
	 */
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
	
	/**
	 * 그리드 백 구성
	 * @param component
	 * @param gridx
	 * @param gridy
	 * @param gridwidth
	 * @param gridheight
	 * @param weightx
	 * @param weighty
	 */
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
