package kr.or.kosta.ims.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import kr.or.kosta.ims.bin.IMS;
import kr.or.kosta.ims.util.GUIUtil;

public class LoginPanel extends JPanel {
    JLabel IDL, passL;
    JTextField IDTF;
    JPasswordField passTF;
    JButton loginB, adminRegistB;
    Image loginImage;
    
    GridBagLayout bag;
    GridBagConstraints con;

    // LoginPanel 생성자

    public LoginPanel() {
        
        
        IDL = new JLabel("아이디");
        passL = new JLabel("비밀번호");
        IDTF = new JTextField();
        passTF = new JPasswordField('♥');
        loginB = new JButton("로그인");
        adminRegistB = new JButton("관리자등록");
        
        bag = new GridBagLayout();
        con = new GridBagConstraints();
        
        URL url = getClass().getResource("/images/Login.png");
        loginImage = Toolkit.getDefaultToolkit().getImage(url);

        setComponents();
        eventRegist();
    }

    // LoginPanel 화면구성
    public void setComponents() {
        setLayout(bag);
        con.fill = GridBagConstraints.BOTH;
        con.insets = new Insets(10, 10 , 10, 10);
        
        Font font = new Font("나눔고딕", Font.BOLD, 14);
        IDL.setForeground(Color.blue);
        IDL.setBackground(Color.WHITE);
        passL.setForeground(Color.blue);
        IDL.setFont(font);
        passL.setFont(font);
        
        add(new JLabel(""), 0, 0, 10, 1, 0.0, 0.0);
        add(new JLabel(""), 0, 1, 10, 1, 0.0, 0.0);
        add(new JLabel(""), 0, 2, 10, 1, 0.0, 0.0);
        add(new JLabel(""), 0, 3, 2, 1, 0.0, 0.0);
        add(IDL, 2, 3, 2, 1, 0.0, 0.0);
        add(IDTF, 4, 3, 4, 1, 0.0, 0.0);
        add(new JLabel(""), 6, 3, 2, 1, 0.0, 0.0);
        add(new JLabel(""), 0, 4, 2, 1, 0.0, 0.0);
        add(passL, 2, 4, 2, 1, 0.0, 0.0);
        add(passTF, 4, 4, 4, 1, 0.0, 0.0);
        add(new JLabel(""), 6, 4, 2, 1, 0.0, 0.0);
        add(new JLabel(""), 0, 5, 3, 1, 0.0, 0.0);
        add(loginB, 3, 5, 1, 1, 0.0, 0.0);
        add(adminRegistB, 4, 5, 1, 1, 0.0, 0.0);
        add(new JLabel(""), 6, 5, 2, 1, 0.0, 0.0);
        add(new JLabel(""), 0, 6, 10, 1, 0.0, 0.0);
        add(new JLabel(""), 0, 7, 10, 1, 0.0, 0.0);
        add(new JLabel(""), 0, 8, 10, 1, 0.0, 0.0);
    }

    // GridbagLayout 설정
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

    public void eventRegist() {
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(loginImage, 0 , 0, getWidth(), getHeight(), this);
        
    }
    
//    @Override
//    public void paint(Graphics g) {
//         g.drawImage(loginImage, 0 , 0, getWidth(), getHeight(), this);
//         setOpaque(false);
//         super.paint(g);
//    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        LoginPanel mp = new LoginPanel();
        frame.add(mp);
        frame.setSize(500, 400);
        frame.setVisible(true);
    }
}
