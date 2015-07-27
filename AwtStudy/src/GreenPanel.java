import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;

public class GreenPanel extends Panel {
	
	Label label;
	
	public GreenPanel(){
		label = new Label("GREEN Panel");
		setComponents();
	}
	
	public void setComponents(){
		// 패널의 기본값으로 플로우 레이아웃이다.
		add(label);
		setBackground(Color.GREEN);
	}

}
