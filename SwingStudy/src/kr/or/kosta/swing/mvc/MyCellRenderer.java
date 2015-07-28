package kr.or.kosta.swing.mvc;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
/**
 * 사용자 정의 ListCellRenderer
 * @author 김기정
 */
public class MyCellRenderer implements ListCellRenderer<String> {

	@Override
	// JList에 의해 자동 호출되는 콜백메소드
	public Component getListCellRendererComponent(JList<? extends String> list,
			String value, int index, boolean isSelected, boolean cellHasFocus) {
		
		System.out.println("getListCellRendererComponent() Called..");
		
//		JLabel render = new JLabel();
		JButton render = new JButton();
		render.setText(value);
		if (value.startsWith("김")) {
			render.setIcon(new ImageIcon("classes/images/icons4680.png"));
		} else if (value.startsWith("이")){
			render.setIcon(new ImageIcon("classes/images/icons5139.png"));
		} else {
			render.setIcon(new ImageIcon("classes/images/icons5063.png"));
		}
		
		if(isSelected){
			render.setOpaque(true);
			render.setBackground(Color.red);
			render.setForeground(Color.yellow);
		}
		return render;
	}

}
