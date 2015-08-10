package ko.or.kosta.ams.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
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

import ko.or.kosta.ams.util.Validator;
import kr.or.kosta.ams.model.Account;
import kr.or.kosta.ams.model.AccountDao;
import kr.or.kosta.ams.model.AccountManager;
import kr.or.kosta.ams.model.MinusAccount;

/**
 * 상단의
 * 
 * @author Lee Gwangyong
 *
 */
public class MainPanel extends Panel {
	JLabel accKindLB, accNumLB, accOwnrLB, passLB, accDrawMoneyLB, accBrowLB;
	JTextField accNumTF, accOwnrTF, passTF, accDrawMoneyTF, accBrowTF;
	JButton accLookUp, accDelete, accSearch, accNew, accAllLookUp;
	JComboBox<String> accKindC;
	JLabel accList, money;

	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;

	AccountDao fileManager;

	AccountTableModel accModel;
	JTable showTB;

	JScrollPane scrollP;
	/** 스크롤추가 */
	JPanel tableP;

	/** 테이블 패널 */

	public MainPanel() {
		this(null);
	}

	public MainPanel(AccountDao fileManager) {
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

		accModel = new AccountTableModel();
		showTB = new JTable(accModel);
		scrollP = new JScrollPane(showTB);
		// scrollP.setBorder(new TitledBorder("계좌목록 (단위 : 원)"));
		tableP = new JPanel();

		this.fileManager = fileManager;
		// showTB = new JTable(5,5);

		setComponents();
		eventRegist();

		// testData();
		printAllAccount();
	}

	/**
	 * 화면 구성
	 */
	public void setComponents() {

		setLayout(gridBagLayout);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.insets = new Insets(3, 5, 3, 5);

		tableP.setLayout(new BorderLayout());
		tableP.add(scrollP);

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
		add(accAllLookUp, 4, 4, 1, 1, 0.0, 0.0);
		add(new Label(" "), 5, 4, 1, 1, 0.0, 0.0);

		add(accList, 0, 5, 1, 1, 0.0, 0.0);
		add(money, 5, 5, 1, 1, 0.0, 0.0);

		// add(showTB, 0, 6, 6, 1, 1.0, 1.0);
		add(tableP, 0, 6, 6, 1, 1.0, 1.0);

	}

	/**
	 * 그리드 백 구성
	 * 
	 * @param component
	 * @param gridx
	 * @param gridy
	 * @param gridwidth
	 * @param gridheight
	 * @param weightx
	 * @param weighty
	 */
	private void add(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx,
			double weighty) {
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;
		gridBagLayout.setConstraints(component, gridBagConstraints);
		add(component);
	}

	/**
	 * 테스트용 데이터
	 */

