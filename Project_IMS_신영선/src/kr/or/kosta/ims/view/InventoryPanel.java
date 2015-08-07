package kr.or.kosta.ims.view;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import kr.or.kosta.ims.model.Builders;
import kr.or.kosta.ims.model.Instrument;
import kr.or.kosta.ims.model.InstrumentSpecification;
import kr.or.kosta.ims.model.Instruments;
import kr.or.kosta.ims.model.Inventory;
import kr.or.kosta.ims.model.Styles;
/**
 * 악기 재고 현황 패널
 * (- 조회, 검색 기능)
 * 
 * @author 신영선
 *
 */
public class InventoryPanel extends JPanel {
	
	JLabel kindLabel,serialLabel,builderLabel,modelLabel;
	JButton searchB, searchAllB, findB;
	
	JTextField serialTF, modelTF;
	JTable table;
	JComboBox<Instruments> kindCombo;
	JComboBox<Builders> builderCombo;
	JScrollPane JsP;
	
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	InstrumentModel model;
	
	MainFrame mainF;
	
	/** 생성자 */
	public InventoryPanel(MainFrame mF){
		
		mainF = mF;
	
		model = new InstrumentModel();
		kindLabel = new JLabel("악기종류");
		kindCombo = new JComboBox<Instruments>(Instruments.values());
		
		
		serialLabel = new JLabel("일련번호");
		serialTF = new JTextField();
		searchB = new JButton("조회");
		searchAllB = new JButton("전체조회");
		
		table = new JTable(model);
		
		JsP = new JScrollPane(table);
		JsP.setBorder(new TitledBorder("악기 재고 목록"));
		
		builderLabel = new JLabel("제조사");
		builderCombo = new JComboBox<Builders>(Builders.values());
		
		modelLabel = new JLabel("모델명");
		modelTF = new JTextField();
		findB = new JButton("검색");
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		setComponents();
		eventRegist();
		
		}
	
	/** 컴포넌트 배치 */
	public void setComponents(){
		
		setLayout(gridBagLayout);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.insets = new Insets(3, 3, 3, 3);
		
		add(kindLabel, 0, 0, 1, 1, 0.0, 0.0);		
		add(kindCombo, 1, 0, 1, 1, 0.0, 0.0);
		
		add(serialLabel,   0, 1, 1, 1, 0.0, 0.0);		
		add(serialTF,      1, 1, 1, 1, 0.1, 0.0);		
		add(searchB,       2, 1, 1, 1, 0.0, 0.0);
		add(new Label(""), 3, 1, 1, 1, 0.1, 0.0);		
		add(searchAllB,    4, 1, 1, 1, 0.0, 0.0);//
		
		add(JsP,    0, 2, 5, 3, 1.0, 1.0);
		
		add(builderLabel,    0, 5, 1, 1, 0.0, 0.0);	
		add(builderCombo,    1, 5, 1, 1, 0.0, 0.0);
		add(modelLabel,      2, 5, 1, 1, 0.0, 0.0);
		add(modelTF,         3, 5, 1, 1, 1.0, 0.0);
		add(findB,           4, 5, 1, 1, 0.0, 0.0);//
		
		
	}
	
	
	public void add(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty){		
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;
		gridBagLayout.setConstraints(component, gridBagConstraints);
		add(component);
	}
	
	/** 사용자 정의 메소드 */
	
	/**
	 * #1. 등록된 악기 목록 전체 조회해서 출력
	 */
	public void searchA(){
		List<Instrument> allList = mainF.ivt.searchAll();
		
		if(allList.size() != 0){ //if(allList != null) 
			model.print(allList);
		}else{					
			JOptionPane.showMessageDialog(this, "등록된 악기가 없습니다!","알림", JOptionPane.WARNING_MESSAGE);
		}
			
	}
	
	/**
	 * #2. 입력받은 시리얼번호와 같은 악기 조회해서 출력 
	 */
	public void serialSearch(){
		
		Instrument inst = mainF.ivt.getInstrument(serialTF.getText());
		if(inst != null){
		model.printA(inst);
		}else {
			JOptionPane.showMessageDialog(this, "조건에 맞는 악기가 없습니다!","알림", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	/**
	 * #3. 조건(제조사, 모델명)으로 검색된 모든 악기 조회해서 출력
	 */
	public void find(){

		List<Instrument> fList = mainF.ivt.search(new InstrumentSpecification((Builders)builderCombo.getSelectedItem(),(String)modelTF.getText()));
		
		if(fList != null){
			model.print(fList);
		}else{					
			JOptionPane.showMessageDialog(this, "조건에 맞는 악기가 없습니다!","알림", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	/** 이벤트 리스너 */
	public void eventRegist(){
		
		/**전체조회*/
		searchAllB.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				searchA();				
			}
		});
		
		
		/**시리얼번호로 조회*/		
		searchB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				serialSearch();
			}
		});
		
		/**조건으로 검색*/
		findB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				find();
			}
		});
	}

}
