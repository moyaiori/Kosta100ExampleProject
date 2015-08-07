package kr.or.kosta.ims.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import kr.or.kosta.ims.model.Instrument;
import kr.or.kosta.ims.model.InstrumentSpecification.Builders;
import kr.or.kosta.ims.model.InstrumentSpecification.Instruments;
import kr.or.kosta.ims.model.Inventory;

public class StockPanel extends Panel {

    JLabel kindL, serialL, builderL, modelL;
    JButton logoutB, searchB, allSearchB, browseB;
    JTextField serialTF, modelTF;

    JTable table;
    JScrollPane pane;

    InstrumentTableModel model;

    JPanel tableP;

    JComboBox<Instruments> kindCom;
    JComboBox<Builders> kindBuilder;

    Inventory manager;

    GridBagLayout bag;
    GridBagConstraints con;

    public StockPanel(Inventory manager) {
        this.manager = manager;
        manager.init();
        kindL = new JLabel("악기종류");
        serialL = new JLabel("일련번호");
        builderL = new JLabel("제조사");
        modelL = new JLabel("모델명");

        logoutB = new JButton("로그아웃");
        searchB = new JButton("조 회");
        allSearchB = new JButton("전체조회");
        browseB = new JButton("검 색");

        serialTF = new JTextField();
        modelTF = new JTextField();

        model = new InstrumentTableModel();

        table = new JTable(model);

        tableP = new JPanel();
        pane = new JScrollPane(table);

        bag = new GridBagLayout();
        con = new GridBagConstraints();

        kindCom = new JComboBox<Instruments>(Instruments.values());
        kindBuilder = new JComboBox<Builders>(Builders.values());

        setComponents();
        eventRegist();

    }

    public void setComponents() {
        table.setRowHeight(50);
        TableColumnModel tcm = table.getColumnModel();
        // TableColumn tc = tcm.getColumn(0);
        tcm.getColumn(0).setPreferredWidth(50);
        tcm.getColumn(1).setPreferredWidth(50);

        JTableHeader header = table.getTableHeader();
        header.setResizingAllowed(true);
        header.setReorderingAllowed(false);
        pane.setPreferredSize(new Dimension(450, 150));
        tableP.setBorder(new TitledBorder(new LineBorder(Color.gray, 1),
                "악기재고목록"));
        tableP.add(pane, BorderLayout.CENTER);

        setLayout(bag);
        con.fill = GridBagConstraints.BOTH;
        con.insets = new Insets(3, 5, 3, 5);

        add(kindL, 0, 0, 1, 1, 0.0, 0.0);
        add(kindCom, 1, 0, 1, 1, 0.0, 0.0);
        add(new JLabel(" "), 2, 0, 4, 1, 0.0, 0.0);
        add(serialL, 0, 1, 1, 1, 0.0, 0.0);
        add(serialTF, 1, 1, 1, 1, 0.0, 0.0);
        add(searchB, 2, 1, 1, 1, 0.0, 0.0);
        add(new JLabel(" "), 3, 1, 2, 1, 0.0, 0.0);
        add(allSearchB, 5, 1, 1, 1, 0.0, 0.0);
        add(tableP, 0, 2, 6, 1, 1.0, 1.0);
        add(builderL, 0, 6, 1, 1, 0.0, 0.0);
        add(kindBuilder, 1, 6, 1, 1, 0.0, 0.0);
        add(modelL, 2, 6, 1, 1, 0.0, 0.0);
        add(modelTF, 3, 6, 1, 1, 0.1, 0.0);
        add(new JLabel(" "), 4, 6, 1, 1, 0.0, 0.0);
        add(browseB, 5, 6, 1, 1, 0.0, 0.0);

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

    // 선택된 악기만 표시

    public void select() {
        List<Instrument> allList = manager.searchAll();
        List<Instrument> list = new ArrayList<Instrument>();
        if (kindCom.getSelectedIndex() == 0) {
            allSearch();
        } else if (kindCom.getSelectedIndex() == 1) {
            for (Instrument instrument : allList) {
                if (instrument.getSpecification().getProperty("악기종류")
                        .equals(Instruments.GUITAR)) {
                    list.add(instrument);

                }
            }
            model.allPrint(list);
        } else if (kindCom.getSelectedIndex() == 2) {
            for (Instrument instrument : allList) {
                if (instrument.getSpecification().getProperty("악기종류")
                        .equals(Instruments.MANDOLIN)) {
                    list.add(instrument);
                }
            }
            model.allPrint(list);
        }
    }

    // 시리얼 넘버 조회

    public void serialSearch() {
        Instrument instrument = manager.get(serialTF.getText());
        if (instrument != null) {
            model.print(instrument);
        } else if (instrument == null) {
            JOptionPane.showMessageDialog(serialTF, "입력하신 번호의 악기가 없어요");
        }

    }

    // 부분 서치

    public void search() {
        Object obj1 = kindBuilder.getSelectedItem();
        Object obj2 = modelTF.getText();
        List<Instrument> list = manager.search(obj1, obj2);
        if (!list.isEmpty()) {
            model.allPrint(list);
        } else if (list.isEmpty()) {
            JOptionPane.showMessageDialog(this, "입력하신 조건의 악기가 없어요");
        }
    }

    // 전체 재고 표시

    public void allSearch() {
        List<Instrument> allList = manager.searchAll();
        model.allPrint(allList);
    }

    public void eventRegist() {

        // 악기종류 선택 기능
        kindCom.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                select();

            }
        });

        // 전체조회 기능
        allSearchB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                allSearch();
            }
        });

        // 부분검색 기능
        browseB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                search();

            }
        });
        // 시리얼넘버 조회 기능
        searchB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                serialSearch();

            }
        });
    }

    public static void main(String[] args) {
        Inventory manager = new Inventory();
        manager.init();
        System.out.println(manager.getCount());
    }

}
