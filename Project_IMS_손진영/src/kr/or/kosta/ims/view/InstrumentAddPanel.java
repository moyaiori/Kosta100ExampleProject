package kr.or.kosta.ims.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kr.or.kosta.ims.model.Builders;
import kr.or.kosta.ims.model.InstrumentSpecification;
import kr.or.kosta.ims.model.Instruments;
import kr.or.kosta.ims.model.Inventory;
import kr.or.kosta.ims.model.Styles;
import kr.or.kosta.ims.model.Types;
import kr.or.kosta.ims.model.Woods;
import kr.or.kosta.ims.util.Validate;

/**
 * 신규 악기 등록 패널
 * 
 * @author 손진영
 *
 *         작성일 : 2015-08-03
 */
public class InstrumentAddPanel extends JPanel {
	/** 컴포넌트 속성 */
	JLabel kindL, builderL, serialL, modelL, priceL, typeL, topL, backL, styleL;
	JTextField serialTF, modelTF, priceTF;
	JComboBox kindCB, builderCB, typeCB, topCB, backCB, styleCB;
	JButton addB, cancelB;
	JPanel buttonP;

	/** 레이아웃 속성 */
	GridBagLayout grid;
	GridBagConstraints constraints;

	/** 데이터를 저장할 인벤토리 속성 */
	Inventory manager;

	/** 생성자 */
	public InstrumentAddPanel(Inventory manager) {
		kindL = new JLabel("*악기종류", JLabel.RIGHT);
		kindCB = new JComboBox(Instruments.values());

		builderL = new JLabel("제조사", JLabel.RIGHT);
		builderCB = new JComboBox(Builders.values());

		serialL = new JLabel("*일련번호", JLabel.RIGHT);
		serialTF = new JTextField();

		modelL = new JLabel("모델명", JLabel.RIGHT);
		modelTF = new JTextField();

		priceL = new JLabel("*가격", JLabel.RIGHT);
		priceTF = new JTextField();

		typeL = new JLabel("유형", JLabel.RIGHT);
		typeCB = new JComboBox(Types.values());

		topL = new JLabel("재질(앞)", JLabel.RIGHT);
		topCB = new JComboBox(Woods.values());

		backL = new JLabel("재질(뒤)", JLabel.RIGHT);
		backCB = new JComboBox(Woods.values());

		styleL = new JLabel("스타일", JLabel.RIGHT);
		styleCB = new JComboBox(Styles.values());

		buttonP = new JPanel();
		addB = new JButton("등록");
		cancelB = new JButton("취소");

		grid = new GridBagLayout();
		constraints = new GridBagConstraints();

		this.manager = manager;
		styleCB.setEnabled(false);

		setComponents();
	}

	/** 패널에 화면 배치 */
	public void setComponents() {
		setLayout(grid);
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(5, 5, 5, 5);
		add(new JLabel(" "), 0, 0, 1, 1, 0.1, 0.0);
		add(kindL,           1, 0, 1, 1, 0.0, 0.0);
		add(kindCB,          2, 0, 1, 1, 0.3, 0.0);
		add(new JLabel(" "), 3, 0, 1, 1, 0.1, 0.0);
		add(builderL,        4, 0, 1, 1, 0.0, 0.0);
		add(builderCB,       5, 0, 1, 1, 0.3, 0.0);
		add(new JLabel(" "), 6, 0, 1, 1, 0.1, 0.0);

		add(serialL,  1, 1, 1, 1, 0.0, 0.0);
		add(serialTF, 2, 1, 1, 1, 0.0, 0.0);
		add(modelL,   4, 1, 1, 1, 0.0, 0.0);
		add(modelTF,  5, 1, 1, 1, 0.0, 0.0);

		add(priceL,  1, 2, 1, 1, 0.0, 0.0);
		add(priceTF, 2, 2, 1, 1, 0.0, 0.0);
		add(typeL,   4, 2, 1, 1, 0.0, 0.0);
		add(typeCB,  5, 2, 1, 1, 0.0, 0.0);

		add(topL,   1, 3, 1, 1, 0.0, 0.0);
		add(topCB,  2, 3, 1, 1, 0.0, 0.0);
		add(backL,  4, 3, 1, 1, 0.0, 0.0);
		add(backCB, 5, 3, 1, 1, 0.0, 0.0);

		add(styleL,  1, 4, 1, 1, 0.0, 0.0);
		add(styleCB, 2, 4, 1, 1, 0.0, 0.0);

		buttonP.add(addB);
		buttonP.add(cancelB);
		add(buttonP, 0, 6, 6, 1, 0.0, 0.0);
		add(new JLabel("* 표시는 반드시 입력하여 주세요.",JLabel.CENTER), 0, 5, 6, 1, 1.0, 0.0);

		eventRegist();
	}

