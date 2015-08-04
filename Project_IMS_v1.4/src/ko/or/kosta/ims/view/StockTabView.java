package ko.or.kosta.ims.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import ko.or.kosta.ims.model.Inventory;
import ko.or.kosta.ims.model.Instrument;
import ko.or.kosta.ims.model.InstrumentSpecification;
import ko.or.kosta.ims.model.InstrumentSpecification.Builders;
import ko.or.kosta.ims.model.InstrumentSpecification.Instruments;
import ko.or.kosta.ims.model.InstrumentSpecification.specPropertie;

/**
 * 악기 재고 현황
 * @author Lee Gwangyong
 *
 */
public class StockTabView extends JPanel{

	JLabel instrumentsL;			 /** 악기종류 레이블 */
	JComboBox<String> instrumentsCB; /** 악기종류 콤보박스*/
	JLabel instrumentsListL;		 /** 악기종류 보여주기 레이블 */
	JLabel serialNumberL;		 	 /** 일련번호 레이블 */
	JTextField serialNumberTF;	 	 /** 일련번호 콤보박스*/
	JButton searchSerialBtn;		 /** 일련번호 조회 버튼*/
	JButton searchAllBtn;			 /** 전체 조회 버튼*/
	
	JLabel buildersL;				 /** 제 조 사 레이블 */
	JComboBox<String> buildersCB;    /** 제 조 사 콤보박스*/
	JLabel modelL;					 /** 모 델 명 레이블 */
	JTextField modelTF;				 /** 모 델 명 콤보박스*/
	JLabel priceL;				 	 /** 가 격 레이블 */
	JTextField priceTF;				 /** 가 격 콤보박스*/
	JButton searchBtn;				 /** 조건 검색 버튼*/

	GridBagConstraints gc;
	GridBagLayout gl;
	
	InstrumentTableModel instruModel; /** 악기 테이블 모델 */
	JTable instruTB;				  /** 악기 테이블 */
	
	Inventory inventory;			  /** 인벤토리 객체 */
	JScrollPane scrollP;			  /** 스크롤추가 */
	
	JPanel tableP;					  /** 테이블 패널 */
	TitledBorder titleB;

	
	
	public StockTabView(Inventory inventory){
		
		instrumentsL = new JLabel("악기종류");			
		instrumentsCB = new JComboBox<String>();
		instrumentsListL = new JLabel("(악기 종류 보여주기...)");
		serialNumberL = new JLabel("일련번호");	
		serialNumberTF = new JTextField();
		searchSerialBtn = new JButton("조 회");
		searchAllBtn = new JButton("전체조회");
		
		buildersL = new JLabel("제조사");
		buildersCB = new JComboBox<String>();    
		modelL = new JLabel("모델명");
		modelTF = new JTextField();			 
		priceL = new JLabel("가 격");
		priceTF = new JTextField();
		searchBtn = new JButton("검 색");

		gc = new GridBagConstraints();
		gl = new GridBagLayout();
		
		instruModel = new InstrumentTableModel();
		instruTB = new JTable(instruModel);
		
		titleB = new TitledBorder("악기재고목록");
		
		this.inventory = inventory;
		

		scrollP = new JScrollPane(instruTB);
		scrollP.setBorder(new TitledBorder("악기재고목록"));
		tableP = new JPanel();
		

		setComponents();
		printAllinstrument();
	}
	
