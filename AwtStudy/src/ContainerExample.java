import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;

/**
 * 대화상자, 파일대화상자
 * @author Lee Gwangyong
 *
 */
public class ContainerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame frame = new Frame();
		Dialog dialog = new Dialog(frame, "공지사항", true);
		dialog.setSize(300, 300);
//		dialog.setVisible(true);
		
		FileDialog fd = new FileDialog(frame, "파일열기", FileDialog.SAVE);
//		FileDialog fd = new FileDialog(frame, "파일열기", FileDialog.LOAD);
		fd.setVisible(true);

	}

}