	/** 패널에 컴포넌트 부착 */
	public void add(JComponent comp, int x, int y, int w, int h, double wx, double wy) {
		/** 가중치 */
		constraints.weightx = wx;
		constraints.weighty = wy;

		/** 위치 및 크기 */
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.gridwidth = w;
		constraints.gridheight = h;

		grid.setConstraints(comp, constraints);
		add(comp);
	}

	/** 이벤트 처리 */
	public void eventRegist() {
		/** 등록버튼 클릭시 이벤트 처리 */
		addB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addInstrument();
			}
		});
		
		/** 취소버튼 클릭시 이벤트 처리 */
		cancelB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showMessage("입력 취소", "입력사항이 없어집니다.");
				Validate.initInformation(kindCB.getParent());
			}
		});
		
		/** 악기종류가 변경될 때 활성화 유무 */
		kindCB.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				checkKind();
			}
		});
	}

	/** 등록 버튼을 눌렀을 때 악기 정보 저장 */
	public void addInstrument() {
		/** 각 컴포넌트에서 데이터를 가져옴 */
		Instruments name = (Instruments) kindCB.getSelectedItem();
		String serialNum = serialTF.getText();
		String getPrice = priceTF.getText();
		Builders builder = (Builders) builderCB.getSelectedItem();
		String model = modelTF.getText();
		Woods top = (Woods) topCB.getSelectedItem();
		Woods back = (Woods) backCB.getSelectedItem();
		Types type = (Types) typeCB.getSelectedItem();
		Styles style = (Styles) styleCB.getSelectedItem();

		/** 명세에 속성 추가 */
		InstrumentSpecification spec = new InstrumentSpecification();
		spec.setProperty("builder", builder);
		spec.setProperty("model", model);
		if (type == null) {
			spec.setProperty("style", style);
		} else if (style == null) {
			spec.setProperty("type", type);
		}
		spec.setProperty("top", top);
		spec.setProperty("back", back);

		/** Instrument에 있는 속성들을 입력하지 않으면 저장 실패 */
		if (Validate.isNull(name.toString()) || Validate.isNull(serialNum) || Validate.isNull(getPrice)) {
			showErrorMessage("저장 실패", "* 표시가 있는 항목은 꼭 작성해주세요!");
			return;
		}
		/** 가격에 숫자가 아닌 다른 문자열이 들어온 경우 */
		if (!Validate.onlyNumber(getPrice)) {
			showErrorMessage("저장 실패", "가격은 숫자로만 입력해주세요.");
			return;
		}
		/** 동일한 일련번호가 없으면 저장 */
		if (manager.add(name, serialNum, Double.parseDouble(getPrice), spec)) {
			showMessage("저장 성공", name + "이(가) 추가되었습니다.");
			Validate.initInformation(kindCB.getParent());
			return;
		}
		/** 동일한 일련번호가 있으면 저장 실패 */
		showErrorMessage("저장 실패", "존재하는 일련번호 입니다.");
	}

	/** 악기 종류 선택에 따른 활성화 유무 */
	public void checkKind() {
		switch (kindCB.getSelectedIndex()) {
		case 0:
			/** 종류가 기타일 경우 */
			styleCB.setEnabled(false);
			typeCB.setEnabled(true);
			break;
		case 1:
			/** 종류가 만돌린일 경우*/
			styleCB.setEnabled(true);
			typeCB.setEnabled(false);
			break;
		}
	}

	/** 성공 메시지 창 띄우기 */
	public void showMessage(String title, String message) {
		JOptionPane.showMessageDialog(this, message, title, JOptionPane.PLAIN_MESSAGE);
	}

	/** 에러 메시지 창 띄우기 */
	public void showErrorMessage(String title, String message) {
		JOptionPane.showMessageDialog(this, message, title, JOptionPane.WARNING_MESSAGE);
	}

}
