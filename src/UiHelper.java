import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
// Handles User Interface of the tool
public class UiHelper {

	private static String HEXA_DECIMAL_FORMAT = "%02X";
	private static byte[] encryptedBytes;

	// Create a JPanel to hold components for the text field and encryptButton
	private static final JPanel encryptionPanel = new JPanel();
	// Create a plainTextLabel for the text field
	private static final JLabel encryptonlabel = new JLabel("AES Encryption:\n");

	// Create a plainTextLabel for the text field
	private static final JLabel plainTextLabel = new JLabel("PlainText:");

	// Create a text field
	private static final JTextField plainTextField = new JTextField(50);

	// Create a plainTextLabel for the text field
	private static final JLabel encryptionKey = new JLabel("Key:");
	// Create a text field
	private static final JTextField encryptionKeyField = new JTextField(50);

	// encrypted result
	private static final JLabel encryptedResultLbl = new JLabel("Encrypted result:");
	private static final JLabel encryptedResult = new JLabel("");

	// Create a encryptButton
	private static final JButton encryptButton = new JButton("Encrypt");

	// Create a JPanel to hold components for the plainTextLabel
	private static final JPanel decryptionPanel = new JPanel();

	// Create a plainTextLabel for the text field
	private static final JLabel decryptionlabel = new JLabel("AES Decryption:\n");

	// Create a plainTextLabel for the text field
	private static final JLabel cipherTextLabel = new JLabel("cipher Text:");
	// Create a text field
	private static final JTextField cipherTextField = new JTextField(50);

	// Create a plainTextLabel for the text field
	private static final JLabel decryptionKeyLable = new JLabel("Key:");

	// Create a text field
	private static final JTextField decryptionKeyField = new JTextField(50);

	// encrypted result
	private static final JLabel decryptedResultLbl = new JLabel("Decrypted result:");
	private static final JLabel decryptedResult = new JLabel("");

	// Create a encryptButton
	private static final JButton button2 = new JButton("Decrypt");
	
	
	public static JFrame createFrame() {
		JFrame frame = new JFrame("AES cryptosystem");

		// Set the size of the frame
		frame.setSize(600, 600);
		// Create a layout to hold both panels
		BoxLayout layout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		frame.setLayout(layout);
		// Set default close operation
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Make the frame visible
		frame.setVisible(true);
		return frame;
	}
	
	public static JPanel encryptionPanel() {

		// Add action listener to the encryptButton
		encryptButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleEncryption();
			}

			private void handleEncryption() {
				try {
					byte[] encryptedMessage = AesHelper.encrypt(plainTextField.getText(), encryptionKeyField.getText());
					encryptedBytes = encryptedMessage;
					String base64Message = Base64.getEncoder().encodeToString(encryptedMessage);
					encryptedResult.setText(stringToHexadecimal(base64Message));
					// set decryption field for user easiness
					cipherTextField.setText(stringToHexadecimal(encryptedResult.getText()));
					
					decryptionKeyField.setText(encryptionKeyField.getText());
				} catch (InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException | BadPaddingException
						| IllegalBlockSizeException e1) {
					e1.printStackTrace();
				}
			}
			
			private String stringToHexadecimal(String str) {
		        StringBuilder hex = new StringBuilder();
		        for (char ch : str.toCharArray()) {
					hex.append(String.format(HEXA_DECIMAL_FORMAT, (int) ch));
		        }
		        return hex.toString();
		    }

		});

		// Add components to the first panel
		encryptionPanel.add(encryptonlabel);
		encryptionPanel.add(plainTextLabel);
		encryptionPanel.add(plainTextField);
		encryptionPanel.add(encryptionKey);
		encryptionPanel.add(encryptionKeyField);
		encryptionPanel.add(encryptedResultLbl);
		encryptionPanel.add(encryptedResult);
		encryptionPanel.add(encryptButton);
		return encryptionPanel;
	}
	
	public static JPanel decryptionPanel() {

		// Add action listener to the encryptButton
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String decryptedMessage = AesHelper.decrypt(encryptedBytes,
							decryptionKeyField.getText());
					decryptedResult.setText(decryptedMessage);
				} catch ( NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | BadPaddingException
						| IllegalBlockSizeException e1) {
					e1.printStackTrace();
				}
			}
		});

		// Add components to the second panel
		decryptionPanel.add(decryptionlabel);
		decryptionPanel.add(cipherTextLabel);
		decryptionPanel.add(cipherTextField);
		decryptionPanel.add(decryptionKeyLable);
		decryptionPanel.add(decryptionKeyField);
		decryptionPanel.add(decryptedResultLbl);
		decryptionPanel.add(decryptedResult);
		decryptionPanel.add(button2);
		return decryptionPanel;
	}
}
