public class App {

	public static void main(String[] args) {
//		UserFrame frame = new UserFrame("상속 프레임");
		BorderLayoutFrame frame = new BorderLayoutFrame("보더레이아웃");
//		GridLayoutFrame frame = new GridLayoutFrame("그리드 레이아웃");
		
		frame.setSize(400, 500);
		frame.setComponents();
		frame.setVisible(true);
		
		frame.eventRegist();
	}

}
