public class ChatOn {

	public static void main(String[] args) {
		ChatFrame frame = new ChatFrame("화끈한 챗 되세요");
		
		frame.setSize(400, 500);
		frame.setComponents();
		
//		GuiUtil.setCenterScreen(frame);
		GuiUtil.setFullScreen(frame);
		
		frame.setVisible(true);
		frame.eventRegist();
	}

}
