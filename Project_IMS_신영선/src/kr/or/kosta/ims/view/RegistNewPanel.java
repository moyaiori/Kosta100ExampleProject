package kr.or.kosta.ims.view;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import kr.or.kosta.ims.model.Builders;
import kr.or.kosta.ims.model.Instrument;
import kr.or.kosta.ims.model.InstrumentSpecification;
import kr.or.kosta.ims.model.Instruments;
import kr.or.kosta.ims.model.Styles;
import kr.or.kosta.ims.model.Types;
import kr.or.kosta.ims.model.Woods;
/**
 * 신규 악기 등록 기능을 가진 패널
 * 
 * @author 신영선
 */

public class RegistNewPanel extends JPanel {
	
	InstrumentSpecification instSpec;	
	
	JLabel kindLabel, builderLabel, serialLabel, modelLabel, priceLabel, typeLabel, fWoodLabel, bWoodLabel, styleLabel;
	JComboBox<Instruments> instruments;
	JComboBox<Builders> builders;
	JComboBox<Types> types;
	JComboBox<Woods> fWoods;
	JComboBox<Woods> bWoods;
	JComboBox<Styles> styles;
	
	JTextField serialTF, modelTF, priceTF;
	JButton registB, cancleB;
	
	
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	MainFrame main;
	
	public RegistNewPanel(MainFrame mF){
		
		main = mF; 
		
		kindLabel = new JLabel("악기종류");
		instruments = new JComboBox<Instruments>(Instruments.values());
		builderLabel = new JLabel("제조사");
		builders = new JComboBox<Builders>(Builders.values());
		
		serialLabel = new JLabel("일련번호");
		serialTF = new JTextField();
		modelLabel = new JLabel("모델명");
		modelTF = new JTextField();
		
		priceLabel = new JLabel("가격");
		priceTF = new JTextField();
		typeLabel = new JLabel("유형");
		types = new JComboBox<Types>(Types.values());
		
		fWoodLabel = new JLabel("재질(앞)");
		fWoods = new JComboBox<Woods>(Woods.values());
		bWoodLabel = new JLabel("재질(뒤)");
		bWoods = new JComboBox<Woods>(Woods.values());
		
		styleLabel = new JLabel("스타일");
		styles = new JComboBox<Styles>(Styles.values());
		
		registB = new JButton("등록");
		cancleB = new JButton("취소");
		
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		setComponents();
		eventRegist();
		
	}
	
	public void setComponents(){
		setLayout(gridBagLayout);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.insets = new Insets(3, 3, 3, 3);
		
		add(kindLabel,    0, 0, 1, 1, 0.0, 0.0);
		add(instruments,  1, 0, 1, 1, 0.0, 0.0);
		add(builderLabel, 2, 0, 1, 1, 0.0, 0.0);
		add(builders,     3, 0, 1, 1, 0.0, 0.0);
		
		add(serialLabel, 0, 1, 1, 1, 0.0, 0.0);
		add(serialTF,    1, 1, 1, 1, 0.0, 0.0);
		add(modelLabel,  2, 1, 1, 1, 0.0, 0.0);
		add(modelTF,     3, 1, 1, 1, 0.0, 0.0);
		
		add(priceLabel, 0, 2, 1, 1, 0.0, 0.0);
		add(priceTF,    1, 2, 1, 1, 0.0, 0.0);
		add(typeLabel,  2, 2, 1, 1, 0.0, 0.0);
		add(types,      3, 2, 1, 1, 0.0, 0.0);
		
		add(fWoodLabel,  0, 3, 1, 1, 0.0, 0.0);
		add(fWoods,      1, 3, 1, 1, 0.0, 0.0);
		add(bWoodLabel,  2, 3, 1, 1, 0.0, 0.0);
		add(bWoods,      3, 3, 1, 1, 0.0, 0.0);
		
		add(styleLabel,  0, 4, 1, 1, 0.0, 0.0);		
		add(styles,      1, 4, 1, 1, 0.0, 0.0);	
		
		add(registB,     1, 5, 1, 1, 0.0, 0.0);		
		add(cancleB,     2, 5, 1, 1, 0.0, 0.0);		
		
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

	

	/**  사용자 정의 메소드 */
	
	/** 
	 * #1.초이스 선택 
	 * - 기타  : 스타일 비활성화, 유형 활성화
	 * -만돌린 : 스타일 활성화, 유형 비활성화
	 */
	public void selectInstrument(){
		if(instruments.getSelectedIndex() == 0){
			styles.setEnabled(false);
			types.setEnabled(true);
		}else if(instruments.getSelectedIndex() == 1){
			types.setEnabled(false);
			styles.setEnabled(true);
		}		
	}
	
	/** 
	 * #2.신규 악기 등록 메소드 
	 * - 각 컴포넌트에서 입력받은 값을 가지고 신규 악기 등록
	 * 
	 * Spec 순서 : 제조사, 모델, 타입(기타), 재질(앞), 재질(뒤), 스타일(만돌린의경우)
	 */
	public void regist(){
		
		if(instruments.getSelectedIndex() == 0){
			/**기타 선택시*/
			instSpec 
			= new InstrumentSpecification((Builders) builders.getSelectedItem(), modelTF.getText(), (Types)types.getSelectedItem(), (Woods)fWoods.getSelectedItem(), (Woods)bWoods.getSelectedItem());
			
			
			main.ivt.add(new Instrument((Instruments)instruments.getSelectedItem(), serialTF.getText(), Double.parseDouble(priceTF.getText()), instSpec));
			JOptionPane.showMessageDialog(this, "신규 기타 등록 완료!","알림", JOptionPane.OK_OPTION);
			clear();
		}else{
			/**만돌린 선택시*/
			instSpec 
			= new InstrumentSpecification((Builders) builders.getSelectedItem(), modelTF.getText(), (Styles)styles.getSelectedItem(), (Woods)fWoods.getSelectedItem(), (Woods)bWoods.getSelectedItem());
			
			main.ivt.add(new Instrument((Instruments)instruments.getSelectedItem(), serialTF.getText(), Double.parseDouble(priceTF.getText()), instSpec));
			JOptionPane.showMessageDialog(this, "신규 만돌린 등록 완료!","알림", JOptionPane.OK_OPTION);
			clear();
		}
		
	}
	/**
	 * #3. 컴포넌트에 입력되어져있는 값들 모두 비우기
	 */
	public void clear(){
		instruments.setSelectedIndex(0);
		builders.setSelectedIndex(0);
		serialTF.setText("");
		modelTF.setText("");
		priceTF.setText("");
		fWoods.setSelectedIndex(0);
		bWoods.setSelectedIndex(0);
	}
 
	
	/** 이벤트 등록  */
	public void eventRegist(){
		
		/**  악기 콤보박스에서 악기 선택시 */ 
		instruments.addItemListener(new ItemListener() {			
			@Override
			public void itemStateChanged(ItemEvent e) {
				selectInstrument();
				
			}
		});
		
		/**  등록 버튼 눌렀을 때 */
		registB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				regist();
			}
		});
		
		/** 취소 버튼 눌렀을 때*/
		cancleB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clear();
				
			}
		});

	}
	

}
