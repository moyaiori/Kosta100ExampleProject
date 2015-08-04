package ko.or.kosta.ims.view;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ko.or.kosta.ims.model.Instrument;
import ko.or.kosta.ims.model.InstrumentSpecification;
import ko.or.kosta.ims.model.InstrumentSpecification.Builders;
import ko.or.kosta.ims.model.InstrumentSpecification.Instruments;
import ko.or.kosta.ims.model.InstrumentSpecification.Style;
import ko.or.kosta.ims.model.InstrumentSpecification.Types;
import ko.or.kosta.ims.model.InstrumentSpecification.Woods;
import ko.or.kosta.ims.model.InstrumentSpecification.specPropertie;
import ko.or.kosta.ims.model.Inventory;

/**
 * 신규 악기 등록
 * @author Lee Gwangyong
 *
 */
public class NewTabView extends JPanel{

	JLabel instrumentsL;			 /** 악기종류 레이블 */
	JComboBox<Instruments> instrumentsCB; /** 악기종류 콤보박스*/
	JLabel buildersL;				 /** 제 조 사 레이블 */
	JComboBox<Builders> buildersCB;  /** 제 조 사 콤보박스*/
	JLabel serialNumberL;		 	 /** 일련번호 레이블 */
	JTextField serialNumberTF;	 	 /** 일련번호 콤보박스*/
	JLabel modelL;					 /** 모 델 명 레이블 */
	JTextField modelTF;				 /** 모 델 명 콤보박스*/
	JLabel priceL;				 	 /** 가 격 레이블 */
	JTextField priceTF;				 /** 가 격 콤보박스*/
	JLabel typesL;				 	 /** 유 형 레이블 */
	JComboBox<Types> typesCB;		 /** 유 형 콤보박스*/
	JLabel topWoodL;				 /** 재질(앞) 레이블 */
	JComboBox<Woods> topWoodCB;	 /** 재질(앞) 콤보박스*/
	JLabel backWoodL;				 /** 재질(뒤) 레이블 */
	JComboBox<Woods> backWoodCB;	 /** 재질(뒤) 콤보박스*/
	JLabel styleL;				 	 /** 스 타 일 레이블 */
	JComboBox<Style> styleCB;		 /** 스 타 일 콤보박스*/
	JButton registBtn;				 /** 등 록 버튼*/
	JButton cancelBtn;				 /** 취 소 버튼*/
	

	GridBagConstraints gc;
	GridBagLayout gl;
	
	Inventory inventory;
	
	
	public NewTabView(Inventory inventory){
		instrumentsL = new JLabel("악기종류");
		instrumentsCB = new JComboBox<Instruments>();
		buildersL = new JLabel("제 조 사");
		buildersCB = new JComboBox<Builders>();
		serialNumberL = new JLabel("일련번호");
		serialNumberTF = new JTextField();
		modelL = new JLabel("모 델 명");
		modelTF = new JTextField();
		priceL = new JLabel("가 격");
		priceTF = new JTextField();
		typesL = new JLabel("유 형");
		typesCB = new JComboBox<Types>();
		topWoodL = new JLabel("재질(앞)");
		topWoodCB = new JComboBox<Woods>();
		backWoodL = new JLabel("재질(뒤)");
		backWoodCB = new JComboBox<Woods>();
		styleL = new JLabel("스 타 일");
		styleCB = new JComboBox<Style>();
		registBtn = new JButton("등 록");
		cancelBtn = new JButton("취 소");

		gc = new GridBagConstraints();
		gl = new GridBagLayout();
		
		this.inventory = inventory;

		setComponents();
		eventRegist();
	}
	
