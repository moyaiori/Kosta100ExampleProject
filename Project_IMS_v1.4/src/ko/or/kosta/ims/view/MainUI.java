package ko.or.kosta.ims.view;

/**
 * 탭팬 구성
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import ko.or.kosta.ims.model.Inventory;
import ko.or.kosta.ims.util.GuiUtil;

public class MainUI extends JPanel {
	
	JTabbedPane tabPane;
	JPanel panel;
	
	NewTabView newTabView;
	StockTabView stockTabView;
	
	Inventory inventory;
	
	public MainUI() {
		
		inventory = new Inventory();

		newTabView = new NewTabView(inventory);
		stockTabView = new StockTabView(inventory);
		
		tabPane = new JTabbedPane();
		tabPane.addTab("악기재고현황", stockTabView);
		tabPane.addTab("신규악기등록", newTabView);
		setComponents();
		stockTabView.eventRegist();
	}

	public void setComponents() {
		setLayout(new BorderLayout());
		add(tabPane);
	}
	
	
}
