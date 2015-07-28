import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EmailPanel extends Panel {
	
	
	Label receiverLabel, attachLabel, titleLabel;
	TextField receiverTF, attachTF, titleTF;
	Button searchB;
	TextArea contentsTA;
	
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	public EmailPanel(){
		receiverLabel = new Label("받는사람");
		receiverTF = new TextField();
		
		attachLabel = new Label("첨부파일");
		attachTF = new TextField();
		searchB = new Button("찾  기");
		
		titleLabel = new Label("제목");
		titleTF = new TextField();
		
		contentsTA = new TextArea();
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		setComponents();
	}
	
	public void setComponents(){
		setLayout(gridBagLayout);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.insets = new Insets(3, 5, 3, 5);
		
		add(receiverLabel, 0, 0, 1, 1, 0.0, 0.0);
		add(receiverTF,    1, 0, 1, 1, 1.0, 0.0);
		add(attachLabel,   0, 1, 1, 1, 0.0, 0.0);
		add(attachTF,      1, 1, 1, 1, 1.0, 0.0);
		add(searchB,       2, 1, 1, 1, 0.0, 0.0);
		add(new Label(" "),3, 1, 1, 1, 0.1, 0.0);
		add(new Label(" "),4, 1, 1, 1, 0.1, 0.0);
		add(titleLabel,    0, 2, 1, 1, 0.0, 0.0);
		add(titleTF,       1, 2, 4, 1, 1.0, 0.0);
		add(contentsTA,    0, 3, 5, 1, 1.0, 1.0);
	}
	
	/**
	 * 그리드백레이아웃 적용
	 * @param component
	 * @param gridx
	 * @param gridy
	 * @param gridwidth
	 * @param gridheight
	 * @param weightx
	 * @param weighty
	 */
	private void add(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty){
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth  = gridwidth;
		gridBagConstraints.gridheight  = gridheight;
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;
		gridBagLayout.setConstraints(component, gridBagConstraints);
		add(component);
	}
}