	public void setComponents(){
		
		// 종류
		Instruments[] instrument = Instruments.values();
		for (Instruments value : instrument) {
			instrumentsCB.addItem(value);
		}

		// 제조사
		Builders[] Builder = Builders.values();
		for (Builders value : Builder) {
			buildersCB.addItem(value);
		}

		// 유형
		Types[] Type = Types.values();
		for (Types value : Type) {
			typesCB.addItem(value);
		}

		// 나무 재질, 앞, 뒤
		Woods[] Wood = Woods.values();
		for (Woods value : Wood) {
			topWoodCB.addItem(value);
			backWoodCB.addItem(value);
		}

		// 스타일(만돌린만)
		Style[] StyleValue = Style.values();
		for (Style value : StyleValue) {
			styleCB.addItem(value);
		}
		
		setLayout(gl);
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.insets = new Insets(3,10,3,10);

		//--------------------------------------------------------
		// 악기종류, 제조사
		//--------------------------------------------------------
		addGrid(gl, gc, new JLabel(" "), 	0, 0, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, instrumentsL, 		1, 0, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, instrumentsCB	, 	3, 0, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, new JLabel(" "), 	4, 0, 1, 1, 0.2, 0.0);
		addGrid(gl, gc, buildersL,		 	5, 0, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, buildersCB, 		7, 0, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, new JLabel(" "), 	8, 0, 1, 1, 0.1, 0.0);
		
		//--------------------------------------------------------
		// 일련번호, 모델명
		//--------------------------------------------------------
		addGrid(gl, gc, new JLabel(" "), 	0, 1, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, serialNumberL, 		1, 1, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, serialNumberTF	, 	3, 1, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, new JLabel(" "), 	4, 1, 1, 1, 0.2, 0.0);
		addGrid(gl, gc, modelL,		 		5, 1, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, modelTF, 			7, 1, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, new JLabel(" "), 	8, 1, 1, 1, 0.1, 0.0);
		
		//--------------------------------------------------------
		// 가격, 유형
		//--------------------------------------------------------
		addGrid(gl, gc, new JLabel(" "), 	0, 2, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, priceL, 			1, 2, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, priceTF	,	 		3, 2, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, new JLabel(" "), 	4, 2, 1, 1, 0.2, 0.0);
		addGrid(gl, gc, typesL,		 		5, 2, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, typesCB,		 	7, 2, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, new JLabel(" "), 	8, 2, 1, 1, 0.1, 0.0);
		
		//--------------------------------------------------------
		// 재질 앞, 뒤
		//--------------------------------------------------------
		addGrid(gl, gc, new JLabel(" "), 	0, 3, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, topWoodL, 			1, 3, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, topWoodCB	,	 	3, 3, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, new JLabel(" "), 	4, 3, 1, 1, 0.2, 0.0);
		addGrid(gl, gc, backWoodL,		 	5, 3, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, backWoodCB, 		7, 3, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, new JLabel(" "), 	8, 3, 1, 1, 0.1, 0.0);
		
		//--------------------------------------------------------
		// 스타일
		//--------------------------------------------------------
		addGrid(gl, gc, new JLabel(" "), 	0, 4, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, styleL, 			1, 4, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, styleCB	,		 	3, 4, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, new JLabel(" "), 	4, 4, 1, 1, 0.2, 0.0);
		addGrid(gl, gc, new JLabel(" "),	5, 4, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, new JLabel(" "), 	7, 4, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, new JLabel(" "), 	8, 4, 1, 1, 0.1, 0.0);
		
		//--------------------------------------------------------
		// 등록, 취소
		//--------------------------------------------------------
		addGrid(gl, gc, new JLabel(" "), 	0, 5, 9, 1, 0.1, 0.0);
		
		addGrid(gl, gc, new JLabel(" "), 	0, 6, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, new JLabel(" "), 	1, 6, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, new JLabel(" "), 	2, 6, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, registBtn	,		3, 6, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, new JLabel(" "), 	4, 6, 1, 1, 0.2, 0.0);
		addGrid(gl, gc, cancelBtn,			5, 6, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, new JLabel(" "), 	6, 6, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, new JLabel(" "), 	7, 6, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, new JLabel(" "), 	8, 6, 1, 1, 0.1, 0.0);
		
	}
	
	private void addGrid(GridBagLayout gbl, GridBagConstraints gbc, Component c, int gridx, int gridy, int gridwidth,
			int gridheight, double weightx, double weighty) {
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.gridwidth = gridwidth;
		gbc.gridheight = gridheight;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbl.setConstraints(c, gbc);
		add(c);
	}
	
	/**
	 * 
	 */
	private void addInstrument(){
		InstrumentSpecification spec = new InstrumentSpecification();
		
//		System.out.println((Instruments)instrumentsCB.getSelectedItem());
//		System.out.println(instrumentsCB.getSelectedItem().toString());
//		System.out.println(Instruments.valueOf("GUITAR"));
		// 여기까지
		
		double temp = 0.0;
		temp = Double.parseDouble(priceTF.getText());
		
		spec.setProperty(specPropertie.BUILDERS ,buildersCB.getSelectedItem());
		spec.setProperty(specPropertie.TYPE ,typesCB.getSelectedItem());
		spec.setProperty(specPropertie.TOPWOOD ,topWoodCB.getSelectedItem());
		spec.setProperty(specPropertie.BACKWOOD ,backWoodCB.getSelectedItem());
		spec.setProperty(specPropertie.MODEL ,modelTF.getText());
		inventory.add((Instruments)instrumentsCB.getSelectedItem(),serialNumberTF.getText(), temp, spec);
		
		System.out.println(spec);

		
//		spec.setProperty(specPropertie.TYPE ,typesCB.getSelectedItem());
//		spec.setProperty(specPropertie.TOPWOOD ,topWoodCB.getSelectedItem());
//		spec.setProperty(specPropertie.BACKWOOD ,backWoodCB.getSelectedItem());
//		spec.setProperty(specPropertie.MODEL ,"AAAA");
//		inventory.add(Instruments.valueOf(instrumentsCB.getSelectedItem().toString()) , serialNumberTF.getText(), priceTF.getText(), spec));
		
	}
	
	public void eventRegist(){
		registBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("야호");
				addInstrument();
			}
		});
	}

}




















