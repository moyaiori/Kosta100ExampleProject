package kr.or.kosta.ims.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
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
import kr.or.kosta.ims.util.Validate;

/**
 * 악기 재고 현황을 보여줄 패널
 * @author 손진영
 *
 * 작성일 : 2015-08-03
 */
public class InstrumentPanel extends JPanel {
	/** 악기재고현황 컴포넌트 속성 */
	JLabel kindL, serialL, builderL, modelL;
	JTextField serialTF, modelTF;
	JComboBox kindCB, builderCB;
	JButton searchB, serialB, allB;

	/** 테이블을 위한 컴포넌트와 모델 */
	JPanel tableP;
	JTable table;
	InstrumentTableModel model;
	
	/** 레이아웃 속성 */
	GridBagLayout grid;
	GridBagConstraints constraints;
	
	/** 데이터 관리는 위한 속성 */
	Inventory manager;
	
	/** 생성자 */
	public InstrumentPanel(Inventory manager){
		kindL = new JLabel("악기종류");
		kindCB = new JComboBox();
		
		serialL = new JLabel("일련번호");
		serialTF = new JTextField();
		
		serialB = new JButton("조회");
		allB = new JButton("전체 조회");
		
		builderL = new JLabel("제조사", JLabel.RIGHT);
		builderCB = new JComboBox(Builders.values());
		
		modelL = new JLabel("모델명", JLabel.RIGHT);
		modelTF = new JTextField();
		
		tableP = new JPanel();
		model = new InstrumentTableModel();
		table = new JTable(model);
		
		searchB = new JButton("검색");
		
		grid = new GridBagLayout();
		constraints = new GridBagConstraints();
		
		this.manager = manager;
		
		setComponents();
		eventRegist();
	}
	
	/** 패널에 화면 구성 */
	public void setComponents(){
		setLayout(grid);
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(5, 5, 5, 5);
		
		add(kindL,  0, 0, 1, 1, 0.0, 0.0);
		add(kindCB, 1, 0, 1, 1, 0.5, 0.0);

		add(serialL,         0, 1, 1, 1, 0.0, 0.0);
		add(serialTF,        1, 1, 1, 1, 0.0, 0.0);
		add(serialB,         2, 1, 1, 1, 0.0, 0.0);
		add(new JLabel(" "), 3, 1, 2, 1, 1.0, 0.0);
		add(allB,            5, 1, 1, 1, 0.0, 0.0);
		
		add(tableP, 0, 2, 6, 1, 1.0, 1.0);

		add(builderL,        0, 3, 1, 1, 0.0, 0.0);
		add(builderCB,       1, 3, 1, 1, 0.0, 0.0);
		add(modelL,          2, 3, 1, 1, 0.0, 0.0);
		add(modelTF,         3, 3, 1, 1, 1.0, 0.0);
		add(new JLabel(" "), 4, 3, 1, 1, 1.0, 0.0);
		add(searchB,         5, 3, 1, 1, 0.0, 0.0);
		
		/** 콤보박스 데이터 */
		kindCB.addItem("전체");
		for (Instruments instrument : Instruments.values()) {
			kindCB.addItem(instrument);
		}
		
		/** 테이블 주변 테두리 삽입 */
		tableP.setLayout(new BorderLayout());
		tableP.setBorder(new TitledBorder("악기 재고 목록"));
		tableP.add(new JScrollPane(table));
	}
	
	/** GridBagLayout에 컴포넌트 추가 */
	public void add(JComponent comp, int x, int y, int w, int h, double wx, double wy){
		constraints.weightx = wx;
		constraints.weighty = wy;
		
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.gridwidth = w;
		constraints.gridheight = h;
		
		grid.setConstraints(comp, constraints);
		add(comp);
	}
	
	/** 이벤트 처리 */
	public void eventRegist(){
		/** 조회 버튼 클릭시 이벤트 처리 */
		serialB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getInstrument();
			}
		});
		/** 검색 버튼 클릭시 이벤트 처리 */
		searchB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchInstruments();
			}
		});
		/** 전체 조회 클릭시 이벤트 처리 */
		allB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				allInstruments();
			}
		});
	}
	
	/** 일련번호로 악기 조회 */
	public void getInstrument(){
		String serialNum = serialTF.getText();
		/** 일련번호를 입력하지 않은 경우 */
		if (Validate.isNull(serialNum)) {
			showErrorMessage("조회 실패", "일련번호를 입력해주세요");
			return;
		}
		/** 일련번호로 조회 */
		Instrument getInstrument = manager.get(serialNum);
		if(getInstrument == null){
			showErrorMessage("조회 실패", "일련번호가 존재하지 않습니다.");
			return;
		}
		showMessage("조회 성공", serialNum + " 번호로 조회되었습니다.");
		/** 모델에게 보여줄 악기 보냄 */
		model.serialList(getInstrument);
	}
	
	/** 특정 조건으로 악기 검색 */
	public void searchInstruments(){
		Builders builder = (Builders) builderCB.getSelectedItem();
		String modelName = modelTF.getText();
		
		/** 검색할 명세에 속성 제조사와 모델명 저장 */
		InstrumentSpecification spec = new InstrumentSpecification();
		spec.setProperty("builder", builder);
		spec.setProperty("model", modelName);
		
		/** 특정 조건으로 저장된 데이터에서 검색 */
		List<Instrument> searchList = manager.search(spec);
		if(searchList == null){
			showErrorMessage("검색 실패", "존재하는 내용이 없습니다.");
			return;
		}
		showMessage("검색 성공", "총 " + searchList.size() + " 건의 결과가 존재합니다.");
		model.searchList(searchList);
	}
	
	/** 전체 조회 */
	public void allInstruments(){
		/** 전체 조회시 내용 저장할 임시 리스트 */
		List<Instrument> allList = new ArrayList();
		/** 등록된 악기가 없는 경우 */
		if(manager.searchAll() == null){  
			showErrorMessage("전체조회 실패", "등록되어 있는 악기가 없습니다.");
			return;
		}
		for (Instrument instrument : manager.searchAll()) {
			/** 전체가 선택되었을 경우 */
			if(kindCB.getSelectedIndex() == 0){
				allList.addAll(manager.searchAll());
				break;
			}
			/** 악기 종류에 따라 조회되게함 */
			if(instrument.getName() == kindCB.getSelectedItem()){
				allList.add(instrument);
			}
		}
		showMessage("전체 조회 성공", allList.size() + "개의 악기가 검색되었습니다.");
		model.searchList(allList);
	}
	
	/** 성공 메시지 창 띄우기 */
	public void showMessage(String title, String message){
		JOptionPane.showMessageDialog(this, message, title, JOptionPane.PLAIN_MESSAGE);
	}
	
	/** 에러 메시지 창 띄우기 */
	public void showErrorMessage(String title, String message){
		JOptionPane.showMessageDialog(this, message, title, JOptionPane.WARNING_MESSAGE);
	}
	
}
