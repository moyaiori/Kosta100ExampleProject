package kr.or.kosta.ims.view;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kr.or.kosta.ims.model.InstrumentSpecification;
import kr.or.kosta.ims.model.InstrumentSpecification.Builders;
import kr.or.kosta.ims.model.InstrumentSpecification.Instruments;
import kr.or.kosta.ims.model.InstrumentSpecification.Styles;
import kr.or.kosta.ims.model.InstrumentSpecification.Types;
import kr.or.kosta.ims.model.InstrumentSpecification.Woods;
import kr.or.kosta.ims.model.Inventory;

public class RegistPanel extends JPanel {
    JLabel kindL, serialL, builderL, modelL, priceL, typeL, topWoodL,
            backWoodL, styleL;
    JButton registB, cancleB;
    JTextField serialTF, modelTF, priceTF;

    JComboBox<Instruments> kindCom;
    JComboBox<Builders> kindBuilder;
    JComboBox<Types> kindType;
    JComboBox<Woods> kindWood;
    JComboBox<Woods> kindWood2;
    JComboBox<Styles> kindStyle;
    JPanel buttonP;
    Inventory manager;

    GridBagLayout bag;
    GridBagConstraints con;

    public RegistPanel(Inventory manager) {
        this.manager = manager;

        kindL = new JLabel("악기종류");
        serialL = new JLabel("일련번호");
        builderL = new JLabel("제조사");
        modelL = new JLabel("모델명");
        priceL = new JLabel("가 격");
        typeL = new JLabel("유 형");
        topWoodL = new JLabel("재질(앞)");
        backWoodL = new JLabel("재질(뒤)");
        styleL = new JLabel("스타일");

        registB = new JButton("등 록");
        cancleB = new JButton("취 소");

        serialTF = new JTextField();
        modelTF = new JTextField();
        priceTF = new JTextField();

        buttonP = new JPanel();
        bag = new GridBagLayout();
        con = new GridBagConstraints();

        kindCom = new JComboBox<Instruments>(Instruments.values());
        kindBuilder = new JComboBox<Builders>(Builders.values());
        kindType = new JComboBox<Types>(Types.values());
        kindWood = new JComboBox<Woods>(Woods.values());
        kindWood2 = new JComboBox<Woods>(Woods.values());
        kindStyle = new JComboBox<Styles>(Styles.values());
        setComponents();
        eventRegist();

    }

    public void setComponents() {

        buttonP.add(registB);
        buttonP.add(cancleB);
        buttonP.setLayout(new FlowLayout());

        setLayout(bag);
        con.fill = GridBagConstraints.BOTH;
        con.insets = new Insets(3, 5, 3, 5);

        add(kindL, 0, 0, 2, 1, 0.0, 0.0);
        add(kindCom, 2, 0, 2, 1, 0.0, 0.0);
        add(new JLabel(" "), 4, 0, 2, 1, 0.1, 0.0);
        add(builderL, 6, 0, 2, 1, 0.0, 0.0);
        add(kindBuilder, 8, 0, 2, 1, 0.0, 0.0);
        add(serialL, 0, 1, 2, 1, 0.0, 0.0);
        add(serialTF, 2, 1, 2, 1, 1.0, 0.0);
        add(new JLabel(" "), 4, 1, 2, 1, 0.1, 0.0);
        add(modelL, 6, 1, 2, 1, 0.0, 0.0);
        add(modelTF, 8, 1, 2, 1, 1.0, 0.0);
        add(priceL, 0, 2, 2, 1, 0.0, 0.0);
        add(priceTF, 2, 2, 2, 1, 1.0, 0.0);
        add(new JLabel(" "), 4, 2, 2, 1, 0.1, 0.0);
        add(typeL, 6, 2, 2, 1, 0.0, 0.0);
        add(kindType, 8, 2, 2, 1, 0.0, 0.0);
        add(topWoodL, 0, 3, 2, 1, 0.0, 0.0);
        add(kindWood, 2, 3, 2, 1, 0.0, 0.0);
        add(new JLabel(" "), 4, 3, 2, 1, 0.1, 0.0);
        add(backWoodL, 6, 3, 2, 1, 0.0, 0.0);
        add(kindWood2, 8, 3, 2, 1, 0.0, 0.0);
        add(styleL, 0, 4, 2, 1, 0.0, 0.0);
        add(kindStyle, 2, 4, 2, 1, 0.0, 0.0);
        add(new JLabel(" "), 4, 4, 6, 1, 0.1, 0.0);
        add(buttonP, 0, 5, 10, 1, 0.0, 0.0);

    }

    private void add(Component com, int gridX, int gridY, int gridwidth,
            int gridheight, double weightx, double weighty) {
        con.weightx = weightx;
        con.weighty = weighty;

        con.gridx = gridX;
        con.gridy = gridY;
        con.gridwidth = gridwidth;
        con.gridheight = gridheight;

        bag.setConstraints(com, con);
        add(com);
    }

    // 기타 선택 시 스타일콤보박스 비활성화 기능

    public void setEnabled() {
        if (kindCom.getSelectedItem() == Instruments.GUITAR) {
            kindStyle.setEnabled(false);
        } else {
            kindStyle.setEnabled(true);
        }
    }

    // 악기 등록 기능

    public void registInstrument() {

        Long price = Long.parseLong(priceTF.getText());
        Instruments instruments = (Instruments) kindCom.getSelectedItem();
        InstrumentSpecification spec = new InstrumentSpecification();
        spec.setProperties("제조사", kindBuilder.getSelectedItem());
        spec.setProperties("악기종류", kindCom.getSelectedItem());
        spec.setProperties("모델명", modelTF.getText());
        spec.setProperties("유형", kindType.getSelectedItem());
        spec.setProperties("재질(앞)", kindWood.getSelectedItem());
        spec.setProperties("재질(뒤)", kindWood2.getSelectedItem());
        if (kindCom.getSelectedItem() == Instruments.GUITAR) {
            manager.add(instruments, serialTF.getText(), price, spec);
            JOptionPane.showMessageDialog(this, "등록되었습니다.");
        } else if (kindCom.getSelectedItem() == Instruments.MANDOLIN) {
            spec.setProperties("스타일", kindStyle.getSelectedItem());
            manager.add(instruments, serialTF.getText(), price, spec);
            JOptionPane.showMessageDialog(this, "등록되었습니다.");
        } else if (kindCom.getSelectedItem() == Instruments.전체) {
            JOptionPane.showMessageDialog(this, "악기종류를 선택해주세요");
        }

    }

    public void eventRegist() {

        // 등록버튼 기능
        registB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                registInstrument();

            }
        });

        // 악기종류선택 기능
        kindCom.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                setEnabled();

            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Inventory manager = new Inventory();
        RegistPanel mp = new RegistPanel(manager);
        frame.add(mp);
        frame.setSize(600, 480);
        frame.setVisible(true);
    }

}
