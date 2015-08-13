package ko.or.kosta.chat.client;

import java.net.UnknownHostException;

/**
 * 채팅 클라이언트 애플리케이션 클래스
 * @author Lee Gwangyong
 *
 */
public class KotalkClient {

	public static void main(String[] args) throws UnknownHostException {
		
		ChatUI ui = new ChatUI();
		ui.setComponents();
		ui.setSize(400, 550);
		GuiUtil.setCenterScreen(ui);
		GuiUtil.setLookNFeel(ui, GuiUtil.THEME_NIMBUS);
		ui.setVisible(true);
		ui.eventRegist();
	}
}