	private void testData() {
		try {
			fileManager.saveAccRecord(new Account("1111-1111", "이광용", 1234, 100000));
			fileManager.saveAccRecord(new Account("2222-2222", "가승호", 1234, 1000000));
			fileManager.saveAccRecord(new MinusAccount("3333-3333", "안상이", 1234, 1000, 600));
			fileManager.saveAccRecord(new MinusAccount("4444-4444", "조현빈", 1234, 10000, 6000));
			fileManager.saveAccRecord(new MinusAccount("5555-5555", "조현빈", 1234, 10000, 6000));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// **********************************************************
	// ***************이벤트 처리 부분 메서드화******************
	// **********************************************************

	/**
	 * 입출금 계좌선택시 대출금액 선택 불가
	 */
	private void setEnableBrowTF(boolean bool) {
		if (bool) {
			accBrowTF.setEnabled(false);
		} else {
			accBrowTF.setEnabled(true);
		}
	}

	/**
	 * 전체 계좌 조회(전체조회)
	 */
	private void printAllAccount() {
		try {
			accModel.resultAccountList(fileManager.getRecords());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 검색한 계좌로 보여주기 (조회)
	 */
	private void lookUpAccount(String accNum) {
		Account acc;
		try {
			acc = fileManager.getAccount(accNum);
			if (acc == null) {

			}
			accModel.resultAccount(acc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 계좌 삭제(삭제)
	 */
	private void removeAccount(String accNum) {
		try {
			fileManager.removeAccount(accNum);
			accModel.resultAccountList(fileManager.getRecords());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 예금주 명으로 검색하기 (검색)
	 */
	private void searchAccount(String accOwner) {
		List<Account> list;
		try {
			list = fileManager.searchAccount(accOwner);
			accModel.resultAccountList(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 입출금 계좌 개설 (신규등록)
	 */
	private void openAcction() {
		// TODO 성공 여부에 따른 팝업창 구현
		try {
			fileManager.saveAccRecord(new Account(accNumTF.getText(), accOwnrTF.getText(),
					Integer.parseInt(passTF.getText()), Long.parseLong(accDrawMoneyTF.getText())));
			accModel.resultAccountList(fileManager.getRecords());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 마이너스 계좌 개설 (신규등록)
	 */
	private void openMinusAcction() {
		// TODO 성공 여부에 따른 팝업창 구현
		try {
			fileManager.saveAccRecord(
					new MinusAccount(accNumTF.getText(), accOwnrTF.getText(), Integer.parseInt(passTF.getText()),
							Long.parseLong(accDrawMoneyTF.getText()), Long.parseLong(accBrowTF.getText())));
			accModel.resultAccountList(fileManager.getRecords());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// *********************************************************
	// ***********************이벤트 등록***********************
	// *********************************************************

	public void eventRegist() {
		// 입출금계좌 텍스트필드 활성화 이벤트
		accKindC.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getItem() == "입출금계좌") {
					setEnableBrowTF(true);
				} else {
					setEnableBrowTF(false);
				}
			}
		});

		// 계좌 번호 조회 (조회)
		accLookUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (accNumTF.getText().matches("\\d{4}\\-\\d{4}")) {
					if (Validator.isNull(accNumTF)) {
						JOptionPane.showMessageDialog(null, "계좌번호를 입력해주십시오", "계좌번호 조회 실패", JOptionPane.ERROR_MESSAGE);
					} else {
						lookUpAccount(accNumTF.getText());
					}
				}else{
					JOptionPane.showMessageDialog(null, "다음과 같은 형식으로 입력해주십시오\n1234-5678", "계좌 조회 실패", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		// 계좌 삭제(삭제)
		accDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Validator.isNull(accNumTF)) {
					JOptionPane.showMessageDialog(null, "계좌번호를 입력해주십시오", "계좌 삭제 실패", JOptionPane.ERROR_MESSAGE);
				} else {
					removeAccount(accNumTF.getText());
				}
			}
		});

		// 예금주명으로 검색(검색)
		accSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			if (accOwnrTF.getText().length() > 5) {
				if (accOwnrTF.getText().matches("^[가-힣]*$")) {
					if (Validator.isNull(accOwnrTF)) {
						JOptionPane.showMessageDialog(null, "예금주명을 입력해주십시오", "계좌 검색 실패", JOptionPane.ERROR_MESSAGE);
					} else {
						searchAccount(accOwnrTF.getText());
					}
				}else{
					JOptionPane.showMessageDialog(null, "한글만 입력하실수 있습니다.", "계좌 검색 실패", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null, "최대 5글자까지 입력하실수 있습니다.", "계좌 검색 실패", JOptionPane.ERROR_MESSAGE);
			}
				
				

			}
		});

		// 계좌 신규 등록(신규등록)
		accNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (accKindC.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "계좌종류를 선택해주십시오", "애러", JOptionPane.ERROR_MESSAGE);
				} else {
					if (accKindC.getSelectedItem() == "입출금계좌") {
						if (Validator.isNull(accNumTF) || Validator.isNull(accOwnrTF) || Validator.isNull(passTF)
								|| Validator.isNull(accDrawMoneyTF)) {
							JOptionPane.showMessageDialog(null, "입력정보가 부족합니다.", "일반 계좌 생성 실패",
									JOptionPane.ERROR_MESSAGE);
						} else {
							openAcction();
						}
					} else if (accKindC.getSelectedItem() == "마이너스계좌") {
						if (Validator.isNull(accNumTF) || Validator.isNull(accOwnrTF) || Validator.isNull(passTF)
								|| Validator.isNull(accDrawMoneyTF) || Validator.isNull(accBrowTF)) {
							JOptionPane.showMessageDialog(null, "입력정보가 부족합니다.", "마이너스 계좌 생성 실패",
									JOptionPane.ERROR_MESSAGE);
						} else {
							openMinusAcction();
						}
					} else {
						return;
					}
				}
			}

		});

		// 계좌 전체 조회(전체조회)
		accAllLookUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				printAllAccount();
			}
		});

	}

	// public static void main(String[] args) {
	// Frame frame = new Frame();
	// MainPanel mp = new MainPanel();
	// frame.add(mp);
	// frame.setSize(500, 400);
	// frame.setVisible(true);
	// }

}
