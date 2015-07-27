import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GridBagLayoutFrame extends Frame {
	Button button1, button2, button3, button4;
	
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	public GridBagLayoutFrame() {
		// TODO Auto-generated constructor stub
		this("grid Bag Test");
	}
	public GridBagLayoutFrame(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		button1 = new Button("Button1");
		button2 = new Button("Button2");
		button3 = new Button("Button3");
		button4 = new Button("Button4");

		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
	}
	
	public void setComponents(){
		setLayout(gridBagLayout);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
//		gridBagConstraints.fill = GridBagConstraints.NONE;
		add(button1, 0, 0, 2, 1, 0.7, 0.7);
		add(button2, 2, 0, 1, 2, 0.3, 1.0);
		add(button3, 0, 1, 1, 1, 0.3, 0.3);
		add(button4, 1, 1, 1, 1, 0.3, 0.3);
	}
	
	/**
	 * 그리드 백 레이아웃 적용
	 * @param component
	 * @param gridX
	 * @param gridY
	 * @param gridWidth
	 * @param gridHeight
	 * @param weightX
	 * @param weightY
	 */
	private void add(Component component, int gridX, int gridY, int gridWidth, int gridHeight, double weightX, double weightY){
		gridBagConstraints.gridx = gridX;
		gridBagConstraints.gridy = gridY;
		gridBagConstraints.gridwidth = gridWidth;
		gridBagConstraints.gridheight = gridHeight;
		gridBagConstraints.weightx = weightX;
		gridBagConstraints.weighty = weightY;
		
		gridBagLayout.setConstraints(component, gridBagConstraints);
		add(component);
	}
	
	public void exit(){
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	public void eventRegist(){
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				exit();
			}
		});
	}
	
	public static void main(String[] args) {
		GridBagLayoutFrame ui = new GridBagLayoutFrame();
		ui.setComponents();
		ui.setSize(400,300);
		ui.setVisible(true);
		ui.eventRegist();
	}
	

}
