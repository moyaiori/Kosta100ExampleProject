package kr.or.kosta.ims.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kr.or.kosta.ims.model.InstrumentSpecification;
import kr.or.kosta.ims.model.Inventory;
import kr.or.kosta.ims.model.InstrumentSpecification.Builders;
import kr.or.kosta.ims.model.InstrumentSpecification.Instruments;
import kr.or.kosta.ims.model.InstrumentSpecification.Styles;
import kr.or.kosta.ims.model.InstrumentSpecification.Types;
import kr.or.kosta.ims.model.InstrumentSpecification.Woods;
import kr.or.kosta.ims.util.GUIUtil;

public class MainFrame extends Frame {
    Inventory manager;
    MainPanel mainP;
    JPanel northP;
    JLabel loginL;
    JButton logoutB;

    public MainFrame() {
        this("악기재고관리시스템_메인화면");
    }

    public MainFrame(String title) {
        super(title);
        manager = new Inventory();
        mainP = new MainPanel(manager);
        northP = new JPanel();

        loginL = new JLabel("김운영 로그인 중..");
        logoutB = new JButton("로그 아웃");
        
    

    }

    public void setComponents() {
        Font font = new Font("나눔고딕", Font.BOLD, 14);
        loginL.setFont(font);
        northP.setLayout(new GridLayout(1,5));
        northP.add(loginL);
        northP.add(new JLabel());
        northP.add(new JLabel());
        northP.add(logoutB);
        add(northP, BorderLayout.NORTH);
        add(mainP, BorderLayout.CENTER);
        

    }
    
    public void loginFrame(){
        LoginFrame frame = new LoginFrame();
        frame.setComponents();
        frame.setSize(400, 300);
        GUIUtil.setCenterScreen(frame);
        GUIUtil.setLookNFeel(frame, GUIUtil.THEME_NIMBUS);
        frame.eventRegist();
        frame.setVisible(true);
        setVisible(false);
        dispose();
    }

    // 화면 종료 기능
    public void exit() {
        setVisible(false);
        dispose();
        System.exit(0);
    }

    public void eventRegist() {

        // 화면 종료
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                exit();
            }
        });
        
        logoutB.addActionListener(new ActionListener() {
            
            
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFrame();
                
            }
        });
    }

}