	public void setComponents(){
		
		// enum 값을 String 배열로 가져와서 셋팅
		Instruments[] instruments = Instruments.values();
		for (Instruments string : instruments) {
			instrumentsCB.addItem(string.toString());
		}

		String[] array = new String[instruments.length];
		StringBuffer temp = new StringBuffer();
		temp.append('(');
		for (int i = 0; i < instruments.length; i++) {
			temp.append(instruments[i].toString());
			if(i < instruments.length -1 ) temp.append(',');
		}
		temp.append(')');
		instrumentsListL.setText(temp.toString());

		Builders[] Builder = Builders.values();
		for (Builders string : Builder) {
			buildersCB.addItem(string.toString());
		}
		//-------------------------------------------------------
		tableP.setLayout(new BorderLayout());
		tableP.add(scrollP);

		//--------------------------------------------------------
		// 화면 그리기 시작
		//--------------------------------------------------------
		setLayout(gl);
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.insets = new Insets(3,10,3,10);
		//--------------------------------------------------------
		// 악기종류, 악기종류 출력
		//--------------------------------------------------------
		addGrid(gl, gc, instrumentsL, 		0, 0, 1, 1, 0.0, 0.0);
		addGrid(gl, gc, instrumentsCB	, 	1, 0, 1, 1, 0.0, 0.0);
		addGrid(gl, gc, instrumentsListL,	2, 0, 1, 1, 0.0, 0.0);
		//--------------------------------------------------------
		// 일련번호, 조회, 전체조회
		//--------------------------------------------------------
		addGrid(gl, gc, serialNumberL, 		0, 1, 1, 1, 0.0, 0.0);
		addGrid(gl, gc, serialNumberTF	, 	1, 1, 1, 1, 0.0, 0.0);
		addGrid(gl, gc, searchSerialBtn,	2, 1, 1, 1, 0.0, 0.0);
		addGrid(gl, gc, searchAllBtn,	  	3, 1, 1, 1, 0.0, 0.0);
		//--------------------------------------------------------
		// 일련번호, 조회, 전체조회
		//--------------------------------------------------------
		addGrid(gl, gc, tableP,	  			0, 2, 6, 3, 0.0, 0.0);
		//--------------------------------------------------------
		// 제조사, 모델명, 가격, 검색
		//--------------------------------------------------------
		addGrid(gl, gc, buildersL, 			0, 5, 1, 1, 0.0, 0.0);
		addGrid(gl, gc, buildersCB	,	 	1, 5, 1, 1, 0.0, 0.0);
		addGrid(gl, gc, modelL, 			2, 5, 1, 1, 0.0, 0.0);
		addGrid(gl, gc, modelTF,		 	3, 5, 1, 1, 0.0, 0.0);
		addGrid(gl, gc, searchBtn, 			4, 5, 1, 1, 0.0, 0.0);
		
	}
	

	/**
	 * 그리드 추가 메서드
	 * @param gbl
	 * @param gbc
	 * @param c
	 * @param gridx
	 * @param gridy
	 * @param gridwidth
	 * @param gridheight
	 * @param weightx
	 * @param weighty
	 */
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
	
	public void eventRegist(){
		searchSerialBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				printInstrument(serialNumberTF.getText());
			}
		});
		
		searchAllBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				printAllinstrument();
			}
		});
		
		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				printSearchInstrument(buildersCB.getSelectedItem(), modelTF.getText());
			}
		});
	}
	
	/**
	 * 전체 악기 리스트 보여주기
	 */
	private void printAllinstrument(){
		System.out.println("inventory.searchAll() : " + inventory.searchAll());
		instruModel.resultInstrumentsList(inventory.searchAll());
	}
	
	/**
	 * 일련번호로 악기 조회하기
	 */
	private void printInstrument(String serialNumber){
		instruModel.resultInstruments(inventory.get(serialNumber)); ;
	}
	
	/**
	 * 조건으로 검색하기
	 */
	
	private void printSearchInstrument(Object builder, String model){
		InstrumentSpecification spec = new InstrumentSpecification();
		if (builder != "" || builder != null) {
			spec.setProperty(specPropertie.BUILDERS, stringToBuilders(builder));
		}
		if (!model.isEmpty()) {
			spec.setProperty(specPropertie.MODEL, model);
		}
		instruModel.resultInstrumentsList(inventory.search(spec));
	}
	
	/**
	 * String 을 Builders 타입으로 바꿔주기
	 * @param builder
	 * @return
	 */
	private Builders stringToBuilders(Object builder){
//		FENDER, MARTIN, GIBSON, COLLINGS, OLSON, SAMIC
		Builders result = null;
		switch (builder.toString()) {
			case "FENDER": result = Builders.FENDER; break;
			case "MARTIN": result = Builders.MARTIN; break;
			case "GIBSON": result = Builders.GIBSON; break;
			case "COLLINGS": result = Builders.COLLINGS; break;
			case "OLSON": result = Builders.OLSON; break;
			case "SAMIC": result = Builders.SAMIC; break;
		}
		
		return result;
	}
}





