package kr.or.kosta.ims.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import kr.or.kosta.ims.model.Inventory;
import kr.or.kosta.ims.util.GUIUtil;

public class LoginFrame extends JFrame {

    LoginPanel loginP;

    public LoginFrame() {
        this("악기재고시스템_로그인");
    }

    public LoginFrame(String title) {
        super(title);
        loginP = new LoginPanel();
      
    }

    public void setComponents() {
        add(loginP);
    }

    // 다음 프레임 호출 메소드

    public void nextView() {
        MainFrame frame2 = new MainFrame();
        frame2.setSize(500, 400);
        frame2.setComponents();
        frame2.eventRegist();
        GUIUtil.setCenterScreen(frame2);
        GUIUtil.setLookNFeel(frame2, GUIUtil.THEME_NIMBUS);
        frame2.setVisible(true);
        setVisible(false);
        dispose();

    }

    public void exit() {
        setVisible(false);
        dispose();
        System.exit(0);
    }

    public void eventRegist() {

        // 로그인 버튼 이벤트 등록

        loginP.loginB.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                nextView();
            }
        });

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                exit();
            }
        });

    }

}
