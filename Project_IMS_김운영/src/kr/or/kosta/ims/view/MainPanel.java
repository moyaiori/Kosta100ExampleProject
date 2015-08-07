package kr.or.kosta.ims.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import kr.or.kosta.ims.model.Inventory;

public class MainPanel extends JPanel {

    JTabbedPane tabPane;
    StockPanel stockP;
    RegistPanel registP;
    Inventory manager;
    
    public MainPanel(Inventory manager) {
        this.manager = manager;
        tabPane = new JTabbedPane();
        stockP = new StockPanel(manager);
        registP = new RegistPanel(manager);
        setComponents();
    }
    
    public void setComponents(){
        tabPane.addTab("악기재고현황", stockP);
        tabPane.addTab("신규악기등록", registP);
        add(tabPane, BorderLayout.CENTER);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Inventory manager = new Inventory();
        MainPanel mp = new MainPanel(manager);
        frame.add(mp);
        mp.setComponents();
        frame.setSize(500, 400);
        frame.setVisible(true);
    }
}
