package roger.coc.awt;

import javax.swing.JOptionPane;

/**
 * @author zirui.wzr
 * a massagebox
 */
public class MessageBox {
	
	public static boolean confirmationBox(String msg, String title) {
		int result = JOptionPane.showConfirmDialog(null, msg, title, JOptionPane.YES_OPTION);

		if (result == JOptionPane.YES_OPTION) {
			return true;
		} else {
			return false;
		}
	}
}
