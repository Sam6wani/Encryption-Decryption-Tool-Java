import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EncryptionDecryption {

 // Main Function
	public static void main(String[] args) {
		// Create a JFrame
		JFrame frame = UiHelper.createFrame();

		JPanel panel1 = UiHelper.encryptionPanel();
		JPanel panel2 = UiHelper.decryptionPanel();

		// Add panels to the frame
		frame.add(panel1);
		frame.add(panel2);

	}

	public static byte[] encrypt(String message, String encryptionKey) throws NoSuchPaddingException,
			NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
		return null;
	}

 
}
